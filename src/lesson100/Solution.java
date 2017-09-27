package lesson100;

/**
 * Created by user on 22.09.2017.
 */
public class Solution<T> {
    public boolean compareIntArrays(int[] first, int[] second) {
        if (first == second)
            return true;
        if (first == null || second  ==null)
            return false;

        if (second.length != first.length)
            return false;

        for (int i=0; i < first.length; i++)
            if (first[i] != second[i])
                return false;

        return true;
    }

    public boolean compareStringArrays(String[] first, String[] second){
        if(first == second)
            return true;
        if(first ==null || second == null)
            return  false;
;
        if(second.length != first.length)
            return false;
        int index = 0;
        for (String s:first) {
            Object o1 = first[index];
            Object o2 = second[index];
            if (!(o1==null ? o2==null : o1.equals(o2)))

                return false;
        }
        return true;
    }

    public <T> boolean  compareArrays(T[] t1, T[] t2){
        if(t1 == t2)
            return true;
        if( t1 == null || t2 == null)
            return false;
        if(t2.length != t1.length)
            return false;
        int index = 0;
        for (T t: t1) {
            Object o1 = t1[index];
            Object o2 = t2[index];
            if (!(o1==null ? o2==null : o1.equals(o2)))
                return false;
            index++;
        }

        return true;

    }
}
