
public class LinkedSetClient {
   public static void main(String[] args) {
      Set<Integer> temp = new LinkedSet<>();
   //testing add
      LinkedSet<Integer> list = new LinkedSet<>();
      
      list.add(1);
      list.add(5);
      list.add(3);
      list.add(10);
      list.add(6);
      
      System.out.println(list);
      
   
   //Testing union
      Set<Integer> list1 = new LinkedSet<>();
      
      list1.add(1);
      list1.add(2);
      list1.add(3);
      
      Set<Integer> list2 = new LinkedSet<>();
      
      list2.add(2);
      list2.add(3);
      list2.add(1);
               
      list1 = list1.union(list2);
      
      System.out.println(list1);
      
      //Testing intersection
      Set<Integer> x = new LinkedSet<>();
      x.add(1);
      x.add(10);
      x.add(12);
      x.add(3);
      
      Set<Integer> y = new LinkedSet<>();
      y.add(1);
      y.add(25);
      y.add(3);
      
      temp = x.intersection(y);
      System.out.println(temp);
      
      //Testing complement
      temp = x.complement(y);
      System.out.println(temp);
      
      System.out.println("TESTING WITH LINKEDSETS");
      LinkedSet<Integer> temp2 = new LinkedSet<>();
      
      LinkedSet<Integer> a = new LinkedSet<>();
      a.add(2);
      a.add(4);
      a.add(6);
      a.add(8);
      a.add(23);
      
      LinkedSet<Integer> b = new LinkedSet<>();
      b.add(1);
      b.add(3);
      b.add(4);
      b.add(5);
      b.add(6);
      b.add(7);
      
      temp = a.intersection(b);
      System.out.println(temp);
      
      temp = a.union(b);
      System.out.println(temp);
      
      temp = a.complement(b);
      System.out.println(temp);
      
   }
}