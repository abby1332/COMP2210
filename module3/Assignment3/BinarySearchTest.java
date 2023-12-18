import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;


public class BinarySearchTest {
   
   static Comparator<Integer> comparator =
        new Comparator<Integer>() {
           public int compare(Integer i1, Integer i2) {
              return i1.compareTo(i2);
           }
        }; 
        
   @Test public void testFirstIndexOf1() {
      Integer[] a = {2, 2, 2, 2, 2, 2, 2, 2}; 
      Integer key = 2; 
      int expected = 0;
      int actual = BinarySearch.firstIndexOf(a,key,comparator);
      Assert.assertEquals(expected,actual);
   }

   @Test public void testLastIndexOf1() {
      Integer[] a = {2, 2, 2, 2, 2, 2, 2, 2}; 
      Integer key = 2; 
      int expected = 7;
      int actual = BinarySearch.lastIndexOf(a,key,comparator);
      Assert.assertEquals(expected,actual);
   }
   
   @Test public void testLastIndexOf2() {
      Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9}; 
      Integer key = 2; 
      int expected = 1;
      int actual = BinarySearch.lastIndexOf(a,key,comparator);
      Assert.assertEquals(expected,actual);
   }
 
   @Test public void testLastIndexOf3() { 
      Integer[] a = {2, 2, 2, 2, 4, 5, 6, 7, 8};
      Integer key = 2; 
      int expected = 3;
      int actual = BinarySearch.lastIndexOf(a,key,comparator);
      Assert.assertEquals(expected,actual);
   }
 
   @Test public void testLastIndexOf4() {
      Integer[] a = {1, 1, 1, 2, 2, 2, 4, 5, 6, 7}; 
      Integer key = 2; 
      int expected = 5;
      int actual = BinarySearch.lastIndexOf(a,key,comparator);
      Assert.assertEquals(expected,actual);
   }
      
   @Test public void testLastIndexOf5() {
      Integer[] a = {0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 2}; 
      Integer key = 2; 
      int expected = 10;
      int actual = BinarySearch.lastIndexOf(a,key,comparator);
      Assert.assertEquals(expected,actual);
   }
      
       
   @Test public void testFirstIndexOf3() {
      Integer[] a = {2, 2, 2, 2, 4, 5, 6, 7, 8}; 
      Integer key = 2; 
      int expected = 0;
      int actual = BinarySearch.firstIndexOf(a,key,comparator);
      Assert.assertEquals(expected,actual);
   }
 
   @Test public void testFirstIndexOf4() {
      Integer[] a = {1, 1, 1, 2, 2, 2, 4, 5, 6, 7}; 
      Integer key = 2;
      int expected = 3;
      int actual = BinarySearch.firstIndexOf(a,key,comparator);
      Assert.assertEquals(expected,actual);
   }
      
   @Test public void testFirstIndexOf5() { 
      Integer[] a = {0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 2};
      Integer key = 2; 
      int expected = 6;
      int actual = BinarySearch.firstIndexOf(a,key,comparator);
      Assert.assertEquals(expected,actual);
   }
  
}