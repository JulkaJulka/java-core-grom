package lesson34.hw34.transfer;

import java.io.File;

/**
 * Created by user on 21.11.2017.
 */
public class Demo{
        public static void main(String[] args) throws Exception {
            Solution solution = new Solution();
               solution.transferFileContent("C:/Users/user/Desktop/testsub", "C:/Users/user/Desktop/testsubl");
            // System.out.println(solution.readFromFile("C:/Users/user/Desktop/testsub"));

            //  StringBuffer stringBuffer = new StringBuffer("C:/Users/user/Desktop/testsub");
            //  stringBuffer.replace(0,stringBuffer.length(),"");

        }
}
