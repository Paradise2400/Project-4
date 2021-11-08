import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws IOException {
        String test = "src/data_sorted.txt";
        String test2 = "src/data_random.txt";

        //Creating array from data_sorted file
        Integer[] testArray = new Integer [100];
        File sorted = new File(test);
        Scanner x = new Scanner(sorted);
        for(int i = 0; i < 100; i++){
            testArray[i] = Integer.valueOf(x.nextLine());
        }

        //Creating array from data_random file
        Integer[] testArray2 = new Integer [100];
        File random= new File(test2);
        Scanner y = new Scanner(random);
        for(int i = 0; i < 100; i++){
            testArray2[i] = Integer.valueOf(y.nextLine());
        }

        //Creating output.txt
        File output = new File("src/output.txt");
        PrintWriter pw = new PrintWriter(output);

        //Sequential Insertion test using data_sorted
        MaxHeap<Integer> addMaxHeap = new MaxHeap<>(1000);
        addMaxHeap.sequentialInsert(testArray);
        pw.write("Heap built using sequential insertions:" + addMaxHeap.getTen());
        pw.println();
        pw.write("Number of swaps in the heap creation:" + addMaxHeap.counter);
        pw.println();
        for(int i = 0; i < 10; i++){
            addMaxHeap.removeMax();
        }
        pw.write("Heap after 10 removals:" + addMaxHeap.getTen());
        pw.println();
        pw.println();
        pw.println();

        //Sequential Insertion test using data_random
        MaxHeap<Integer> addMaxHeap2 = new MaxHeap<>(1000);
        addMaxHeap2.sequentialInsert(testArray2);
        pw.write("Heap built using sequential insertions:" + addMaxHeap2.getTen());
        pw.println();
        pw.write("Number of swaps in the heap creation:" + addMaxHeap2.counter);
        pw.println();
        for(int i = 0; i < 10; i++){
            addMaxHeap2.removeMax();
        }
        pw.write("Heap after 10 removals:" + addMaxHeap2.getTen());
        pw.println();
        pw.println();
        pw.println();

        //Optimal Method test using data_sorted
        MaxHeap<Integer> addMaxHeap3 = new MaxHeap<>(1000);
        addMaxHeap3.optimalMethod(testArray);
        pw.write("Heap built using optimal method:" + addMaxHeap3.getTen());
        pw.println();
        pw.write("Number of swaps in the heap creation:" + addMaxHeap3.counter);
        pw.println();
        for(int i = 0; i < 10; i++){
            addMaxHeap3.removeMax();
        }
        pw.write("Heap after 10 removals:" + addMaxHeap3.getTen());
        pw.println();
        pw.println();
        pw.println();

        //Optimal Method test using data_random
        MaxHeap<Integer> addMaxHeap4 = new MaxHeap<>(1000);
        addMaxHeap4.optimalMethod(testArray2);
        pw.write("Heap built using optimal method:" + addMaxHeap4.getTen());
        pw.println();
        pw.write("Number of swaps in the heap creation:" + addMaxHeap4.counter);
        pw.println();
        for(int i = 0; i < 10; i++){
            addMaxHeap4.removeMax();
        }
        pw.write("Heap after 10 removals:" + addMaxHeap4.getTen());

        pw.close();
    }
}
