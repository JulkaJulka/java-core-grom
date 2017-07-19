package lesson17.hw17;

import java.util.Arrays;

import static lesson17.hw17.Solution1.*;

public class Test1 {
    public static void main(String[] args) {
      /* String str1 = "http://www.gromcode.org";
        String str2 = "https://www.gromcode.net";
        String str3 = "http://gromcode.com";
        String str4 = "https://gromcode.com";
        String str5 = "http://##bi@tovka..com";
        String str6 = "https://.org";
        String str7 = "";
        String str8 = "http://www.test.ghjjk";
        String str9 = "http:test.org";
        String str10 = "http://www.fghj123.net";

        System.out.println(str1 + " " + validate(str1));
        System.out.println(str2 + " " + validate(str2));
        System.out.println(str3 + " " + validate(str3));
        System.out.println(str4 + " " + validate(str4));
        System.out.println(str5 + " " + validate(str5));
        System.out.println(str6 + " " + validate(str6));
        System.out.println(str7 + " " + validate(str7));
        System.out.println(str8 + " " + validate(str8));
        System.out.println(str9 + " " + validate(str9));
        System.out.println(str10 + " " + validate(str10));

        String[] a = {"abc", "qwe", "hjk"};
        String b = "abc qwe hjk abc 1 abc 0965 gdkliccj qwe ";*/
        // System.out.println(sortString(b));
      /* String word = "151670";
        System.out.println(checkWordOnLettersDigits(word));*/

        String str = "fgh ert isdf lmcbv ert";
        // System.out.println(Arrays.toString(sortString(str)));

        mostCountedWords1(str);

/*int k = 0;
        int[] arr = {1,1,1,1,1,1,1,1};
        int[] res = {0,0,0,0,0};
        boolean bRep = false;
        for (int i = 0; i < mas.length ; i++) {
             if(arr[i] == 1){
                for (int j = i + 1; j < mas.length ; j++) {
                    if(mas[i] == mas[j]){
                        arr[i]++;
                        arr[j] = arr[i];
                        bRep = true;
                    }
                }

                if(arr[i] > 1){
                    res[k] = arr[i];
                    k = k + 1;
                    //System.out.println(mas[i] + " repeated " + arr[i]);

                }
            }

            if(!bRep){
                res[k] = 1;
            k++;
               // System.out.println(mas[i] + " no repition");
            }

        }
        System.out.println(Arrays.toString(res));*/

       /* int[] mas = {3, 7, 7, 7, 8, 8, 9, 10};
        System.out.println(Arrays.toString(mas));

        int count = 1;
        int uniqValue = 5;
        int res[] = new int[uniqValue];
        int k = 0;
        for (int i = 0; i < mas.length - 1; i++) {
            if (i == mas.length - 3) {
                res[k] = count;
                break;
            }
            for (int j = i + 1; j < mas.length; j++) {
                if (mas[i] == mas[j]) {
                    k = k;
                    count++;
                    if (k == uniqValue)
                        res[k] = count;
                } else if (mas[i] != mas[j]) {
                    res[k] = count;
                    k = k + 1;
                    i = i + 1;
                    count = count;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(res));*/
    }



    public static String[] sortString(String str) {
        String[] words = str.split(" ");
        // System.out.println(words);
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < words.length - 1; j++) {
                String a = words[j];
                String b = words[j + 1];
                if (a.compareTo(b) > 0) {
                    String word1 = a;
                    String word2 = b;
                    words[j] = b;
                    words[j + 1] = a;
                }
            }
        }
        return words;
    }}

