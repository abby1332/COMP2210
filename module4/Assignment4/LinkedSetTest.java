import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class LinkedSetTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** TESTING CONTAINS **/
   @Test public void containsTest() {
   //Test if the list does have the element
      LinkedSet<String> list = new LinkedSet<>();
      
      list.add("A");
      list.add("B");
      list.add("C");
      Assert.assertEquals(list.contains("C"), true);
   }
   
   @Test public void containsTest2() {
   //Test if the list does NOT have the element
      LinkedSet<String> list = new LinkedSet<>();
      
      list.add("A");
      list.add("B");
      list.add("C");
      Assert.assertEquals(list.contains("D"), false);
   }
   
   //TESTING REMOVE
   @Test public void removeTest() {
   //Test if the list does NOT have the element
      LinkedSet<String> list = new LinkedSet<>();
      
      list.add("A");
      list.add("B");
      list.add("C");
      list.remove("C");
      Assert.assertEquals(list.contains("C"), false);
   }
   
   @Test public void removeTest1() {
      LinkedSet<String> list = new LinkedSet<>();
     
      list.add("A");
      list.add("B");
      list.add("C");
   
      list.remove("B");
      Assert.assertEquals(list.contains("B"), false);
   }
   
   @Test public void removeTest2() {
      LinkedSet<String> list = new LinkedSet<>();
     
      list.add("A");
      list.add("B");
      list.add("C");
      list.remove("A");
      Assert.assertEquals(list.contains("A"), false);
   }
   
   @Test public void removeTest3() {
      LinkedSet<String> list = new LinkedSet<>();
     
      list.add("A");
      list.add("B");
      list.add("C");
      Assert.assertEquals(list.remove("D"), false);
   }
   
   @Test public void removeTest4() {
      LinkedSet<String> list = new LinkedSet<>();
      
      list.add("A");
      Assert.assertEquals(list.remove("A"), true);
   }
   
   //TESTING ADD
   @Test public void addTest() {
   //Test if the list does NOT have the element
      LinkedSet<String> list = new LinkedSet<>();
      
      list.add("A");
      list.add("B");
      list.add("C");
      Assert.assertEquals(list.contains("C"), true);
   }
   
   //TESTING ADD
   @Test public void addTest2() {
   //Test if the list does NOT have the element
      LinkedSet<Integer> list = new LinkedSet<>();
      
      list.add(5);
      list.add(3);
      list.add(1);
      Assert.assertEquals(list.contains(1), true);
   }
   
   //TESTING COMPARE SET
   @Test public void equalsTest() {
   //Test if the list does match
      Set<Integer> list = new LinkedSet<>();
      
      list.add(5);
      list.add(3);
      list.add(1);
      
      Set<Integer> list2 = new LinkedSet<>();
      
      list2.add(5);
      list2.add(3);
      list2.add(1);
      Assert.assertEquals(list.equals(list2), true);
   }
   
   //TESTING LINKED SET COMPARE SET
   @Test public void equalsTest3() {
   //Test if the list does match
      LinkedSet<Integer> list = new LinkedSet<>();
      
      list.add(5);
      list.add(3);
      list.add(1);
      
      LinkedSet<Integer> list2 = new LinkedSet<>();
      
      list2.add(5);
      list2.add(3);
      list2.add(1);
      Assert.assertEquals(list.equals(list2), true);
   }
   
   @Test public void equalsTest2() {
   //Test if the list does NOT match
      Set<Integer> list = new LinkedSet<>();
      
      list.add(5);
      list.add(3);
      list.add(1);
      
      Set<Integer> list2 = new LinkedSet<>();
      
      list2.add(5);
      list2.add(10);
      list2.add(1);
      Assert.assertEquals(list.equals(list2), false);
   } 
 
   //UNION UWU
   @Test public void unionTest() {
      Set<Integer> list = new LinkedSet<>();
      
      list.add(1);
      list.add(2);
      list.add(3);
      
      Set<Integer> list2 = new LinkedSet<>();
      
      
      
      Set<Integer> result = new LinkedSet<>();
      result.add(1);
      result.add(2);
      result.add(3);
      
      Set<Integer> actual = new LinkedSet<>();
      actual = list.union(list2);
      
      Assert.assertEquals(actual.equals(result), true);
      
      actual = list2.union(list);
     
      Assert.assertEquals(actual.equals(result), true);
   }
   
   @Test public void unionTest2() {
      Set<Integer> list = new LinkedSet<>();
      
      list.add(1);
      list.add(2);
      list.add(3);
      
      Set<Integer> list2 = new LinkedSet<>();
      list2.add(3);
      list2.add(4);
      list2.add(2);
      
      
      Set<Integer> expected = new LinkedSet<>();
      expected.add(1);
      expected.add(2);
      expected.add(3);
      expected.add(4);
      
      Set<Integer> actual = new LinkedSet<>();
      actual = list.union(list2);
      
      Assert.assertEquals(actual.equals(expected), true);
      
      actual = list2.union(list);
     
      Assert.assertEquals(actual.equals(expected), true);
   }
   
   @Test public void unionTest3() {
      LinkedSet<Integer> list = new LinkedSet<>();
      
      list.add(1);
      list.add(2);
      list.add(3);
      
      LinkedSet<Integer> list2 = new LinkedSet<>();
      
      
      
      LinkedSet<Integer> result = new LinkedSet<>();
      result.add(1);
      result.add(2);
      result.add(3);
      
      Set<Integer> actual = new LinkedSet<>();
      actual = list.union(list2);
      
      Assert.assertEquals(actual.equals(result), true);
      
      actual = list2.union(list);
     
      Assert.assertEquals(actual.equals(result), true);
   }
   
   @Test public void unionTest4() {
      LinkedSet<Integer> list = new LinkedSet<>();
      
      list.add(1);
      list.add(2);
      list.add(3);
      
      LinkedSet<Integer> list2 = new LinkedSet<>();
      list2.add(3);
      list2.add(4);
      list2.add(2);
      
      
      LinkedSet<Integer> expected = new LinkedSet<>();
      expected.add(1);
      expected.add(2);
      expected.add(3);
      expected.add(4);
      
      Set<Integer> actual = new LinkedSet<>();
      actual = list.union(list2);
      
      Assert.assertEquals(actual.equals(expected), true);
      
      actual = list2.union(list);
     
      Assert.assertEquals(actual.equals(expected), true);
   }
   
   //INTERSECTION
   
   @Test public void intersectionTest() {
      LinkedSet<Integer> list = new LinkedSet<>();
      
      list.add(1);
      list.add(2);
      list.add(3);
      
      LinkedSet<Integer> list2 = new LinkedSet<>();
      list2.add(1);
      list2.add(2);
      list2.add(3);
      
      
      LinkedSet<Integer> result = new LinkedSet<>();
      result.add(1);
      result.add(2);
      result.add(3);
      
      Set<Integer> actual = new LinkedSet<>();
      actual = list.intersection(list2);
      
      Assert.assertEquals(actual.equals(result), true);
      
      actual = list2.intersection(list);
     
      Assert.assertEquals(actual.equals(result), true);
   }
   
   /**
   @Test public void unionTest2() {
      Set<Integer> list = new LinkedSet<>();
      
      list.add(1);
      list.add(2);
      list.add(3);
      
      Set<Integer> list2 = new LinkedSet<>();
      list2.add(3);
      list2.add(4);
      list2.add(2);
      
      
      Set<Integer> expected = new LinkedSet<>();
      expected.add(1);
      expected.add(2);
      expected.add(3);
      expected.add(4);
      
      Set<Integer> actual = new LinkedSet<>();
      actual = list.union(list2);
      
      Assert.assertEquals(actual.equals(expected), true);
      
      actual = list2.union(list);
     
      Assert.assertEquals(actual.equals(expected), true);
   }**/

   
}
