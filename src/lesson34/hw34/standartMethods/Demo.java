package lesson34.hw34.standartMethods;

/**
 * Created by user on 22.11.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.copyFileContent("C:/Users/user/Desktop/test.txt", "C:/Users/user/Desktop/copytestJDK.txt");
        solution.copyFileContentApacheIO("C:/Users/user/Desktop/test.txt", "C:/Users/user/Desktop/copytestApache.txt");
    }
}
