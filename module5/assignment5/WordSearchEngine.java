import java.io.*;
import java.util.*;

   
public class WordSearchEngine implements WordSearchGame {
   //Instance variables
   
   private boolean[][] visited;
   //Stores the lexicon
   private TreeSet<String> WordBank;
   
   //Keeps track of current words
   private TreeSet<String> allWords;
    
    //2d area to traverse
   private String BoardLetters[][] =  {{"E", "E", "C", "A"},
                               {"A", "L", "E", "P"},
                               {"H", "N", "B", "O"},
                               {"Q", "T", "T", "Y"}};
                               
   // dimensions of the grid
   private int numRows = 4;
   private int numCols = 4;
   
   //Order which positions are visited
   private int order;
   
   // number of neighbors, degrees of motion
   private static final int MAX_NEIGHBORS = 8;
   
   //Constructor
   public WordSearchEngine() {
      markAllUnvisited();
   }
   
   /**
    * Loads the lexicon into a data structure for later use. 
    * 
    * @param fileName A string containing the name of the file to be opened.
    * @throws IllegalArgumentException if fileName is null
    * @throws IllegalArgumentException if fileName cannot be opened.
    */
   public void loadLexicon(String fileName) {
      if(fileName == null) {
         throw new IllegalArgumentException("IAE");
      }
      
      WordBank = new TreeSet<String>();
   
      
      File words = new File(fileName);
      
      //If the file name is not found
      if(!words.exists()) {
         throw new IllegalArgumentException("IAE");
      }
      
      //Safely find the file
      Scanner fileScan;
      try {
         fileScan = new Scanner(words);
      }
      catch(Exception IAE) {
         throw new IllegalArgumentException("File Not Found");
      }
      
      //Scan the line until you get to a space, then go to the next line
      String word;
      while(fileScan.hasNextLine()) {
         String line = fileScan.nextLine();
         if(line.indexOf(" ") > 0) {  
            word = line.substring(0, line.indexOf(" "));
         }
         else {
            word = line;
         }
         
         WordBank.add(word.toUpperCase());
      }
   }
   
   
   /**
    * Stores the incoming array of Strings in a data structure that will make
    * it convenient to find words.
    * 
    * @param letterArray This array of length N^2 stores the contents of the
    *     game board in row-major order. Thus, index 0 stores the contents of board
    *     position (0,0) and index length-1 stores the contents of board position
    *     (N-1,N-1). Note that the board must be square and that the strings inside
    *     may be longer than one character.
    * @throws IllegalArgumentException if letterArray is null, or is  not
    *     square.
    */
   public void setBoard(String[] letterArray) {
      if(letterArray == null || Math.sqrt(letterArray.length) % 1 != 0.0) {
         throw new IllegalArgumentException("IAE");
      }
      
      int dimensions = (int)Math.sqrt(letterArray.length);
      BoardLetters = new String[dimensions][dimensions];
      
      for(int i = 0; i < dimensions; i++) {
         for(int j = 0; j < dimensions; j++) {
            BoardLetters[i][j] = letterArray[i * dimensions + j].toUpperCase();
         }
      }
      
   }
   
   /**
    * Creates a String representation of the board, suitable for printing to
    *   standard out. Note that this method can always be called since
    *   implementing classes should have a default board.
    */
   public String getBoard() {
      StringBuilder sb = new StringBuilder();
      int fieldWidth = 4;
      for (int i = 0; i < fieldWidth * numRows; i++) {
         sb.append("*");
      }
      sb.append("\n");
      for (String[] row : BoardLetters) {
         for (String entry : row) {
            sb.append(entry + "    ");
         }
         sb.append("\n");
      }
      for (int i = 0; i < fieldWidth * numRows; i++) {
         sb.append("*");
      }
      sb.append("\n");
      return sb.toString();
   }
   
   /**
    * Retrieves all scorable words on the game board, according to the stated game
    * rules.
    * 
    * @param minimumWordLength The minimum allowed length (i.e., number of
    *     characters) for any word found on the board.
    * @return java.util.SortedSet which contains all the words of minimum length
    *     found on the game board and in the lexicon.
    * @throws IllegalArgumentException if minimumWordLength < 1
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public SortedSet<String> getAllScorableWords(int minimumWordLength) {
      if(minimumWordLength < 1) {   
         throw new IllegalArgumentException("IAE");
      }
      if(WordBank == null) {
         throw new IllegalStateException("ISE");
      }
      ArrayList<Position> memory = new ArrayList<Position>(); //Keeps track of visited spots
      allWords = new TreeSet<String>();
      String currWord = "";
      
      for(int i = 0; i < BoardLetters.length; i++) {
         for(int j = 0; j < BoardLetters.length; j++) {
            currWord = BoardLetters[i][j];
            if(isValidWord(currWord) && currWord.length() >= minimumWordLength) {
               allWords.add(currWord);
            }
            if(isValidPrefix(currWord)) {
               Position temp = new Position(i, j);
               memory.add(temp);
               dfsRecursive(i, j, minimumWordLength, currWord, memory);
               memory.remove(temp);
            }
            
         }
      }
      return allWords;
   }
   
   
   /**Recursively searches for the current word with dfs
   **/
         
   private void dfsRecursive(int x, int y, int min,String currWord, ArrayList<Position> memory) {
      Position start = new Position(x, y);
      markAllUnvisited();
     
      for(Position p : start.neighbors()) {
         if(!isVisited(p)) {
            visit(p);
         }
         if(isValidPrefix(currWord + BoardLetters[p.x][p.y])) {
            currWord += BoardLetters[p.x][p.y];
            memory.add(p);
            if (isValidWord(currWord) && currWord.length() >= min) {
               allWords.add(currWord);
            }
            dfsRecursive(p.x, p.y, min, currWord, memory);
            
            memory.remove(p);
            int end = currWord.length() - BoardLetters[p.x][p.y].length();
            currWord = currWord.substring(0, end);
         }
      }
      markAllUnvisited(); 
   }
   
 /**
   * Computes the cummulative score for the scorable words in the given set.
   * To be scorable, a word must (1) have at least the minimum number of characters,
   * (2) be in the lexicon, and (3) be on the board. Each scorable word is
   * awarded one point for the minimum number of characters, and one point for 
   * each character beyond the minimum number.
   *
   * @param words The set of words that are to be scored.
   * @param minimumWordLength The minimum number of characters required per word
   * @return the cummulative score of all scorable words in the set
   * @throws IllegalArgumentException if minimumWordLength < 1
   * @throws IllegalStateException if loadLexicon has not been called.
   */  
   public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
      if(minimumWordLength < 1) {
         throw new IllegalArgumentException("IAE");
      } 
      if(WordBank == null) {
         throw new IllegalStateException("ISE");
      }
      int score = 0;
      Iterator<String> itr = words.iterator();
      
      while(itr.hasNext()) {
         String next = itr.next();
         if(next.length() >= minimumWordLength && isValidWord(next) && !isOnBoard(next).isEmpty()) {
            score+= (next.length() - minimumWordLength) + 1;
         }
      }
      return score;
   }
   
   /**
    * Determines if the given word is in the lexicon.
    * 
    * @param wordToCheck The word to validate
    * @return true if wordToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public boolean isValidWord(String wordToCheck) {
      if (wordToCheck == null) {
         throw new IllegalArgumentException("IAE");
      }
      if(WordBank == null) {
         throw new IllegalStateException("ISE");
      }
      
      return WordBank.contains(wordToCheck.toUpperCase());
   }
   
   /**
    * Determines if there is at least one word in the lexicon with the 
    * given prefix.
    * 
    * @param prefixToCheck The prefix to validate
    * @return true if prefixToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if prefixToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public boolean isValidPrefix(String prefixToCheck) {
      if(prefixToCheck == null) {
         throw new IllegalArgumentException();
      }
      
      if(WordBank == null) {
         throw new IllegalStateException();
      }
      
      prefixToCheck = prefixToCheck.toUpperCase();
      
      return WordBank.subSet(prefixToCheck, prefixToCheck + Character.MAX_VALUE).size() > 0;
   }
       
   /**
    * Determines if the given word is in on the game board. If so, it returns
    * the path that makes up the word.
    * @param wordToCheck The word to validate
    * @return java.util.List containing java.lang.Integer objects with  the path
    *     that makes up the word on the game board. If word is not on the game
    *     board, return an empty list. Positions on the board are numbered from zero
    *     top to bottom, left to right (i.e., in row-major order). Thus, on an NxN
    *     board, the upper left position is numbered 0 and the lower right position
    *     is numbered N^2 - 1.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public List<Integer> isOnBoard(String wordToCheck) {
      if(wordToCheck == null) {
         throw new IllegalArgumentException("IAE");
      }
      if(WordBank == null) {
         throw new IllegalStateException("ISE");
      }
      
      wordToCheck = wordToCheck.toUpperCase();
      List<Integer> path = new ArrayList<Integer>();
      
      for(int i = 0; i < BoardLetters.length; i++) {
         for(int j = 0; j < BoardLetters.length; j++) {
            if(wordToCheck.startsWith(BoardLetters[i][j])) {
               path.add(i + (j * BoardLetters.length));
               
               path = dfs2(wordToCheck, path);
               
               if(path.size() == wordToCheck.length()){
                  return path;
               }
               path.remove(0);
            }
         }
         
      
      }
      return path;
   }
      
      
   private List<Integer> dfs2(String wordToCheck, List<Integer> path) {
      int row = (int)Math.floor(path.get(path.size()-1) / BoardLetters.length);
      int column = path.get(path.size()-1) % BoardLetters.length;
      int pathLength = path.size();
         
      for(int k = row - 1; k < row + 2; k++) {
         for(int n = column - 1; n < column + 2; n++) {
            if(k < 0 || n < 0 || k >= BoardLetters[0].length || k >= BoardLetters[0].length) {
               continue;
            }
               
            int temp = k + (n * BoardLetters.length);
               
            if(wordToCheck.length() == pathLength) {
               return path;
            }
               
            else if (wordToCheck.length() == dfs2(wordToCheck, path).size()) {
               return dfs2(wordToCheck, path);
            }
            else {
               path.remove(pathLength - 1);
            }
         }
            
      }
      return path;
   }
      
   private void markAllUnvisited() {
      visited = new boolean[BoardLetters.length][BoardLetters[0].length];
      for(boolean[] row : visited) {
         Arrays.fill(row, false);
      }
   }

    ///////////////////////////////////////////
   // Position class and associated methods //
   ///////////////////////////////////////////

   /**
    * Models an (x,y) position in the grid.
    */
   private class Position {
      int x;
      int y;
   
      /** Constructs a Position with coordinates (x,y). */
      public Position(int x, int y) {
         this.x = x;
         this.y = y;
      }
   
      /** Returns a string representation of this Position. */
      @Override
      public String toString() {
         return "(" + x + ", " + y + ")";
      }
   
      /** Returns all the neighbors of this Position. */
      public Position[] neighbors() {
         Position[] nbrs = new Position[MAX_NEIGHBORS];
         int count = 0;
         Position p;
         // generate all eight neighbor positions
         // add to return value if valid
         for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
               if (!((i == 0) && (j == 0))) {
                  p = new Position(x + i, y + j);
                  if (isValid(p)) {
                     nbrs[count++] = p;
                  }
               }
            }
         }
         return Arrays.copyOf(nbrs, count);
      }
   }

   /**
    * Is this position valid in the search area?
    */
   private boolean isValid(Position p) {
      return (p.x >= 0) && (p.x < numRows) && 
            (p.y >= 0) && (p.y < numCols);
   }

   /**
    * Has this valid position been visited?
    */
   private boolean isVisited(Position p) {
      return visited[p.x][p.y];
   }

   /**
    * Mark this valid position as having been visited.
    */
   private void visit(Position p) {
      visited[p.x][p.y] = true;
   }


  
}
