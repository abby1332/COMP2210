import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  YOUR NAME HERE (you@auburn.edu)
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
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
      if(coll == null || comp == null) {
         throw new IllegalArgumentException("IAE");
      }
      if(coll.isEmpty()) {
         throw new NoSuchElementException("NSE");
      }
      
      Iterator<T> itr = coll.iterator();
      T j = coll.iterator().next();
      T i = null;
      
      while (itr.hasNext()) {
         i = itr.next();
         if(comp.compare(i, j) < 0) {
            j = i;
         }
      }
      return j;      
   }


   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
      if(coll == null || comp == null) {
         throw new IllegalArgumentException("IAE");
      }
      if(coll.isEmpty()) {
         throw new NoSuchElementException("NSE");
      }
      
      Iterator<T> itr = coll.iterator();
      T j = coll.iterator().next();
      T i = null;
      
      while (itr.hasNext()) {
         i = itr.next();
         if(comp.compare(i, j) > 0) {
            j = i;
         }
      }
      return j; 
   }
   
   
   /**
   * Given a collection and comparator, this program will
   * copy the collection, sort it, remove duplicates, and then
   * return a temporary array.
   **/
   private static <T> Collection removeDuplicates(Collection<T> coll, Comparator<T> comp)
   {
      //Turn the collection into an array list
      Iterator<T> itr2 = coll.iterator();
      List<T> b = new ArrayList<T>();
      while (itr2.hasNext()) {
         b.add(itr2.next());
      }
      
      //Sort this list
      java.util.Collections.sort(b, comp);
      List<T> temp = new ArrayList<T>();
   
      // Traverse through the first list
      for (T element : b) {
      
            // If this element is not present in temp
            // then add it
         if (!temp.contains(element)) {
         
            temp.add(element);
         }
      }
      
      return temp;
   }

   

   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
      if(coll == null || comp == null) {
         throw new IllegalArgumentException("IAE");
      }
   //Check first if collection is empty
      if(coll.isEmpty()) {
         throw new NoSuchElementException("NSE");
      }
      //Now sort and remove duplicates
      Collection<T> b;
      b = coll;
      b = removeDuplicates(b, comp);
      //check if new array is empty and k is valid
      if (b.isEmpty() || b.size() == 0 || k < 1 || k > b.size()) {
         throw new NoSuchElementException("NSE");
      }
         
        //Iterate through the new array until we get to the kth value
      Iterator<T> itr = b.iterator();
      T result = null;
      for(int i = 0; i < k; i++) {
         result = itr.next();
      }
      return(result);
   }


   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
      if(coll == null || comp == null) {
         throw new IllegalArgumentException("IAE");
      }
      //Check first if collection is empty
      if(coll.isEmpty()) {
         throw new NoSuchElementException("NSE");
      }
      //Now sort and remove duplicates
      Collection<T> b;
      b = coll;
      b = removeDuplicates(b, comp);
      //check if new array is empty and k is valid
      if (b.isEmpty() || b.size() == 0 || k < 1 || k > b.size()) {
         throw new NoSuchElementException("NSE");
      }
         
        //Iterate through the new array until we get to the kth value
      Iterator<T> itr = b.iterator();
      T result = null;
      for(int i = b.size() + 1; i > k; i--) {
         result = itr.next();
      }
      return(result);
   }


   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param comp    the Comparator that defines the total order on T
    * @return        a Collection of values between low and high
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                                     Comparator<T> comp) {
      if(coll == null || comp == null) {
         throw new IllegalArgumentException("IAE");
      }
      //Check first if collection is empty
      if(coll.isEmpty()) {
         throw new NoSuchElementException("NSE");
      }
      
      // Create a new collection
      Collection<T> result = new ArrayList<T>();
      
      // If a value is bigger than or equal to low and less than or equal to high
      // add it to new collection
      T i = null;
      Iterator<T> itr = coll.iterator();
      while(itr.hasNext()) {
         i = itr.next();
         if(comp.compare(i, low) >= 0 && comp.compare(high, i) >= 0) {
            result.add(i);
         }
      }
      
      //If there are no values that fit the range, result will be empty
      if(result.isEmpty()) {
         throw new NoSuchElementException("NSE");
      }
      return result;
   
   }


   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
      //First check if comp or coll is null
      if(coll == null || comp == null) {
         throw new IllegalArgumentException("IAE");
      }
      if(coll.isEmpty()) {
         throw new NoSuchElementException("NSE");
      }
      
      //Find the maximum value in coll
      T max = null;
      Iterator<T> itr2 = coll.iterator();
      T value = itr2.next();
      max = value;
      while(itr2.hasNext()) {
         if(comp.compare(value, max) > 0) {
            max = value;
         }
         value = itr2.next();
      }
      
      //Make sure the key isnt greater than the max
      if (comp.compare(key, max) > 0) {
         throw new NoSuchElementException("NSE");
      }
      
      //Find a value greater than key to use for further comparisons
      Iterator<T> itr = coll.iterator();
      T x = null;
      while(itr.hasNext()) {
         x = itr.next();
         if(comp.compare(x, key) > 0) {
            break;
         }
      }
      //Iterate through coll if there is a value greater than key and less than x, it becomes x
      Iterator<T> itr3 = coll.iterator();
      T i = null;
      while(itr3.hasNext()) {
         i = itr3.next();
         if((comp.compare(i, key) > 0) && (comp.compare(i, x) < 0)) {
            x = i;
         }
         if(comp.compare(i, key) == 0) {
            return i;
         }
         if (comp.compare(x, key) == 0) {
            return x;
         }
      }
      return x;
   }


   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
       //First check if comp or coll is null
      if(coll == null || comp == null) {
         throw new IllegalArgumentException("IAE");
      }
      if(coll.isEmpty()) {
         throw new NoSuchElementException("NSE");
      }
      
      //Find the minimum value in coll
      T min = null;
      Iterator<T> itr2 = coll.iterator();
      T value = itr2.next();
      min = value;
      while(itr2.hasNext()) {
         if(comp.compare(value, min) < 0) {
            min = value;
         }
         value = itr2.next();
      }
      
      //Make sure the key isnt greater than the max
      if (comp.compare(key, min) > 0) {
         throw new NoSuchElementException("NSE");
      }
      
      //Find a value greater than key to use for further comparisons
      Iterator<T> itr = coll.iterator();
      T x = null;
      while(itr.hasNext()) {
         x = itr.next();
         if(comp.compare(x, key) < 0) {
            break;
         }
      }
      
      if(x == null) {
         throw new NoSuchElementException("NSE");
      }
      //Iterate through coll if there is a value greater than key and less than x, it becomes x
      Iterator<T> itr3 = coll.iterator();
      T i = null;
      while(itr3.hasNext()) {
         i = itr3.next();
         if((comp.compare(i, key) < 0) && (comp.compare(i, x) > 0)) {
            x = i;
         }
         if(comp.compare(i, key) == 0) {
            return i;
         }
         if (comp.compare(x, key) == 0) {
            return x;
         }
      }
      return x;
   }

}
