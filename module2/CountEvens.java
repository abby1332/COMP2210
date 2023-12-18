import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
/**
 * Count the number of even values in an array.
 *
 */
public class CountEvens {

    //  C O M P L E T E   T H I S    M E T H O D 

    /**
     * Returns the number of even values in the paramter.
     */
   public static int countEvens(int[] values) {
      int count = 0;
      for(int x : values) {
         if(x % 2 == 0) {
            count++;   
         }
      }
      return count;
   }
   
   public static <T extends Comparable<T>> 
            Collection<T> lessThanSubset(Collection<T> collection, T value) {
      ArrayList<T> result = new ArrayList<>();
        
        //Iterator<T> itr = collection.Iterator();
        //T x = null;
      for(T x : collection)  {
         if(x.compareTo(value) < 0) {
            result.add(x);   
         }
      }
      return result;
   }

}