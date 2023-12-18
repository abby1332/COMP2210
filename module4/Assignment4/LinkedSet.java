import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides an implementation of the Set interface.
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the interface, this linked list is
 * maintained in ascending natural order. In those methods that
 * take a LinkedSet as a parameter, this order is used to increase
 * efficiency.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @author Abigail Miller (amm0257@auburn.edu)
 *
 */
public class LinkedSet<T extends Comparable<T>> implements Set<T> {

   //////////////////////////////////////////////////////////
   // Do not change the following three fields in any way. //
   //////////////////////////////////////////////////////////

   /** References to the first and last node of the list. */
   Node front;
   Node rear;

   /** The number of nodes in the list. */
   int size;

   /////////////////////////////////////////////////////////
   // Do not change the following constructor in any way. //
   /////////////////////////////////////////////////////////

   /**
    * Instantiates an empty LinkedSet.
    */
   public LinkedSet() {
      front = null;
      rear = null;
      size = 0;
   }


   //////////////////////////////////////////////////
   // Public interface and class-specific methods. //
   //////////////////////////////////////////////////

   ///////////////////////////////////////
   // DO NOT CHANGE THE TOSTRING METHOD //
   ///////////////////////////////////////
   /**
    * Return a string representation of this LinkedSet.
    *
    * @return a string representation of this LinkedSet
    */
   @Override
   public String toString() {
      if (isEmpty()) {
         return "[]";
      }
      StringBuilder result = new StringBuilder();
      result.append("[");
      for (T element : this) {
         result.append(element + ", ");
      }
      result.delete(result.length() - 2, result.length());
      result.append("]");
      return result.toString();
   }


   ///////////////////////////////////
   // DO NOT CHANGE THE SIZE METHOD //
   ///////////////////////////////////
   /**
    * Returns the current size of this collection.
    *
    * @return  the number of elements in this collection.
    */
   public int size() {
      return size;
   }

   //////////////////////////////////////
   // DO NOT CHANGE THE ISEMPTY METHOD //
   //////////////////////////////////////
   /**
    * Tests to see if this collection is empty.
    *
    * @return  true if this collection contains no elements, false otherwise.
    */
   public boolean isEmpty() {
      return (size == 0);
   }


   /**
    * Ensures the collection contains the specified element. Neither duplicate
    * nor null values are allowed. This method ensures that the elements in the
    * linked list are maintained in ascending natural order.
    *
    * @param  element  The element whose presence is to be ensured.
    * @return true if collection is changed, false otherwise.
    */
   public boolean add(T element) {
      if(element == null || this.contains(element)) {
         return false;
      }
      
      //Create a node with parameter value
      Node n = new Node(element);
      
      Node temp = front;
      Node prev = null;
      
      //If this is the first element of the set
      if(temp == null) {
         rear = n;
         front = n;
         size++;
         return true;
      }
      
     //Finds the first node containing a value greater than element
      while((temp != null) && (element.compareTo(temp.element) > 0)) {
         prev = temp;
         temp = temp.next;
      }
      
      //If element is the smallest value
      if(temp == front) {
         front.prev = n;
         n.next = front;
         front = n;
         size++;
         return true;
      }
      
      //If element is the largest value
      if(temp == null) {
         prev.next = n;
         n.prev = prev;
         
         rear = n;
         
         size++;
         return true;
      }
      
      //Otherwise, if element is somewhere in the middle
      else {
         prev.next = n;
         temp.prev = n;
         n.next = temp;
         n.prev = prev;
         size++;
         return true;
      }
      
      
   }

   /**
    * Ensures the collection does not contain the specified element.
    * If the specified element is present, this method removes it
    * from the collection. This method, consistent with add, ensures
    * that the elements in the linked lists are maintained in ascending
    * natural order.
    *
    * @param   element  The element to be removed.
    * @return  true if collection is changed, false otherwise.
    */
   public boolean remove(T element) {
      if(element == null) {
         return false;
      }
   
      Node n = front;
      Node prev = null;
      //Iterate thru the list to find when n = element
      while((n != null) && (!n.element.equals(element))) {
         prev = n;
         n = n.next;
      }
      
      //If n = null then the element isn't in the list
      if (n == null) {
         return false;
      }
         
      //n is the only element in the set
      else if(n == front && n == rear) {
         front = null;
         rear = null;
         size--;
         return true;
      }
      
      //Otherwise, if n is at the front, simply delete it by
      // getting rid of that connection
      else if (n == front) {
         front = front.next;
         n.prev = null;
         n.next.prev = null;
         n.next = null;
         size--;
         return true;
      }
      
      //If n is in the back
      else if (n == rear) {
         rear = rear.prev;
         n.prev = null;
         prev.next = null;
         size--;
         return true;
      }
      
      //If n is somewhere else, delete it using the previous method
      else {
         n.prev.next = n.next;
         n.next.prev = n.prev;
         
      }
      size--;
      return true;
   } 


   /**
    * Searches for specified element in this collection.
    *
    * @param   element  The element whose presence in this collection is to be tested.
    * @return  true if this collection contains the specified element, false otherwise.
    */
   public boolean contains(T element) {
      if(element == null) {
         return false;
      }
      
      Node p = front;
      while (p != null) {
         if(p.element.equals(element)) {
            return true;
         }
         p = p.next;
      }
      return false;
   }


   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements as
    *               the parameter set, false otherwise
    */
   public boolean equals(Set<T> s) {
      if(s == null) {
         return false;
      }
   //if they are different sizes, they're not the same.
      if(this.size != s.size()) {
         return false;
      }
    //otherwise compare the elements  
      for (T element : this) {
         if (!s.contains(element)) {
            return false;
         }
      }
      
      return true;
   
   }


   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements as
    *               the parameter set, false otherwise
    */
   public boolean equals(LinkedSet<T> s) {
      if(s == null) {
         return false;
      }
     //if they are different sizes, they're not the same.
      if(this.size != s.size()) {
         return false;
      }
    //otherwise compare the elements  
      for ( T element : this) {
         if (!s.contains(element)) {
            return false;
         }
      }
      
      return true;
   }


   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and the parameter set
    */
   public Set<T> union(Set<T> s){
      if(s.isEmpty()) {
         return this;
      }
      if(this.isEmpty()){
         return s;
      }
      
      for(T element : this) {
         s.add(element);
      }
      return s;
   }


   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and the parameter set
    */
   public Set<T> union(LinkedSet<T> s){
      if(s.isEmpty()) {
         return this;
      }
      if(this.isEmpty()) {
         return s;
      }
     
      for(T element : this) {
         s.add(element);
      }
      return s;
   }


   /**
    * Returns a set that is the intersection of this set and the parameter set.
    *
    * @return  a set that contains elements that are in both this set and the parameter set
    */
   public Set<T> intersection(Set<T> s) {
   //make sure not empty
      if(this.isEmpty() || s.isEmpty()) {
         return new LinkedSet<T>();
      }
      Set<T> temp = new LinkedSet();
      
      for(T element : this) {
         if(s.contains(element)) {
            temp.add(element);
         }
      }
      
      return temp;
   }

   /**
    * Returns a set that is the intersection of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in both
    *            this set and the parameter set
    */
   public Set<T> intersection(LinkedSet<T> s) {
      if(s.isEmpty() || this.isEmpty()) {
         return new LinkedSet();
      }
      LinkedSet<T> temp = new LinkedSet();
      Node p1 = this.front;
      Node p2 = s.front;
      
      //Compare the elements of both linked sets.
      //If one is less than the other, iterate that one.
      //If they are equal, add the element to temp
      //and iterate both.
      
      while(p1 != null && p2 != null) {
         if(p1.element.compareTo(p2.element) > 0) {
            p2 = p2.next;
         }
         else if(p2.element.compareTo(p1.element) > 0) {
            p1 = p1.next;
         }
         else {
            temp.addRear(p1.element);
            p1 = p1.next;
            p2 = p2.next;
         }
      }
      
      return temp;      
   }


   /**
    * Returns a set that is the complement of this set and the parameter set.
    *
    * @return  a set that contains elements that are in this set but not the parameter set
    */
   public Set<T> complement(Set<T> s) {
      Set<T> temp = new LinkedSet();
   
      if(this.isEmpty()) {
         return temp;
      }
      if(s.isEmpty()) {
         return this;
      }
   
      
      for(T element : this) {
         if(!s.contains(element)) {
            temp.add(element);
         }
      }
      return temp;
   }


   /**
    * Returns a set that is the complement of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in this
    *            set but not the parameter set
    */
   public Set<T> complement(LinkedSet<T> s) {
      LinkedSet<T> result = new LinkedSet();
      
      if(this.isEmpty()) {
         return result;
      }
      if(s.isEmpty()) {
         return this;
      }
      
      Node p1 = this.front;
      Node p2 = s.front;
      
      while(p1 != null && p2 != null) {
         // p1 < p2
         
         if(p1.element.compareTo(p2.element) < 0) {
            result.add(p1.element);
            p1 = p1.next;
         }
         // p1 = p2
         else if (p1.element.equals(p2.element)) {
            p1 = p1.next;
            p2 = p2.next;
         }
         // p1 > p2
         else {
            p2 = p2.next;
         }
      }
      
      if (p2 == null) {
         while(p1 != null) {
            result.add(p1.element);
            p1 = p1.next;
         }
      }
      
      return result;
   }


   /**
    * Returns an iterator over the elements in this LinkedSet.
    * Elements are returned in ascending natural order.
    *
    * @return  an iterator over the elements in this LinkedSet
    */
   public Iterator<T> iterator() {
      return new LinkedIterator(this);
   }


   /**
    * Returns an iterator over the elements in this LinkedSet.
    * Elements are returned in descending natural order.
    *
    * @return  an iterator over the elements in this LinkedSet
    */
   public Iterator<T> descendingIterator() {
      return new DescendingIterator(this);
   }


   /**
    * Returns an iterator over the members of the power set
    * of this LinkedSet. No specific order can be assumed.
    *
    * @return  an iterator over members of the power set
    */
   public Iterator<Set<T>> powerSetIterator() {
      return new LinkedSetPowerSetIterator(this);
   }



   //////////////////////////////
   // Private utility methods. //
   //////////////////////////////

   // Feel free to add as many private methods as you need.
   
   private boolean addRear(T element) {
      if(element == null || this.contains(element)) {
         return false;
      }
      
      //Create a node with parameter value
      Node n = new Node(element);
      
      //Checks if the list is empty  
      if(front == null) {  
            //If list is empty, both head and tail will point to new node  
         front = n;  
         rear = n; 
         size++;
         return true; 
      }  
      
      else {
         Node p = rear;
         p.next = n;
         n.prev = p;
         rear = n;
         size++;
         return true;
      }        
   }
 
      
   

   ////////////////////
   // Nested classes //
   ////////////////////
   private class LinkedIterator implements Iterator<T> {
      public Node current;
      
      public LinkedIterator(LinkedSet<T> s) {
         current = s.front;
      }
      
      
      public boolean hasNext() {
         return (current != null);
      }
      
      public T next() {
         
         T result = (T) current.element;
         current = current.next;
         return result;
      }
   }
      
      
   private class DescendingIterator implements Iterator<T> {
      Node current;
      
      //same as iterator except use rear instead of front and
      //prev instead of next so its descending.
      
      public DescendingIterator(LinkedSet<T> s) {
         current = s.rear;
      }
      
      public boolean hasNext() {
         return (current != null);
      }
      
      public T next() {
         T result = (T) current.element;
         current = current.prev;
         return result;
      }
   }
    
    
   private class LinkedSetPowerSetIterator implements Iterator<Set<T>> {
    // cardinality of this set
      int N;
   
    // cardinality of the power set (2^N)
      int M;
   
    // the integer identifier of the current subset, i.e. the current element
    // of the power set. Legal values range from 0..M-1 inclusive.
      int current;
      
      Node p;
      Node n;
      
      char[] bitstring;
      
      public LinkedSetPowerSetIterator(LinkedSet<T> s) {
        // initialize N, M, and current here
         current = 0;
         M = (int) Math.pow(2, s.size());
         bitstring = Integer.toBinaryString(current).toCharArray();
         N = 0;
      }
   
      public boolean hasNext() {
         return current < M;
      }
   
      public Set<T> next() {
         LinkedSet<T> result = new LinkedSet<T>();
         Node p = n;
      
        // iterate from right to left over bitstring and the internal
        // linked list to ensure that the call to add will insert a new
        // first node (constant time)
         for(int i = bitstring.length - 1; i >= 0; i--) {
            if(bitstring[i] == '1') {
               result.add(p.element);
            }
            if (p != null) {
               p = p.next;
            }
         }
         bitstring = Integer.toBinaryString(++current).toCharArray();
         return result;
      }
   
      public void remove() {
      
      }
   } 

   //////////////////////////////////////////////
   // DO NOT CHANGE THE NODE CLASS IN ANY WAY. //
   //////////////////////////////////////////////

   /**
    * Defines a node class for a doubly-linked list.
    */
   class Node {
      /** the value stored in this node. */
      T element;
      /** a reference to the node after this node. */
      Node next;
      /** a reference to the node before this node. */
      Node prev;
   
      /**
       * Instantiate an empty node.
       */
      public Node() {
         element = null;
         next = null;
         prev = null;
      }
   
      /**
       * Instantiate a node that containts element
       * and with no node before or after it.
       */
      public Node(T e) {
         element = e;
         next = null;
         prev = null;
      }
      
     
   }
}
