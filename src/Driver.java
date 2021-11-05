import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Driver {
    public static void main(String[] args) throws IOException {
        String test = "src/data_sorted.txt";
        String test2 = "src/data_random.txt";
        File output = new File("src/output.txt");
        PrintWriter pw = new PrintWriter(output);

        //Sequential Insertion test using data_sorted
        MaxHeap<Integer> addMaxHeap = new MaxHeap<>(1000);
        addMaxHeap.sequentialInsert(test);
        pw.write("Heap built using sequential insertions:" + addMaxHeap.getTen());
        pw.println();
        pw.write("Number of swaps in the heap creation:");
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
        addMaxHeap2.sequentialInsert(test2);
        pw.write("Heap built using sequential insertions:" + addMaxHeap2.getTen());
        pw.println();
        pw.write("Number of swaps in the heap creation:");
        pw.println();
        for(int i = 0; i < 10; i++){
            addMaxHeap2.removeMax();
        }
        pw.write("Heap after 10 removals:" + addMaxHeap2.getTen());

        pw.close();
    }
}
