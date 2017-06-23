package lesson14;

/**
 * Created by user on 22.06.2017.
 */
public class Test implements Cloneable {
    private int someNumber;
    private String name;

    public Test(int someNumber, String name) {
        this.someNumber = someNumber;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public static void main(String[] args) throws Exception{
        Test test = new Test(10000, "name");
        test.getClass();
        System.out.println(test.toString());
        System.out.println(test.hashCode());

        Test test1 = (Test) test.clone();
        System.out.println(test1);
        System.out.println(test1.hashCode());
        System.out.println(test1.toString());
        test1.getClass();

       Test test2 = new Test(test.getSomeNumber(),test.getName());
        System.out.println(test2.toString());
        test2.getClass();
    }

    public int getSomeNumber() {
        return someNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "someNumber=" + someNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
