import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {
   public int compare(Integer num1, Integer num2) {
      return num1.compareTo(num2);
   }
}