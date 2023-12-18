import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
     
public class SelectorTest {

   /**
     * Defines a total order on integers as ascending natural order.
     */
   static Comparator<Integer> ascendingInteger =
        new Comparator<Integer>() {
           public int compare(Integer i1, Integer i2) {
              return i1.compareTo(i2);
           }
        };
     
     

   /** Testing min **/
   @Test public void minTest1() {
      /** basic test 1 **/
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(2);
      testList.add(8);
      testList.add(7);
      testList.add(3);
      testList.add(4);
      int expected = 2;
      IntegerComparator comp = new IntegerComparator();
      int actual = Selector.min(testList, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void minTest2() {
      /** basic test 2 **/
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(5);
      testList.add(9);
      testList.add(1);
      testList.add(7);
      testList.add(3);
      int expected = 1;
      IntegerComparator comp = new IntegerComparator();
      int actual = Selector.min(testList, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void minTest3() {
      /** basic test 3 **/
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(5);
      testList.add(9);
      testList.add(3);
      testList.add(7);
      testList.add(1);
      int expected = 1;
      IntegerComparator comp = new IntegerComparator();
      int actual = Selector.min(testList, comp);
      Assert.assertEquals(expected, actual);
   }
      
   /** Testing max **/
   @Test public void maxTest1() {
      /** basic test 1 **/
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(8);
      testList.add(1);
      testList.add(7);
      testList.add(3);
      testList.add(4);
      int expected = 8;
      IntegerComparator comp = new IntegerComparator();
      int actual = Selector.max(testList, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void maxTest2() {
      /** basic test 2 **/
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(5);
      testList.add(1);
      testList.add(9);
      testList.add(7);
      testList.add(3);
      int expected = 9;
      IntegerComparator comp = new IntegerComparator();
      int actual = Selector.max(testList, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void maxTest3() {
      /** basic test 3 **/
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(5);
      testList.add(1);
      testList.add(3);
      testList.add(7);
      testList.add(9);
      int expected = 9                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ;
      IntegerComparator comp = new IntegerComparator();
      int actual = Selector.max(testList, comp);
      Assert.assertEquals(expected, actual);
   }
   
   
   /**
   // Testing remove duplicates
   @Test public void sort1() {
       basic test 1 
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(2);
      testList.add(8);
      testList.add(7);
      testList.add(8);
      testList.add(2);
      ArrayList<Integer> expected = new ArrayList<Integer>();
      expected.add(2);
      expected.add(7);
      expected.add(8);
      IntegerComparator comp = new IntegerComparator();
      Assert.assertEquals(expected, Selector.removeDuplicates(testList, comp));
   }
   
   @Test public void sort2() {
       basic test 1 
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(-4);
      testList.add(-4);
      testList.add(-4);
      testList.add(-4);
      ArrayList<Integer> expected = new ArrayList<Integer>();
      IntegerComparator comp = new IntegerComparator();
      Assert.assertEquals(expected, Selector.removeDuplicates(testList, comp));
   }
     **/ 
     
     /** TESTING KMIN **/
   @Test public void kminTest1() {
      /** basic test 1 **/
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(2);
      testList.add(8);
      testList.add(7);
      testList.add(3);
      testList.add(4);
      int k = 1;
      IntegerComparator comp = new IntegerComparator();
      int expected = 2;
      int actual = Selector.kmin(testList, k, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void kminTest2() {
      /** basic test 2 **/
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(8);
      testList.add(7);
      testList.add(5);
      testList.add(4);
      testList.add(6);
      int k = 5;
      IntegerComparator comp = new IntegerComparator();
      int expected = 8;
      int actual = Selector.kmin(testList, k, comp);
      Assert.assertEquals(expected, actual);
   }
   
   
   /**TESTING KMAX**/
   @Test public void kmaxTest1() {
      /** basic test 1 **/
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(2);
      testList.add(8);
      testList.add(7);
      testList.add(3);
      testList.add(4);
      int k = 1;
      IntegerComparator comp = new IntegerComparator();
      int expected = 8;
      int actual = Selector.kmax(testList, k, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void kmaxTest2() {
      /** basic test 2 **/
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(8);
      testList.add(7);
      testList.add(5);
      testList.add(4);
      testList.add(6);
      int k = 3;
      IntegerComparator comp = new IntegerComparator();
      int expected = 6;
      int actual = Selector.kmax(testList, k, comp);
      Assert.assertEquals(expected, actual);
   }
   
   /** TESTING RANGE **/
   @Test public void rangeTest1() {
      /** basic test 1 **/
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(2);
      testList.add(8);
      testList.add(7);
      testList.add(3);
      testList.add(4);
      int low = 1;
      int high = 5;
      IntegerComparator comp = new IntegerComparator();
      
      ArrayList<Integer> actual = new ArrayList<Integer>();
      actual.add(2);
      actual.add(3);
      actual.add(4);
      Assert.assertEquals(actual, Selector.range(testList, low, high, comp));
   }
   
   @Test public void rangeTest2() {
      /** basic test 2 **/
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(5);
      testList.add(9);
      testList.add(1);
      testList.add(7);
      testList.add(3);
      int low = 3;
      int high = 5;
      IntegerComparator comp = new IntegerComparator();
      
      ArrayList<Integer> actual = new ArrayList<Integer>();
      actual.add(5);
      actual.add(3);
      Assert.assertEquals(actual, Selector.range(testList, low, high, comp));
   }

   /** TESTING CIELING**/
   @Test public void ceilingTest1() {
      /** basic test 1 **/
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(5);
      testList.add(9);
      testList.add(1);
      testList.add(7);
      testList.add(3);
      IntegerComparator comp = new IntegerComparator();
      int key = 7;
      int expected = 7;
      int actual = Selector.ceiling(testList, key, comp);
      Assert.assertEquals(expected, actual);
   }
   
   //inavalid floor test
   @Test public void floorTest1() {
      /** basic test 1 **/
      ArrayList<Integer> testList = new ArrayList<Integer>();
      testList.add(7);
      IntegerComparator comp = new IntegerComparator();
      int key = 11;
      int expected = 7;
      int actual = Selector.floor(testList, key, comp);
      Assert.assertEquals(expected, actual);
   }
}
