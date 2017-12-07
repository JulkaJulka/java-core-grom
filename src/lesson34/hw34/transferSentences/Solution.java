package lesson34.hw34.transferSentences;

import lesson11.biginterfaceexample.*;

import java.io.*;
import java.io.File;
import java.io.FileReader;

/**
 * Created by user on 21.11.2017.
 */
public class Solution {
    public void transferSentences(String pathFrom, String pathTo, String wordSearch) throws Exception {
        validate(pathFrom, pathTo);
        File fileFrom = new File(pathFrom);
        File fileTo = new File(pathTo);
        if (!fileFrom.exists())
            throw new Exception("File " + pathFrom + " does not exist");
        if (!fileTo.exists())
            throw new Exception("File " + pathTo + " does not exist");
        StringBuffer searchSequences = new StringBuffer();
        StringBuffer changedFrom = new StringBuffer();
        StringBuffer sourceText = new StringBuffer();
        StringBuffer textToFileBefChanging = new StringBuffer();
        try (BufferedReader brPathFrom = new BufferedReader(new FileReader(pathFrom));
        BufferedReader brPathTo = new BufferedReader(new FileReader(pathTo))) {
            String line;
            while ((line = brPathTo.readLine()) != null){
                textToFileBefChanging.append(line);
            }
            while ((line = brPathFrom.readLine()) != null && validateSentence(line)) {
                sourceText.append(line);
                String[] sequences = line.split("\\.");
                for (String sq : sequences) {
                    if (!sq.contains(wordSearch)) {
                        changedFrom.append(sq);
                        changedFrom.append(".");
                    }
                    if (sq.contains(wordSearch)) {
                        searchSequences.append("\n");
                        searchSequences.append(sq);
                        searchSequences.append(".");
                    }
                }
                try {
                    writeToRecleanFile(pathFrom, changedFrom);
                } catch (Exception e) {
                    writeToRecleanFile(pathFrom,sourceText);
                    throw new IOException("Can't write to file " + pathTo);
                }
                try {
                    writeToFile(pathTo, searchSequences);
                } catch (Exception e) {
                    writeToRecleanFile(pathFrom, sourceText);
                    writeToRecleanFile(pathTo, textToFileBefChanging);
                    throw new IOException("Can't write to file " + pathTo);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + fileFrom +" does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from file " + pathFrom + " failed");
        }
    }

    public void writeToFile(String path, StringBuffer contentToWrite) throws IOException{
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);

        } catch (IOException e) {
            throw new IOException("Can't write to file " + path);
        }
    }

    public void writeToRecleanFile(String path, StringBuffer contentToWrite) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.append(contentToWrite);

        } catch (IOException e) {
            throw new IOException("Can't write to file " + path);
        }
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
