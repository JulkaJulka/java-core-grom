package lesson33.writeToFileFromConsole;

import java.io.*;

/**
 * Created by user on 10.11.2017.
 */
public class Solution {
    public void writeToFileFromConsole(String path) {


        try {
            if (path == null || !(new File(path).exists())) {
                System.out.println("File with path " + path + " not found");
            } else {
                System.out.println("Enter file content to write in the file:");
                writeToExistFile(path);
            }

        } catch (IOException e) {
            System.err.println("Can't write to file with path " + path);
            return;
        }
    }

    public void writeToExistFile(String path) throws IOException {
        FileWriter writer = null;
        BufferedWriter bw = null;
        writer = new FileWriter(path, true);
        bw = new BufferedWriter(writer);

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String text = "";
        String end = "wr";
        try {
            while (!(text = br.readLine()).equals("wr")) {
                bw.append("\n");
                bw.append(text);
            }

        } catch (IOException e) {
            System.err.println("Can't write to file with path " + path);
        }

        try {
            br.close();
            reader.close();

        } catch (IOException e) {
            System.err.println("Closing streams failed");
        }
        try {
            if (bw != null) {
                bw.close();
            }
            if (writer != null) {
                writer.close();
            }

        } catch (IOException e) {
            System.err.println("Closing streams failed");
        }
    }
}
