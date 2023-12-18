
public class ShiftRightClient {
   public static void main(String[] args) {
      Object[] a = new Object[10];
      
      for(int i = 0; i <6; i++) {
         a[i] = i;
      }
      
      System.out.println(a);
      
      ShiftRight.shiftRight(a, 2);
   
   }
}