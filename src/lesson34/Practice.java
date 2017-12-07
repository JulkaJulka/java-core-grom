package lesson34;

import java.io.*;

/**
 * Created by user on 20.11.2017.
 */
public class Practice {
    public static void main(String[] args) throws Exception {
copyFileContent("C:/Users/user/Desktop/test.txt", "C:/Users/user/Desktop/arraylist.txt");
   //     readFromFile("C:/Users/user/Desktop/ddd");
    }
    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        //проверить,есть ли файл
        //проверить права
        //счтать контент файла from
        //записать контент в файл to
        validate(fileFromPath, fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath));
    }

    private static  StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\r\n");
            }
            res.replace(res.length() - 1,res.length(),"");
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from filed " + path + " failed");
        }
        return res;
    }

    private static  void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        try {
            fileFrom.exists();
        } catch (Exception e){
            System.err.println("File + " + fileFrom + " does not exist");

        }

     /*   if (!fileFrom.exists()) {
            throw new FileNotFoundException("File + " + fileFrom + " does not exist");
        }*/
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File + " + fileTo + " does not exist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permossion to be read");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileFrom + " does not have permossion to be written");
        }
    }
}
