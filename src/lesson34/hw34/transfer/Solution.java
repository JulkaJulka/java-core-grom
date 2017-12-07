package lesson34.hw34.transfer;

import java.io.*;

/**
 * Created by user on 21.11.2017.
 */
public class Solution {

    public void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        copyFileContent(fileFromPath, fileToPath);
        cleanFile(fileFromPath);
    }

    public void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        //проверить,есть ли файл
        //проверить права
        //счтать контент файла from
        //записать контент в файл to
        validate(fileFromPath, fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath));
    }

    public StringBuffer readFromFile(String path) throws Exception {
        File fileFrom = new File(path);
        if (!fileFrom.exists())
            throw new Exception("File " + path + " does not exist");
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append("\n");
                res.append(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from filed " + path + " failed");
        }
        return res;
    }

    public void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);

        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }

    public void cleanFile(String path) throws Exception {
        File file = new File(path);
        file.delete();
        File emptyFile = new File(path);
        emptyFile.createNewFile();
    }


    public void validate(String fileFromPath, String fileToPath) throws Exception {

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File + " + fileFrom + " does not exist");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File + " + fileTo + " does not exist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permission to be read");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileFrom + " does not have permission to be written");
        }
    }
}
