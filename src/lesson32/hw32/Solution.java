package lesson32.hw32;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by user on 31.10.2017.
 */
public class Solution {
    public void readNumbers() {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] nums = new int[10];
        int n = 3;
        int input = 0;

        for (int i = 0; i < nums.length; i++) {
            input = sc.nextInt();
            if (input < 100) {
                nums[i] = input;
                sum = sum + nums[i];
            }
            if (input >= 100) {
                if (i != 0)
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
