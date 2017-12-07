package lesson33.hw33;

import java.io.*;

/**
 * Created by user on 10.11.2017.
 */
public class Solution {

    public void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
            return;

        }
        BufferedReader br = new BufferedReader(reader);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Can't read file by path " + path);
        } finally {
            try {
                br.close();
                reader.close();
            } catch (IOException e) {
                System.err.println("File with path " + path + " not found");
            }
        }
    }
   public void readFileByConsolePath() throws IOException{
       System.out.println("Please, enter file path to enter:");
       InputStreamReader reader = new InputStreamReader(System.in);
       BufferedReader br  = new BufferedReader(reader);
       try{
           String path = br.readLine();
           readFile(path);
       } catch (IOException e){
           System.err.println("Can't read file by path " + br.readLine());
       }finally {
           try{
           reader.close();
           br.close();
           } catch(IOException e){
               System.err.println("Closing streams failed");
           }
       }

    }
}
