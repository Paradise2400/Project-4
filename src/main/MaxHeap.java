package main;

import java.util.Arrays;
import java.util.*;
import java.io.*;
/**
   A class that implements the ADT maxheap by using an array.
*/
public final class MaxHeap<T extends Comparable<? super T>>
             implements MaxHeapInterface<T>
{
   private T[] heap;      // Array of heap entries; ignore heap[0]
   private int lastIndex; // Index of last entry and number of entries
   private boolean integrityOK = false;
   private static final int DEFAULT_CAPACITY = 25;
   private static final int MAX_CAPACITY = 10000;
   public int counter = 0;

   /**
    * Calls next constructor
    */
   public MaxHeap()
   {
      this(DEFAULT_CAPACITY); // Call next constructor
   } // end default constructor

   /**
    * Creates MaxHeap with given array of entries of type T
    * @param entries an array of Object type T
    */
   public MaxHeap(T[] entries)
   {
      this(entries.length); // Call other constructor
      lastIndex = entries.length;
      // Assertion: integrityOK = true

      // Copy given array to data field
      for (int index = 0; index < entries.length; index++)
         heap[index + 1] = entries[index];

      // Create heap
      for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
         reheap(rootIndex);
   } // end constructor

   /**
    * Checks if initialization of addMaxHeap done correctly
    */
   private void checkIntegrity()
   {
      if (!integrityOK)
         throw new SecurityException ("ArrayBag object is corrupt.");
   } // end checkintegrity

   /**
    * Ensures that capacity needed by user is within the upperbound limit of CAPACITY
    * @param capacity integer of size of array
    */
   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
                 "allowed maximum of " + MAX_CAPACITY);
   } // end checkCapacity

   /**
    * Initializing MaxHeap array
    * @param initialCapacity integer value declared by user or else default value
    */
   public MaxHeap(int initialCapacity)
   {
      // Is initialCapacity too small?
      if (initialCapacity < DEFAULT_CAPACITY)
         initialCapacity = DEFAULT_CAPACITY;
      else // Is initialCapacity too big?
         checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempHeap = (T[])new Comparable[initialCapacity + 1];
      heap = tempHeap;
      lastIndex = 0;
      integrityOK = true;
   } // end constructor

   /**
    * Adds new object of type T to maxheap array
    * @param newEntry object of type T
    */
   public void add(T newEntry)
   {
      checkIntegrity();        // Ensure initialization of data fields
      int newIndex = lastIndex + 1;
      int parentIndex = newIndex / 2;
      while ( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
      {
         heap[newIndex] = heap[parentIndex];
         newIndex = parentIndex;
         parentIndex = newIndex / 2;
         counter++;
      } // end while

      heap[newIndex] = newEntry;
      lastIndex++;
   } // end add

   /**
    * Removes the root of the maxHeap array and reheaps the root so a new root is found
    * @return root of maxHeap
    */
   public T removeMax()
   {
      checkIntegrity();             // Ensure initialization of data fields
      T root = null;

      if (!isEmpty())
      {
         root = heap[1];            // Return value
         heap[1] = heap[lastIndex]; // Form a semiheap
         lastIndex--;               // Decrease size
         reheap(1);                 // Transform to a heap
      } // end if

      return root;
   } // end removeMax

   /**
    * Obtains the maximum value in the heap which is the root
    * @return object of type T
    */
   public T getMax()
   {
		checkIntegrity();
      T root = null;
      if (!isEmpty())
         root = heap[1];
      return root;
   } // end getMax

   /**
    * If the lastIndex is <1 then there are no elements in the array
    * @return True or False if the maxHeap array is not empty or empty respectively
    */
   public boolean isEmpty()
   {
      return lastIndex < 1;
   } // end isEmpty

   /**
    * The lastIndex determines the size of the array as it is the leaf node
    * @return Integer of the size of the array
    */
   public int getSize()
   {
      return lastIndex;
   } // end getSize

   /**
    * Clears the entries of the array from the last element to the root
    */
   public void clear()
   {
		checkIntegrity();
      while (lastIndex > -1)
      {
         heap[lastIndex] = null;
         lastIndex--;
      } // end while
      lastIndex = 0;
   } // end clear

   /**
    * Obtains the first 10 elements in the array
    * @return String containing the first 10 elements in the array
    */
   public String getTen(){
      String ten = "";
      for(int i = 1; i < 11; i++){
         ten += " ";
         ten += heap[i];
      }
      return ten;
   }

   /**
    * Sequential insert which adds an element in the array one by one with O(nlogn)
    * @param arr input array of type T
    */
   public void sequentialInsert(T arr[]){
      for(int i = 0; i < arr.length; i++){
         this.add(arr[i]);
      }
   }

   /**
    * The faster method using reheap thereby including less swaps O(n)
    * @param arr input array of type T
    */
   public void optimalMethod(T arr[]) {
      for (int index = 0; index < arr.length; index++)
         heap[index + 1] = arr[index];
      //lastIndex
      lastIndex = arr.length;
      // Create heap
      for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
         reheap(rootIndex);
   }
   
// Private methods

   /**
    * When internal node is removed then swaps with the highest element of its children
    * @param rootIndex index of the array to reheap
    */
   private void reheap(int rootIndex) {
   boolean done = false;
   T orphan = heap[rootIndex];
   int leftChildIndex = 2 * rootIndex;

   while (!done && (leftChildIndex <= lastIndex) )
   {
      int largerChildIndex = leftChildIndex; // Assume larger
      int rightChildIndex = leftChildIndex + 1;

      if ( (rightChildIndex <= lastIndex) &&
              heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
      {
         largerChildIndex = rightChildIndex;
      } // end if

      if (orphan.compareTo(heap[largerChildIndex]) < 0)
      {
         heap[rootIndex] = heap[largerChildIndex];
         counter++;
         rootIndex = largerChildIndex;
         leftChildIndex = 2 * rootIndex;
      }
      else
         done = true;
   } // end while

   heap[rootIndex] = orphan;
} // end reheap
} // end MaxHeap
