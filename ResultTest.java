import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class ResultTest {



   /** A test that always fails. **/
   @Test public void defaultTest() {
      String input = "LRRLLL";
      List<Integer> arr = Result.findNumberSequence(input);
      List<Integer> sequence = new ArrayList<Integer>();
      sequence.add(2);
      sequence.add(4);
      sequence.add(5);
      sequence.add(6);
      sequence.add(3);
      sequence.add(1);
      Assert.assertEquals(sequence, arr);
   }
}
