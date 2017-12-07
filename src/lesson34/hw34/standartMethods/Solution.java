package lesson34.hw34.standartMethods;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


/**
 * Created by user on 22.11.2017.
 */
public class Solution {
    public  void copyFileContent(String fileFromPath, String fileToPath)throws Exception  {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        Files.copy(fileFrom.toPath(),fileTo.toPath());

    }
    public void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws IOException{
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        FileUtils.copyFile(fileFrom,fileTo);
    }
}
