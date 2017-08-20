package lesson25.hw25;

/**
 * Created by user on 20.08.2017.
 */
public class GeneralDAO<T> {
    private T[] array = (T[]) new Object[10];

    public T save(T t) throws Exception {
        if(t == null)
            throw new Exception("Object is not detected");
       /* if (t.getId() <= 0)
            throw new Exception("Id " + t.getId() +
                    " isn't unacceptable. Object can't save to DB with Id ");*/
        if (checkLimitation(array, t)) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    array[i] = t;
                    return t;
                }
            }

        }
        throw new Exception("DB is not empty");

    }

    public T[] getAll() {
        int countFullPosition = 0;
        for (T el : array) {
            if (el != null) {
                countFullPosition++;
            }
        }
        T[] arrayEmpty = (T[]) new Object[0];
        if (countFullPosition == 0)
            return arrayEmpty;
        // throw new InternalServerException("TransactionList is empty");
        T[] trList = (T[]) new Object[countFullPosition];
        int index = 0;
        for (T el : array) {
            if (el != null) {
                trList[index] = el;
                index++;
            }
        }
        return trList;
    }


    public boolean checkLimitation(T[] array, T t) throws Exception {
        if(t == null)
            throw new Exception("Object  is not detected");
        T saveObject = findObjectInDB(array, t);
        if (saveObject != null)
            throw new Exception("Object  " + t +
                    " already exists in DB. DB can't save the same objects.");
        if (!checkSizeOfDB(array))
            throw new Exception(("DB is full"));
        return true;
    }

    public T findObjectInDB(T[] array, T t) {
        if (array.length == 0)
            return null;

        for (int i = 0; i < array.length; i++) {
            for (T el : array) {
                if (el != null && el.equals(t))
                    return t;
            }

        }
        return null;

    }

    public boolean checkSizeOfDB(T[] array) throws Exception {
        if (array == null)
            return false;
        int countFullPositions = 0;

        for (T el : array) {
            if (el != null) {
                countFullPositions++;
            }
            if (countFullPositions == array.length)
                return false;

        }
        return true;
    }

}
