import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;

public class SelectorTest {


   /** Testing the min method **/
   @Test public void minTest1() {
      /** Basic test 1 **/
      int[] a = {2, 4, 6, 8, 10};
      int expected = 2;
      assertEquals(expected, Selector.min(a));
   }
   
   /** Min test 2 **/
   @Test public void minTest2() {
      int[] a = {7, 4, 6, 2, 10};
      int expected = 2;
      assertEquals(expected, Selector.min(a));
   }
   
   /** Min test 3 **/
   @Test public void minTest3() {
      int[] a = {5, 3, 6, 10, 2};
      int expected = 2;
      assertEquals(expected, Selector.min(a));
   }
   
   /** Testing exceptions thrown in min **/
   @Test public void minTest4() {
      int[] a = {};
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.min(a));
      assertEquals("IAE", exception.getMessage());
   }

   @Test public void minIAE1() {
      int[]a = {};
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.min(a));
      assertEquals("IAE", exception.getMessage());
   }
   
   @Test public void minIAE2() {
      int[]a = null;
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.min(a));
      assertEquals("IAE", exception.getMessage());
   }

/** Testing the max method **/

   @Test public void maxTest1() {
      /** Basic test 1 **/
      int[] a = {2, 4, 6, 8, 10};
      int expected = 10;
      int actual = Selector.max(a);
      assertEquals(expected, actual);
   }
   
   /** Max test 2 **/
   @Test public void maxTest2() {
      int[] a = {7, 12, 6, 2, 10};
      int expected = 12;
      int actual = Selector.max(a);
      assertEquals(expected, actual);
   }
   
   /** Testing exceptions thrown in max **/
   @Test public void maxTest3() {
      int[] a = {};
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.max(a));
      assertEquals("IAE", exception.getMessage());
   }
  
  /** Testing k min **/
  
   @Test public void kminTest1() {
   /** basic test 1**/
      int[]a = {2, 8, 7, 3, 4};
      int k =  1;
      int expected = 2;
      assertEquals(expected, Selector.kmin(a, k));
   }
   
   @Test public void kminTest2() {
      /** basic test 2 **/
      int[]a = {5, 9, 1, 7, 3};
      int k = 3;
      int expected = 5;
      assertEquals(expected, Selector.kmin(a, k));
   }
   
   @Test public void kminTest3() {
      /** basic test 3 **/
      int[]a = {8, 7, 6, 5, 4};
      int k = 5;
      int expected = 8;
      assertEquals(expected, Selector.kmin(a, k));
   }
  
   @Test public void kminTest4() {
      /** basic test 4 **/
      int[]a = {8, 2, 8, 7, 3, 3, 4};
      int k = 3;
      int expected = 4;
      assertEquals(expected, Selector.kmin(a, k));
   }
   

   
  /** Testing exceptions thrown in kmin **/
  
   @Test public void kminIAE1() {
   /* *IAE test 1 - null array **/
      int[] a = {};
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.kmin(a, 1));
      assertEquals("IAE", exception.getMessage());
   }
   
  /** Testing exceptions thrown in kmin 
      This exception will be thrown if k is bigger than a.length but less
      than the largest value of a.                                   **/
   @Test public void kminIAE2() {
      int[] a = {1, 2, 6};
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.kmin(a, 4));
      assertEquals("IAE", exception.getMessage());
   }
   
   /** Testing exceptions thrown in kmin 
      This exception will be thrown if k is greater than a.length and greater
      than the largest value of a.                                   **/
   @Test public void kminIAE3() {
      int[] a = {1, 2, 3};
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.kmin(a, 4));
      assertEquals("IAE", exception.getMessage());
   }
   
   
   /** Testing the duplicate and sort method(Only work when) class is set to public **/
   
   /**
   @Test public void dupTest1() {
      int[] a = {1, 1, 2, 2};
      int[] Expected = {1, 2};
      Assert.assertArrayEquals(Expected, Selector.removeDuplicates(a, a.length));
   }
   
   @Test public void dupTest2() {
      int[]a = {1, 2, 1, 2};
      int[] expected = {1, 2};
      Assert.assertArrayEquals(expected, Selector.removeDuplicates(a, a.length));
   }
   
   @Test public void dupTest3() {
      int[]a = {1, 0, 4, 4, 5, 6, 1, 0};
      int[] expected = {0, 1, 4, 5, 6};
      Assert.assertArrayEquals(expected, Selector.removeDuplicates(a, a.length));
   }
   **/
   
   /** Testing k max **/
  
   @Test public void kmaxTest1() {
   /** basic test 1**/
      int[]a = {2, 8, 7, 3, 4};
      int k =  1;
      int expected = 8;
      assertEquals(expected, Selector.kmax(a, k));
   }
   
   @Test public void kmaxTest2() {
      /** basic test 2 **/
      int[]a = {5, 9, 1, 7, 3};
      int k = 3;
      int expected = 5;
      assertEquals(expected, Selector.kmax(a, k));
   }
   
   @Test public void kmaxTest3() {
      /** basic test 3 **/
      int[]a = {8, 7, 6, 5, 4};
      int k = 5;
      int expected = 4;
      assertEquals(expected, Selector.kmax(a, k));
   }
  
   @Test public void kmaxTest4() {
      /** basic test 4 **/
      int[]a = {8, 2, 8, 7, 3, 3, 4};
      int k = 3;
      int expected = 4;
      assertEquals(expected, Selector.kmax(a, k));
   }
  /** Testing exceptions thrown in kmin **/
  
   @Test public void kmaxIAE1() {
   /* *IAE test 1 - null array **/
      int[] a = {};
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.kmax(a, 1));
      assertEquals("IAE", exception.getMessage());
   }
   
  /** Testing exceptions thrown in kmax 
      This exception will be thrown if k is bigger than a.length but less
      than the largest value of a.                                   **/
   @Test public void kmaxIAE2() {
      int[] a = {1, 2, 6};
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.kmax(a, 4));
      assertEquals("IAE", exception.getMessage());
   }
   
   /** Testing exceptions thrown in kmin 
      This exception will be thrown if k is greater than a.length and greater
      than the largest value of a.                                   **/
   @Test public void kmaxIAE3() {
      int[] a = {1, 2, 3};
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.kmax(a, 4));
      assertEquals("IAE", exception.getMessage());
   }
   
   /**
      TESTING RANGE
                  **/
   @Test public void rangeTest1() {
   /** Test 1 **/
      int[] a = {2, 8, 7, 3, 4};
      int low = 1;
      int high = 5;
      int[] expected = {2, 3, 4};
      int[] actual = Selector.range(a, low, high);
      Assert.assertArrayEquals(expected, actual);
   }
   
   @Test public void rangeTest2() {
      /** Test 2 **/
      int[] a = {5, 9, 1, 7, 3};
      int low = 3;
      int high = 5;
      int[] expected = {5, 3};
      int[] actual = Selector.range(a, low, high);
      Assert.assertArrayEquals(expected, actual);
   }
   
   @Test public void rangeTest3() {
      /** Test 3 **/
      int[] a = {8, 7, 6, 5, 4};
      int low = 4;
      int high = 8;
      int[] expected = {8, 7, 6, 5, 4};
      int[] actual = Selector.range(a, low, high);
      Assert.assertArrayEquals(expected, actual);
   }
   
   @Test public void rangeTest4() {
      /** Test 3 **/
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      int low = 3;
      int high = 7;
      int[] expected = {7, 3, 3, 4};
      int[] actual = Selector.range(a, low, high);
      Assert.assertArrayEquals(expected, actual);
   }
    
   @Test public void rangeTest5() {
      /** Test if no valid elements **/
      int[] a = {5, 6, 7, 8};
      int low = 1;
      int high = 4;
      int[] expected = {};
      int[] actual = Selector.range(a, low, high);
      Assert.assertArrayEquals(expected, actual);
   }
   @Test public void rangeIAE() {
   /** IAE test 1 - null array **/
      int[] a = {};
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.range(a, 1, 2));
      assertEquals("IAE", exception.getMessage());
   }
   
   /** TESTING CEILING **/
   
   @Test public void ceilingTest1() {
   /** Basic test 1 **/
      int[] a = {2, 8, 7, 3, 4};
      int key = 1;
      int expected = 2;
      int actual = Selector.ceiling(a, key);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void ceilingTest2() {
   /** Basic Test 2 **/
      int[] a = {5, 9, 1, 7, 3};
      int key = 7;
      int expected = 7;
      int actual = Selector.ceiling(a, key);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void ceilingTest3() {
      /** Basic Test 3 **/
      int[] a = {8, 7, 6, 5, 4};
      int key = 0;
      int expected = 4;
      int actual = Selector.ceiling(a, key);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void ceilingTest4() {
      /** Basic Test 4 **/
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      int key = 5;
      int expected = 7;
      int actual = Selector.ceiling(a, key);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void ceilingIAE() {
   /** IAE test 1 - null array **/
      int[] a = {};
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.ceiling(a, 1));
      assertEquals("IAE", exception.getMessage());
   }
   
   @Test public void ceilingIAE2() {
      /** IAE for invalid key **/
      int[]a = {2, 3, 5};
      int key = 7;
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.ceiling(a, key));
      assertEquals("IAE", exception.getMessage());
   }
   
   
   /**
      TESTING FLOOR
                  **/
   @Test public void floorTest1() {
      //floor test 1
      int[] a = {2, 8, 7, 3, 4};
      int key = 6;
      int expected = 4;
      int actual = Selector.floor(a, key);
      assertEquals(expected, actual);
   }
   
   @Test public void floorTest2() {
      //floor test 2
      int[] a = {5,9,1,7,3};
      int key = 1;
      int expected = 1;
      int actual = Selector.floor(a, key);
      assertEquals(expected, actual);
   }
   
   @Test public void floorTest3() {
      //floor test 3
      int[] a = {8, 7, 6, 5, 4};
      int key = 9;
      int expected = 8;
      int actual = Selector.floor(a, key);
      assertEquals(expected, actual);
   }
   
   @Test public void floorTest4() {
      //floor test 4
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      int key = 5;
      int expected = 4;
      int actual = Selector.floor(a, key);
      assertEquals(expected, actual);
   }
   
   @Test public void floorTest5() {
      //floor test 5
      int[] a = {9,7};
      int key = 8;
      int expected = 7;
      int actual = Selector.floor(a, key);
      assertEquals(expected, actual);
   }
   
   @Test public void floorIAE() {
   /** IAE test 1 - null array **/
      int[] a = {};
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.floor(a, 1));
      assertEquals("IAE", exception.getMessage());
   }
   
   @Test public void floorIAE2() {
      /** IAE for invalid key **/
      int[]a = {2, 3, 5};
      int key = 1;
      Exception exception = Assert.assertThrows(IllegalArgumentException.class, () ->
            Selector.floor(a, key));
      assertEquals("IAE", exception.getMessage());
   }
   
   

}

