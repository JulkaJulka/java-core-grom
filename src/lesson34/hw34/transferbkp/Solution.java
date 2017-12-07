package lesson34.hw34.transferbkp;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 21.11.2017.
 */
public class Solution {
    public void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        validate(fileFromPath, fileToPath);
        writeToFile(fileToPath, readSearchStringFromFile(fileFromPath, word));

        try (BufferedReader brFrom = new BufferedReader(new FileReader(fileFromPath));
             BufferedReader brTo = new BufferedReader(new FileReader(fileToPath))) {
            String lineTo = brTo.readLine();
            String lineFrom = brFrom.readLine();
            System.out.println( lineFrom.replaceAll(lineTo, ""));


        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from filed " + " failed");
        }

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

    public StringBuffer readSearchStringFromFile(String path, String wordSearch) throws Exception {
        File fileFrom = new File(path);
        if (!fileFrom.exists())
            throw new Exception("File " + path + " does not exist");
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null && validateSentence(line)) {
                String[] sequences = line.split("\\.");

                for (String sq : sequences) {
                    String[] words = sq.split(" ");
                    {
                        for (String word : words) {
                            if (word.equals(wordSearch)) {
                                res.append("\n");
                                res.append(sq);
                                res.append(".");
                            }
                        }
                    }
                }
                return res;
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

    public boolean validateSentence(String str) {
        String[] strs = str.split("\\.");
        for (String sc : strs) {
            if (sc.length() > 10) {
                return true;
            }
        }
        return false;
    }
}
