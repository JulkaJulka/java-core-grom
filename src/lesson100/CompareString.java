package lesson100;

/**
 * Created by user on 22.09.2017.
 */
public class CompareString {

    public int compare(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();
        int min = Math.min(n1, n2);
        for (int i = 0; i < min; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);
                if (c1 != c2)
                    return c1 - c2;
            }
        }
        return n1 - n2;
    }

    public boolean compareStringArrays(String[] str1, String[] str2){
        if(str1 == str2)
            return true;
        if(str1 ==null || str2 == null)
            return  false;

        int length = str1.length;
        if(str2.length!= str1.length)
            return false;
        for (int i = 0; i < str1.length ; i++) {
            if(!(str1[i] == null ? str2[i] == null : str1.equals(str2)))
                return false;
        }
        return true;
    }

    public static boolean equals(Object[] a, Object[] a2) {
        if (a==a2)
            return true;
        if (a==null || a2==null)
            return false;

        int length = a.length;
        if (a2.length != length)
            return false;

        for (int i=0; i<length; i++) {
            Object o1 = a[i];
            Object o2 = a2[i];
            if (!(o1==null ? o2==null : o1.equals(o2)))
                return false;
        }

        return true;
    }

    public static boolean equals(int[] a, int[] a2) {
        if (a==a2)
            return true;
        if (a==null || a2==null)
            return false;

        int length = a.length;
        if (a2.length != length)
            return false;

        for (int i=0; i<length; i++)
            if (a[i] != a2[i])
                return false;

        return true;
    }
}
