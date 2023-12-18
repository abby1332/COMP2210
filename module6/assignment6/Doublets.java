import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import java.util.stream.Collectors;

/**
 * Provides an implementation of the WordLadderGame interface. 
 *
 * @author Abigail Miller (amm0257@auburn.edu)
 */
public class Doublets implements WordLadderGame {

   // The word list used to validate words.
   // Must be instantiated and populated in the constructor.
   /////////////////////////////////////////////////////////////////////////////
   // DECLARE A FIELD NAMED lexicon HERE. THIS FIELD IS USED TO STORE ALL THE //
   // WORDS IN THE WORD LIST. YOU CAN CREATE YOUR OWN COLLECTION FOR THIS     //
   // PURPOSE OF YOU CAN USE ONE OF THE JCF COLLECTIONS. SUGGESTED CHOICES    //
   // ARE TreeSet (a red-black tree) OR HashSet (a closed addressed hash      //
   // table with chaining).
   /////////////////////////////////////////////////////////////////////////////
   private TreeSet<String> Lexicon;
 

   /**
    * Instantiates a new instance of Doublets with the lexicon populated with
    * the strings in the provided InputStream. The InputStream can be formatted
    * in different ways as long as the first string on each line is a word to be
    * stored in the lexicon.
    */
   public Doublets(InputStream in) {
      try {
         //////////////////////////////////////
         // INSTANTIATE lexicon OBJECT HERE  //
         //////////////////////////////////////
         Lexicon = new TreeSet<String>();
         
         Scanner s =
            new Scanner(new BufferedReader(new InputStreamReader(in)));
         while (s.hasNext()) {
            String str = s.next();
            /////////////////////////////////////////////////////////////
            // INSERT CODE HERE TO APPROPRIATELY STORE str IN lexicon. //
            /////////////////////////////////////////////////////////////
            
            Lexicon.add(str.toLowerCase());
            
            s.nextLine();
         }
         in.close();
      }
      catch (java.io.IOException e) {
         System.err.println("Error reading from InputStream.");
         System.exit(1);
      }
   }


   //////////////////////////////////////////////////////////////
   // ADD IMPLEMENTATIONS FOR ALL WordLadderGame METHODS HERE  //
   //////////////////////////////////////////////////////////////
   
   /**
    * Returns the total number of words in the current lexicon.
    *
    * @return number of words in the lexicon
    */
   public int getWordCount() {
      return Lexicon.size();
   }


   /**
    * Checks to see if the given string is a word.
    *
    * @param  str the string to check
    * @return     true if str is a word, false otherwise
    */
   public boolean isWord(String str) {
      if (str == null) {
         throw new IllegalArgumentException("IAE");
      }
      if(Lexicon == null) {
         throw new IllegalStateException("ISE");
      }
      
      return Lexicon.contains(str.toLowerCase());
   }


   /**
    * Returns the Hamming distance between two strings, str1 and str2. The
    * Hamming distance between two strings of equal length is defined as the
    * number of positions at which the corresponding symbols are different. The
    * Hamming distance is undefined if the strings have different length, and
    * this method returns -1 in that case. See the following link for
    * reference: https://en.wikipedia.org/wiki/Hamming_distance
    *
    * @param  str1 the first string
    * @param  str2 the second string
    * @return      the Hamming distance between str1 and str2 if they are the
    *                  same length, -1 otherwise
    */
   public int getHammingDistance(String str1, String str2){
      if(str1 == null || str2 == null) {
         throw new IllegalArgumentException("IAE");
      }
      if(Lexicon == null) {
         throw new IllegalStateException("ISE");
      }
      
      str1 = str1.toLowerCase();
      str2 = str2.toLowerCase();
      
      //If the two strings have differing lengths
      if(str1.length() != str2.length()) {
         return -1;
      }
      //Else compare the index of each string and add 1 for each different index
      else {
         int count = 0;
         for (int i = 0 ; i != str1.length() ; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if (ch1 != ch2) {
               count++;
            }
         }
         return count;
      
      }
   }


   /**
    * Returns all the words that have a Hamming distance of one relative to the
    * given word.
    *
    * @param  word the given word
    * @return      the neighbors of the given word
    */
   public List<String> getNeighbors(String word){
      if(word == null) {
         throw new IllegalArgumentException("IAE");
      }
      if(Lexicon == null) {
         throw new IllegalStateException("ISE");
      }
      
      List<String> neighbor = new ArrayList<String>();
      word = word.toLowerCase();
      char[] charWord = word.toCharArray();
      
      for(int i = 0; i < word.length(); i++) {
         char temp = charWord[i];
         for(int j = 97; j < 122; j++) {
            charWord[i] = (char)j;
            String tempWord = String.valueOf(charWord);
            if(isWord(tempWord) && !word.equals(tempWord)) {
               neighbor.add(tempWord);
            }
         }
         charWord[i] = temp;
      }
      return neighbor;
   }
      
      

   /**
    * Checks to see if the given sequence of strings is a valid word ladder.
    *
    * @param  sequence the given sequence of strings
    * @return          true if the given sequence is a valid word ladder,
    *                       false otherwise
    */
   public boolean isWordLadder(List<String> sequence){
      if (sequence == null || sequence.isEmpty()) {
         return false;
      }
      if(Lexicon == null) {
         throw new IllegalStateException("ISE");
      }
      
      
      int infractions = 0;
      for(int i = 0; i < sequence.size() - 1; i++) {
        //Check if there is an illegal word
         if(getHammingDistance(sequence.get(i), sequence.get(i + 1)) != 1 || !isWord(sequence.get(i))) {
            infractions++;
         }
      }
      
      if(infractions == 0) {
         return true;
      }
      
      return false;
   }


  /**
   * Returns a minimum-length word ladder from start to end. If multiple
   * minimum-length word ladders exist, no guarantee is made regarding which
   * one is returned. If no word ladder exists, this method returns an empty
   * list.
   *
   * Breadth-first search must be used in all implementing classes.
   *
   * @param  start  the starting word
   * @param  end    the ending word
   * @return        a minimum length word ladder from start to end
   */
   public List<String> getMinLadder(String start, String end) {
      if(Lexicon == null) {
         throw new IllegalStateException("ISE");
      }
      if(start == null || end == null) {
         throw new IllegalArgumentException("IAE");
      }
      
      
      
      //A array list storing the word ladder
      List<String> ladder = new ArrayList<>();
      
      //Empty start or end, empty ladder
      if(!isWord(start) || !isWord(end)) {
         return ladder;
      }
      //If they are different sizes its null
      if(start.length() != end.length()) {
         return ladder;
      }
      
      
      
      
      
      //If start and end are the same word, return that
      if(start.equals(end)) {
         ladder.add(start);
         return ladder;
      }
      
   
      
      //Create a queue for BFS
      Deque<Node> queue = new ArrayDeque<>();
      //Use this to keep track of visited
      TreeSet<String> memory = new TreeSet<>();
      
      //visit(start);
      //process(start);
      
      memory.add(start);
      queue.addLast(new Node(start, null));
      Node endNode = new Node(end, null);
      
      outerloop:
      while (!queue.isEmpty()) {
         Node n = queue.removeFirst();
         String position = n.position;
         for (String neighbor : getNeighbors(position)) {
            
            if(!memory.contains(neighbor)) {
               memory.add(neighbor);
               queue.addLast(new Node(neighbor, n));
               if(neighbor.equals(end)) {
                  Node head = queue.removeLast();
                  while(head != null) {
                     ladder.add(0, head.position);
                     head = head.predecessor;
                  }
                  return ladder;
               }
            }
            
           /**
            //If its the end word then we're done
            if(neighbor.equals(end)) {
               Node m = queue.removeLast();
               while(m!= null) {
                  ladder.add(0, m.position);
                  m = m.predecessor;
               }
               
               **/
               //return ladder;
         }
            
      }
      List<String> empty = new ArrayList<>();
      return empty;
   }


  /**
    * Constructs a node for linking positions together.
    */ 
   private class Node {
      String position;
      Node predecessor;
   
      public Node(String p, Node pred) {
         position = p;
         predecessor = pred;
      }
   }



}

