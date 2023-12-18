import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;



public class SolutionTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void defaultTest() {
      List<Integer> arr = new ArrayList<Integer>();
      arr.add(1);
      arr.add(2);
      arr.add(3);
      arr.add(4);
      arr.add(6); 
      Assert.assertEquals(3, Result.balancedSum(arr));
   }
}
