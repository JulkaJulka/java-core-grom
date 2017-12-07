package lesson33;


import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by user on 08.11.2017.
 */
public class ReadWriteFile {


    public void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
            return;

        }
        BufferedReader br = new BufferedReader(reader);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from filed " + path + " faild");
        } finally {
            try {
                br.close();
                reader.close();
            } catch (IOException e) {
                System.err.println("File does not exist");
            }
        }
    }

    public void writeFile(String path,String content) throws InterruptedException {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
           // writer = new FileWriter(path, true);
           writer = new FileWriter(new File(path), true);
           bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append("\n");
            bufferedWriter.append(content);

        } catch (IOException e) {
            System.err.println("Can't write to file");
            return;

        } finally {
            try {
                bufferedWriter.close();
                writer.close();

            } catch (IOException e) {
                System.err.println("Closing streams failed");
            }

        }

    }
}
