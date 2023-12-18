import java.util.Arrays;
import java.lang.Math;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Abby Miller (amm0257@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  01-18-21
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) throws IllegalArgumentException {
      if(a == null || a.length == 0) {
         throw new IllegalArgumentException("IAE");
      }
      else {
         int j = a[0];
         for (int i = 0; i < a.length; i++) {
            if (a[i] < j) {
               j = a[i];
            }
         }
         return j;
      }
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) throws IllegalArgumentException {
      if(a == null || a.length == 0) {
         throw new IllegalArgumentException("IAE");
      }
      else {
         int j = a[0];
         for (int i = 0; i < a.length; i++) {
            if (a[i] > j) {
               j = a[i];
            }
         }
         return j;
      }
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
      if(a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException("IAE");
      }
      else {
         int[]b = Arrays.copyOf(a, a.length);
         b = removeDuplicates(b, b.length);
         if(b == null || b.length == 0 || k < 1 || k > b.length) {
            throw new IllegalArgumentException("IAE");
         }
         return(b[k-1]);
      }
   }

   /**
   * Given the length of an array and the array, this program will
   * copy the array, sort it, remove duplicates, and then
   * return a temporary array.
   **/
   private static int[] removeDuplicates(int a[], int n)
   {
        // creating another array for only storing
        // the unique elements
      int[] b = a;
      Arrays.sort(b);
      int[] temp = new int[n];
      int j = 0;
   
      //Iterate through the array and determine which numbers are duplicates
      for (int i = 0; i < n - 1; i++) {
         if (b[i] != b[i + 1]) {
            temp[j++] = b[i];
         }
      }
   
      temp[j++] = b[n - 1];
   
      //j is the length of valid numbers because the array will be half empty
      int[] result = new int[j];
      
      //Create a new array that is trimmed
      for(int i = 0; i < result.length; i++) {
         result[i] = temp[i];
      }
      
      return result;
   }

   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
      if(a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException("IAE");
      }
      else {
         int[]b = Arrays.copyOf(a, a.length);
         b = removeDuplicates(b, b.length);
         if(b == null || b.length == 0 || k < 1 || k > b.length) {
            throw new IllegalArgumentException("IAE");
         }
         int x = b.length;
         return b[x - k];
      }
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) {
      if(a == null || a.length == 0) {
         throw new IllegalArgumentException("IAE");
      }
      else {
      /**count how many valid arguments are present in the array
       and then use that number to create a new array of valid length
       (0 if no valid arguments) then assign those numbers into the new array
       so first ill count with a for loop and then ill assign the values in
       a separate for loop **/
         int[] b = new int[a.length];
         int count = 0;
         for(int i = 0; i < a.length; i++) {
            if(a[i] >= low && a[i]<= high) {
               b[count] = a[i];
               count++;
            }
         }
      /** Trim array **/
         int[] c = new int[count];
         for(int i = 0; i < count; i++) {
            c[i] = b[i];
         }
         return c;
      }
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
      if(a == null || a.length == 0) {
         throw new IllegalArgumentException("IAE");
      }
      
      int max = Arrays.stream(a).max().getAsInt();
      if (key > max) {
         throw new IllegalArgumentException("IAE");
      }
      int i = a[0];
      for(int x : a) {
         if (x == key) {
            return x;
         }
         if (key - x > key - i && key - x < 0) {
            i = x;
         }
         if (key - i > 0) {
            i = x;
         }
      }
      return i;
   }
   
   

   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) {
      if(a == null || a.length == 0) {
         throw new IllegalArgumentException("IAE");
      }
      
      int min = Arrays.stream(a).min().getAsInt();
      if (key < min) {
         throw new IllegalArgumentException("IAE");
      }
      int i = a[0];
      for(int x : a) {
         if (x == key) {
            return x;
         }
         if (key - x < key - i && key - x > 0) {
            i = x;
         }
         if (key - i < 0) {
            i = x;
         }
      }
      return i;
   }

}
