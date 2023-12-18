/**
 * Implements shift-right behavior in an array.
 *
 */

public class ShiftRight {


    /**
     * Shifts the elements at a[index] through a[a.length - 2] one
     * position to the right. 
     */
   public static void shiftRight(Object[] array, int index) {
   
      Object[] temp = new Object[array.length];
      for(int i = 0; i < array.length; i++) {
         temp[i] = array[i];
      }
       
       
      for(int i = 0; i < array.length - 2; i++) {
         if(i < index) {
            array[i] = temp[i];
         }
         else {
            array[i + 1] = temp[i];   
         }
      }
      array[index] = null;
        
   
   }

}

