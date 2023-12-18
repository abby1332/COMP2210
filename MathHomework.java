import java.lang.Math;
public class MathHomework {
   public static void main(String[] args) {
      double current = 0;
      double total = 0;
      for(double n = 1; n <= 10; n++) {
         current += ( (2/Math.sqrt(n)) - (2/Math.sqrt(n+1)) );
         System.out.println("n = " + n + " " + current);
      }
   }

}