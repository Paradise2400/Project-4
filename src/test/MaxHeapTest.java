package test;

import main.MaxHeap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxHeapTest
{
    @Test
    void getTen()
    {
        MaxHeap<Integer> addMaxHeap = new MaxHeap<>(1000);
        for(int i = 0; i < 100; i++){
            addMaxHeap.add(i);
        }

        String test = addMaxHeap.getTen();
        String actual = " 99 93 98 76 92 97 60 67 75 83";

        assertEquals(test,actual);
    }

    @Test
    void sequentialInsert()
    {
        MaxHeap<Integer> addMaxHeapWSequential = new MaxHeap<>(1000);

        Integer[] testArray = new Integer[100];
        for(int i = 0; i < 100; i++){
            testArray[i] = i;
        }

        addMaxHeapWSequential.sequentialInsert(testArray);

        String actual = " 99 93 98 76 92 97 60 67 75 83";
        String test = addMaxHeapWSequential.getTen();

        assertEquals(test,actual);
    }

    @Test
    void optimalMethod()
    {
        MaxHeap<Integer> addMaxHeapWOptimal = new MaxHeap<>(1000);
        Integer[] testArray = new Integer[100];
        for(int i = 0; i < 100; i++){

            testArray[i] = i;
        }

        addMaxHeapWOptimal.optimalMethod(testArray);
        String actual = " 99 94 98 78 93 97 62 70 77 86";
        String test = addMaxHeapWOptimal.getTen();

        assertEquals(test,actual);

    }
}
