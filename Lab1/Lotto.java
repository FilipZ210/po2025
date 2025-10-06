import java.util.Random;
import java.util.HashSet;

public class Lotto {
  public static void main(String[] args) {
  Random rand = new Random();
  HashSet<String> coupon = new HashSet<String>();
    
    for (int i =0; i <= 6; i++)  {
    int number = toString(rand.nextInt(50));
      coupon.add(number);
    }

  System.out.println(coupon);
  }
}