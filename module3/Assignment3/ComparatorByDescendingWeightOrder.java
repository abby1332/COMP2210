import java.util.Arrays;
import java.util.Comparator;
 /** privately compare two terms **/
private static class ComparatorByDescendingWeightOrder implements Comparator<Term> {
   @Override
   	public int compare(Term a, Term b) {
      if (a.weight == b.weight) 
         return 0;
      if (a.weight > b.weight) 
         return -1;
      return 1;
   }
}