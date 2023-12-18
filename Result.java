import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

   /*
    * Complete the 'findNumberSequence' function below.
    *
    * The function is expected to return an INTEGER_ARRAY.
    * The function accepts STRING direction as parameter.
    */

   public static List<Integer> findNumberSequence(String direction) {
      char[] arr;
      arr = direction.toCharArray();
      List<Integer> sequence = new ArrayList<Integer>();
      
      double n = Math.pow(2, direction.length());
      
      //Add the middle point from each round to a list
      int high = (int)Math.round(n);
      int mid = high/2;
      int low = 0;
      sequence.add(mid);
      for (char a : arr) {
         if(a == 'L') {
            high = mid;
            mid = (high + low) / 2;
            sequence.add(mid);
         } 
         if(a == 'R') {
            low = mid;
            mid = (high + low) / 2;
            sequence.add(mid);
         }
         
      }
      sequence.remove(sequence.size()-1);
       
      ArrayList<Integer> A = new ArrayList<>(sequence);
      
      Collections.sort(sequence);
      
      List<Integer> b = new ArrayList<>();
      
      for(int i = 0; i < A.size(); i++) {
         int index = A.indexOf(sequence.get(i));
         b.add(index + 1);
      }
   
     
      return b;
   }
    
}
