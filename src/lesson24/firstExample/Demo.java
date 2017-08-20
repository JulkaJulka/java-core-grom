package lesson24.firstExample;

/**
 * Created by user on 19.08.2017.
 */
public class Demo <T> {

   // private printUser(User user){
    // print
   // }

   // private printSolution(Solution solution){
   // print
    //}

     public void print(T t){
         System.out.println(t);
    }

    private static void calculatePrice(AbstractOrder abstractOrderOrder){
        System.out.println(abstractOrderOrder.getPrice());

    }
  //  private static void calculatePrice(SecondOrder secondOrder){
  //      System.out.println(secondOrder.getPrice());

  //  }

    public static void main(String[] args) {
        calculatePrice(new FirstOrder());
        calculatePrice(new SecondOrder());

    }
}
