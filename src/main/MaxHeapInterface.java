package main;

/**
   An interface for the ADT maxheap.
*/
public interface MaxHeapInterface<T extends Comparable<? super T>>
{  // See Segment 24.33 for a commented version.
   /**
    * Adds new object of type T to maxheap array
    * @param newEntry object of type T
    */
   public void add(T newEntry);

   /**
    * Removes the root of the maxHeap array and reheaps the root so a new root is found
    * @return root of maxHeap
    */
   public T removeMax();

   /**
    * Obtains the maximum value in the heap which is the root
    * @return object of type T
    */
   public T getMax();

   /**
    * If the lastIndex is <1 then there are no elements in the array
    * @return True or False if the maxHeap array is not empty or empty respectively
    */
   public boolean isEmpty();

   /**
    * The lastIndex determines the size of the array as it is the leaf node
    * @return Integer of the size of the array
    */
   public int getSize();

   /**
    * Clears the entries of the array from the last element to the root
    */
   public void clear();
} // end MaxHeapInterface
