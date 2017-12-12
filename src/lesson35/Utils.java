package lesson35;

import java.io.*;

/**
 * Created by user on 12.12.2017.
 */
public class Utils {
    public void writeToFile(String path, StringBuffer contentToWrite) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);

        } catch (IOException e) {
            throw new IOException("Can't write to file " + path);
        }
    }

    public void writeToFileWithClean(String path, StringBuffer contentToWrite) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.append(contentToWrite);

        } catch (IOException e) {
            throw new IOException("Can't write to file " + path);
        }
    }

    public StringBuffer readerData(String path) throws Exception {
        String line = "";
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {

                res.append(line);
                res.append("\r\n");
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + path + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + path + " failed");
        }
        System.out.println(res.length());
        return res;
    }

    public boolean checkWordOnLetters(String body) {
        char[] chars = body.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetter(ch))
                return false;
        }

        return true;
    }
    public boolean checkWordOnLetAndDigts(String body) {
        char[] chars = body.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetterOrDigit(ch))
                return false;
        }

        return true;
    }
    public boolean checkWordOnDigts(String body) {
        char[] chars = body.toCharArray();
        for (char ch : chars) {
            if (!Character.isDigit(ch))
                return false;
        }

        return true;
    }
}

