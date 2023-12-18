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
    * Complete the 'balancedSum' function below.
    *
    * The function is expected to return an INTEGER.
    * The function accepts INTEGER_ARRAY arr as parameter.
    */

   public static int balancedSum(List<Integer> arr) {
      
      int pivot = 0;
      for(int i = 0; i < arr.size(); i++) {
         int leftSum = 0;
         for(int j = 0; j < i; j++) {
            leftSum = arr.get(j) + leftSum;
         }
         int rightSum = 0;
         for(int k = i + 1; k < arr.size(); k++) {
            rightSum = arr.get(k) + rightSum;
         }
         
         if(leftSum == rightSum) {
            pivot = i;
            return pivot;
         }
      }
      return pivot;
   
   }

}
/**
public class Solution {
   public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
   
      int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
   
      List<Integer> arr = IntStream.range(0, arrCount).mapToObj(
         i -> {
            try {
               return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
               throw new RuntimeException(ex);
            }
         })
         .map(String::trim)
         .map(Integer::parseInt)
         .collect(toList());
   
      int result = Result.balancedSum(arr);
   
      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
   
      bufferedReader.close();
      bufferedWriter.close();
   }
}
**/