package lesson36.repository;

import lesson36.exception.BadRequestException;
import lesson36.model.Entity;
import lesson36.model.User;
import lesson36.model.UserType;
import lesson36.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 15.12.2017.
 */
public class GeneralRepository<T> {

    public static   String pathDB = "";
    private Utils utils = new Utils();


    public static void setPathDB(String pathDB) {
        GeneralRepository.pathDB = pathDB;
    }

    public <T extends Entity > Entity addEntity(Entity entity) throws Exception {
        //validate inputData
        generateId(entity);

        StringBuffer bf = new StringBuffer("");
        String string = entity.toString();

        bf.append("\r\n");
        bf.append(string);

        writeToFile(bf);

        return entity;
    }

    public void deleteEntity(Entity entity, User user) throws Exception {
        if (user.getUserType() != UserType.ADMIN)
            throw new Exception("Deleting  is not accessible to you");
        if (entity == null)
            throw new Exception("You didn't enter any data");

        ArrayList<Entity> entityArrayListBeforeDel = entityToArrayList();

        if (!entityArrayListBeforeDel.contains(entity.getId()))
            throw new Exception("Entity with id " + entity.getId() + " does not exist in DB");

        StringBuffer res = new StringBuffer();
        StringBuffer resBkp = new StringBuffer();
        for (Entity ent : entityArrayListBeforeDel) {

            resBkp.append(ent.toString());
            resBkp.append("\r\n");

            if (ent.getId() != entity.getId()) {
                res.append(ent.toString());
                res.append("\r\n");
            }
        }

        try{
            writeToCleanFile(res);
        } catch (IOException e){
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

    public <T extends Entity>  void  generateId(T t) throws Exception {
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
        for (Entity ent : entityToArrayList){
            if(ent.getId() == idEntity){
                return true;
            }
        }
        return false;
    }
    public ArrayList<Entity> entityToArrayList() throws Exception {
        ArrayList<Entity> entityArrayList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");
                Entity entity = formEntity(strs);
                entityArrayList.add(entity);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathDB + " failed");
        }

        return entityArrayList;
    }
    public Entity formEntity(String[] str) throws Exception {
        if (str.length == 0 || str == null )
            throw new Exception("Error of reading: Incorrect data");
        for (String el : str ){
            if(el == null){
                throw new BadRequestException("Error of reading: Incorrect data");
            }
        }
        Entity entity = new Entity();
        long id = Long.parseLong(str[0]);
        entity.setId(id);
        return entity;
    }

    public void writeToFile(StringBuffer contentToWrite) throws IOException{
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathDB, true))) {
            bufferedWriter.append(contentToWrite);

        } catch (IOException e) {
            throw new IOException("Can't write to file " + pathDB);
        }
    }

    public void writeToCleanFile(StringBuffer contentToWrite) throws IOException{
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

}
