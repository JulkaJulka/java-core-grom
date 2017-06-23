package lesson14;
public class Demo {
    public static void main(String[] args) {
        Object objectTest = new Object();
        System.out.println(objectTest.toString());
        System.out.println(objectTest.getClass().getName());
        System.out.println(objectTest.getClass());

        objectTest = new Object();
        System.out.println(objectTest.toString());
        System.out.println(objectTest.getClass().getName());
        System.out.println(objectTest.getClass());

        Object objectTest2 = new Object();
        System.out.println(objectTest2.toString());
        System.out.println(objectTest2.getClass());
    }
}
