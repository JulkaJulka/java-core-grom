package lesson25;

/**
 * Created by user on 20.08.2017.
 */
public class TestClass<T, K, V> {
    public T doSomething1(T t){
        System.out.println("1");
        //logic
        return t;
    }

    public K doSomething2(K k){
        System.out.println("2");
        //logic2
        return k;
    }
    public V doSomething3(V v){
        System.out.println("3");
        //logic3
        return v;
    }
}
