package lesson36.repository;

import lesson36.exception.BadRequestException;
import lesson36.model.Entity;
import lesson36.model.User;
import lesson36.model.UserType;
import lesson36.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by user on 15.12.2017.
 */
public class GeneralRepository<T> {

    public static String pathDB = "";
    private Utils utils = new Utils();
    public static int countFieldsOfObject;

    public static void setPathDB(String pathDB) {
        GeneralRepository.pathDB = pathDB;
    }


    public static void setCountFieldsOfObject(int countFieldsOfObject) {
        GeneralRepository.countFieldsOfObject = countFieldsOfObject;
    }

    public <T extends Entity> T addEntity(T t) throws Exception {

        if (t == null)
            throw new Exception("You enter wrong data");
        generateId(t);

        StringBuffer bf = new StringBuffer("");
        String string = t.toString();

       bf.append("\r\n");
        bf.append(string);

        writeToFile(bf);

        return t;
    }

    public void deleteEntity(Long id) throws Exception {
        if (id == null)
            throw new Exception("You didn't enter any data");

        ArrayList<Entity> entityArrayListBeforeDel = entityToArrayList();
        StringBuffer res = new StringBuffer();
        StringBuffer resBkp = new StringBuffer();
        int count = 0;
        for (Entity ent : entityArrayListBeforeDel) {

            resBkp.append(ent.toString());
            resBkp.append("\r\n");

            if (ent.getId() != id) {
                res.append(ent.toString());
                res.append("\r\n");
            }
            if (ent.getId() == id) {
                count++;
            }
        }
        res.delete(res.length() - 2, res.length());
        if (count < 1) {
            throw new Exception("Entity with id " + id + " does not exist in DB");
        }

        try {
            writeToCleanFile(res);
        } catch (IOException e) {
            writeToCleanFile(resBkp);
            throw new IOException("Can't write to file " + pathDB);
        }
    }

    public Entity findEntityById(Long idFind) throws Exception {
        checkId(idFind);
        ArrayList<Entity> entities = entityToArrayList();
        for (Entity ent : entities) {
            if (ent.getId() == idFind) {
                return ent;
            }
        }
        return null;
    }

    public <T extends Entity> void generateId(T t) throws Exception {
        long generateId;
        Random random = new Random();
        generateId = Math.abs(random.nextLong());

        while (checkPresenceId(generateId)) {
            generateId = Math.abs(random.nextLong());
        }
        t.setId(generateId);

    }

    public boolean checkPresenceId(long idEntity) throws Exception {
        checkId(idEntity);
        ArrayList<Entity> entityToArrayList = entityToArrayList();
        for (Entity ent : entityToArrayList) {
            if (ent.getId() == idEntity) {
                return true;
            }
        }
        return false;
    }

    public <T> ArrayList<T> entityToArrayList() throws Exception {
        ArrayList<T> arrayList = new ArrayList<>();
        StringBuffer stringBuffer = readFile();
        String strings = stringBuffer.toString();
        String[] strs = strings.split("\r\n");
        for (String el : strs) {
            String[] els = el.split(",");
            T object = (T) formEntity(els);
            arrayList.add(object);
        }

        return arrayList;
    }

    public <T extends Entity> T formEntity(String[] str) throws Exception {
        if (str.length == 0 || str == null)
            throw new Exception("Error of reading: Incorrect data");
        for (String el : str) {
            if (el == null) {
                throw new BadRequestException("Error of reading: Incorrect data");
            }
        }
        Entity entity = new Entity();
        T t = (T) entity;
        long id = Long.parseLong(str[0]);
        entity.setId(id);
        return t;
    }


    public StringBuffer readFile() throws Exception {
        if (pathDB == null)
            throw new Exception("Path doesn't exist");
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            String line;
            int numberLine = 0;
            while ((line = br.readLine()) != null) {
                numberLine++;
                checkLine(line, numberLine);
                stringBuffer.append(line);
                stringBuffer.append("\r\n");
            }
            stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from filed " + pathDB + " faild");
        }
        return stringBuffer;
    }

    public void writeToFile(StringBuffer contentToWrite) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathDB, true))) {
            bufferedWriter.append(contentToWrite);

        } catch (IOException e) {
            throw new IOException("Can't write to file " + pathDB);
        }
    }

    public void writeToCleanFile(StringBuffer contentToWrite) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathDB, false))) {
            bw.append(contentToWrite);
        } catch (IOException e) {
            throw new IOException("Can't write to file " + pathDB);
        }
    }

    private boolean checkId(Long id) throws Exception {
        if (id == null || id <= 0)
            throw new Exception("Id " + id + " is wrong");
        return true;
    }

    public boolean checkLine(String line, int numberLine) throws Exception {
        if (line == null || line.isEmpty())
            throw new BadRequestException("Wrong data in DB " + pathDB + " Line number: " + numberLine);

        String[] str = line.split(",");
        if (str.length != countFieldsOfObject)
            throw new BadRequestException("Wrong data in DB " + pathDB + " Line number: " + numberLine);
        for (String el : str) {
            if (el == null || el.isEmpty() )
                throw new BadRequestException("Wrong data in DB " + pathDB + " Line number: " + numberLine);
        }
        if (!utils.checkWordOnDigts(str[0]))
            throw new BadRequestException("Wrong data in DB " + pathDB + " Line number: " + numberLine);

        return true;
    }

}
