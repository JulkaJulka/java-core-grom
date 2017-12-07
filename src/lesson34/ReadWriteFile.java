package lesson34;


import java.io.*;

/**
 * Created by user on 08.11.2017.
 */
public class ReadWriteFile {


    public void readFile(String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);}
        } catch (FileNotFoundException e){
            System.err.println("File does not exist");
        }catch (IOException e){
            System.err.println("Reading from filed " + path + " faild");
        }
    }

    public void writeFile(String path,String content) throws InterruptedException  {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))){
            bufferedWriter.append("\n");
            bufferedWriter.append(content);
        }catch (IOException e){
            System.err.println("Can't write to file");
        }
    }
}
