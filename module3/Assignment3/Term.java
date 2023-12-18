import java.util.Comparator;

/**
 * Autocomplete term representing a (query, weight) pair.
 * 
 */
public class Term implements Comparable<Term> {

   private final String query;
   private final double weight;
   /**
    * Initialize a term with the given query and weight.
    * This method throws a NullPointerException if query is null,
    * and an IllegalArgumentException if weight is negative.
    */
   public Term(String query, long weight) {
      if(query == null) {
         throw new NullPointerException("NPE");
      }
      if(weight < 0){
         throw new IllegalArgumentException("IAE");
      }
      this.query = query;
      this.weight = weight;
    
   }

   /**
    * Compares the two terms in descending order of weight.
    */
   public static Comparator<Term> byDescendingWeightOrder() {
      return new ComparatorByDescendingWeightOrder();
   }
   
    /** privately compare two terms **/
   private static class ComparatorByDescendingWeightOrder implements Comparator<Term> {
      public int compare(Term a, Term b) {
         if (a.weight == b.weight) 
            return 0;
         if (a.weight > b.weight) 
            return -1;
         return 1;
      }
   }
   

   /**
    * Compares the two terms in ascending lexicographic order of query,
    * but using only the first length characters of query. This method
    * throws an IllegalArgumentException if length is less than or equal
    * to zero.
    */
   public static Comparator<Term> byPrefixOrder(int length) {
      if(length <= 0) {
         throw new IllegalArgumentException("IAE");
      }
      return new ComparatorByPrefixOrder(length);
   }
   
   /**
   * Take the first two characters of the queries of two strings and compare them. 
   **/
   private static class ComparatorByPrefixOrder implements Comparator<Term> {
      private int length;
      
      private ComparatorByPrefixOrder(int length) {
         this.length = length;
      }
      
      public int compare(Term a, Term b) {
         String aQ = a.query;
         String bQ = b.query;
         String preA;
         String preB;
         
         if(aQ.length() < length) {
            preA = aQ;
         }
         else {
            preA = aQ.substring(0, length);
         }
         
         if(bQ.length() < length) {
            preB = bQ;
         }
         else {
            preB = bQ.substring(0, length);
         }
         
         /** now that the prefix is set we can compare **/
         return preA.compareTo(preB);
      }
      
   }

   /**
    * Compares this term with the other term in ascending lexicographic order
    * of query.
    */
   @Override
   public int compareTo(Term other) {
      return this.query.compareTo(other.query);
   }

   /**
    * Returns a string representation of this term in the following format:
    * query followed by a tab followed by weight
    */
   @Override
   public String toString(){
      return this.query + "\t" + this.weight;
   }

}



