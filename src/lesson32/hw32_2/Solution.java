package lesson32.hw32_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by user on 01.11.2017.
 */
public class Solution {

    public void readNumbers() throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        int[] nums = new int[10];
        int input = 0;
        int sum = 0;
        int n = 3;
        for (int i = 0; i <nums.length ; i++) {
            input = Integer.parseInt(br.readLine());
            if (input < 100) {
                nums[i] = input;
                sum = sum + nums[i];
            }
            if (input >= 100) {
                    i = i - 1;
                if (n == 0) {
                    System.out.println("Your numbers are wrong. Number of attempts exceeded");
                    break;
                }
                System.out.println("Your numbers are wrong. You have " + n + " attempts to try again");
                n--;
            }
        }
        if (n != 0) {
            for (int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
                System.out.print(nums[i] + " ");
            }
            System.out.println("Sum: " + sum);
        }
    }
}
