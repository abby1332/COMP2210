import java.util.Arrays;
import java.util.Comparator;

/**
 * Binary search.
 */
public class BinarySearch {

   /**
    * Returns the index of the first key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      if(a == null || key == null || comparator == null) {
         throw new NullPointerException("NPE");
      }
      
      int right = a.length - 1;
      int left = 0;
      
      //Test first index
      if(comparator.compare(a[0], key) == 0) {
         return 0;
      }
      
      while (left <= right) {
         int middle = left + (right - left) / 2;
         int comparison = comparator.compare(a[middle], key);
        
         
         //otherwise
         
         //If element is smaller than mid,
         //then it must be on the left
         if (comparison < 0) {
            left = middle + 1;
         }
         
         //If element is greater than middle
         //it must be on the right
         else if (comparison > 0) {
            right = middle - 1;
         }
         //If all the numbers are the same, just keep going
         else if(comparator.compare(a[middle], a[middle - 1]) == 0) {
            right = middle - 1;
         }
         //If none of the above apply, then it must be middle
         else {
            return middle;
         }
      }
      return -1;
   }
    
    
   public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      if(a == null || key == null || comparator == null) {
         throw new NullPointerException("NPE");
      }
      int rememberMe = -1;
      int right = a.length - 1;
      int left = 0;
      
      //Test last index
      if(comparator.compare(a[a.length - 1], key) == 0) {
         return a.length - 1;
      }
         
      while (left <= right) {
         int middle = left + (right - left) / 2;
         int comparison = comparator.compare(a[middle], key);
        
         //otherwise
         
         //If element is smaller than mid,
         //then it must be on the left
         if (comparison < 0) {
            left = middle + 1;
         }
         
         //If element is greater than middle
         //it must be on the right
         else if (comparison > 0) {
            right = middle - 1;
         }
         //If all the numbers are the same, just keep going
         else if(comparator.compare(a[middle], a[middle + 1]) == 0) {
            left = middle + 1;
         }
         //If none of the above apply, then it must be middle
         else {
            rememberMe = middle;
            left = middle + 1;
         }
      }
      return rememberMe;
   }

}