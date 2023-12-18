import java.util.Arrays;


/**
 * Autocomplete.
 */
public class Autocomplete {

   private Term[] terms;

	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
   public Autocomplete(Term[] terms) {
      if(terms == null) {
         throw new NullPointerException("NPE");
      }
      this.terms = new Term[terms.length];
      for (int i = 0; i < terms.length; i++) {
         this.terms[i] = terms[i];
      }
      Arrays.sort(this.terms);
   }

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
   public Term[] allMatches(String prefix) {
      if(prefix == null) {
         throw new NullPointerException("NPE");
      }       	
      //Identify first index
      int firstIndex = BinarySearch.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
      if (firstIndex == -1) {
         return new Term[0];
      }
     //Identify last index
      int lastIndex  = BinarySearch.lastIndexOf (terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
      Term[] matchTerms = new Term[1 + lastIndex - firstIndex];
    	
      //Search for matching terms
      for (int i = 0; i < matchTerms.length; i++) {
         matchTerms[i] = terms[firstIndex++];
      }
      
      //Sort by descending weight
      Arrays.sort(matchTerms, Term.byDescendingWeightOrder());
    	
      return matchTerms;
   }

}

