package ArraysAndHashing;
import java.lang.Runnable;

public class DynamicArray {
    public class DynamicImplementation {
        // these instance fields live on the HEAP inside the DynamicArrayObject
        private int[] array;
        private int size;

        /**
         * Initializes the dynamic array with a default capacity of 5.
         * The DynamicArray object and the underlying array are both allocated on the HEAP.
         */
        public DynamicImplementation() {
            array = new int[5];
            size = 0;
        }

        /**
         * Adds an element to the array.
         * Time complexity: Amortized O(1).
         */
        public void add(int element) {
            // first check if its completely full
            if ( size == array.length) {
                resize();
            }
            // then insert the element and increment size
            array[size] = element;
            size++;
        }

        /**
         * Doubles the capacity of the underlying array when full.
         * 
         * Memory and complexity: 
         * - Time complexity: O(n) due to the element copying loop.
         * - @newArr: A temporary reference variable stored on the STACK frame of this method.
         * - The actual new int array block it points to is allocated on the HEAP.
         * - Garbage Collection: The old heap array is abandoned and automatically freed later.
         */
        public void resize() {
            // new arr is double the size of the original
            int[] newArr = new int[array.length * 2];
            // copy the elements of old array into the new array
            for (int i = 0; i < array.length; i++) {
                newArr[i] = array[i];
            }
            // lastly, replace the old reference by overriding the old heap reference with the new heap reference.
            array = newArr;
        }  
    }

    public void benchmarkFunction(Runnable functionToTest) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long startMem = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();
        functionToTest.run();
        long endTime = System.nanoTime();
        long endMem = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Time: " + (endTime - startTime) / 1_000_000.0 + " ms"); 
        System.out.println("Memory Used: " + (endMem - startMem) + " bytes");
    }

    public void dynamicTesting() {
        System.out.println("---Testing Dynamic Array---"); 
        this.benchmarkFunction(() -> {
            DynamicArray.DynamicImplementation customArr = new DynamicImplementation(); 
            for (int i = 0; i < 100_000; i++) {
                customArr.add(i);
            }
        });
    }
    public static void main (String[] args) {
        DynamicArray demo = new DynamicArray();
        demo.dynamicTesting();
    }
}