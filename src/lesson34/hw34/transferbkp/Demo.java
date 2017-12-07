package lesson34.hw34.transferbkp;

/**
 * Created by user on 21.11.2017.
 */
public class Demo{
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        // solution.transferFileContent("C:/Users/user/Desktop/testsub", "C:/Users/user/Desktop/testsubl");
        // System.out.println(solution.readFromFile("C:/Users/user/Desktop/testsub"));

        //  StringBuffer stringBuffer = new StringBuffer("C:/Users/user/Desktop/testsub");
        //  stringBuffer.replace(0,stringBuffer.length(),"");
        String  str = "I live in Kyiv.I live in Kyiv.I live in Kyiv. Kyiv is the capital of Ukraine. I neew you help.";
        // solution.searchNoRepeatSequences(str,"in");
        //  solution.readSearchStringFromFile("C://Users/user/Desktop/test23",  solution.searchNoRepeatSequences(,"Kyiv"));
        System.out.println("transfer sequence:");
        System.out.println(solution.readSearchStringFromFile("C://Users/user/Desktop/test24","Kyiv"));
        //  solution.readStringWithoutSearchWord("C://Users/user/Desktop/test24","Kyiv");
        System.out.println();
        System.out.println("replace: ");
        solution.transferSentences("C://Users/user/Desktop/test24","C://Users/user/Desktop/subl1","Kyiv");
    }

}
