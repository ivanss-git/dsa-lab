package arrays_and_hashing;

import java.util.Arrays;
import utils.MyClass;

public class ArrayBasics {

    /**
     * Constant reference to data array stored on the heap.
     */
    private static final int[] ARR1 = {99, 88, 77, 66};

    /**
     * 1. Added Constant String Literal to eliminate duplication warnings.
     */
    private static final String LOG_FORMAT_STRING = "Index: %d - Element value: %d";

    // Hide implicit public constructor for utility/demo architecture
    private ArrayBasics() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void benchmarkFunction(Runnable functionToTest) {
        Runtime runtime = Runtime.getRuntime();
        long startMem = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();
        
        functionToTest.run();
        
        long endTime = System.nanoTime();
        long endMem = runtime.totalMemory() - runtime.freeMemory();
        
        MyClass.log("Time: " + (endTime - startTime) / 1_000_000.0 + " ms"); 
        MyClass.log("Memory Used: " + (endMem - startMem) + " bytes");
    }

    /**
     * Sequential forward array traversal.
     * Time Complexity: O(n)
     */
    public static int displayArray() {
        MyClass.log("\nThe array object heap address will be the same for all elements.\n");
        MyClass.log("Array object heap address: " + ARR1);
        MyClass.log("\n---Forward traversal---");

        for (int i = 0; i < ARR1.length; i++) {
            MyClass.log(String.format(LOG_FORMAT_STRING, i, ARR1[i]));
        }
        return 0;
    }

    /**
     * Backward array traversal starting from the final index pointer.
     * Time Complexity: O(n)
     */
    public static int reverseTraverseArray() {
        MyClass.log("---Reverse traversal---");
        for (int i = ARR1.length - 1; i >= 0; i--) {
            MyClass.log(String.format(LOG_FORMAT_STRING, i, ARR1[i]));
        } 
        return 0;
    }

    /**
     * Skips elements sequentially by stepping bounds.
     * Time Complexity: O(n)
     */
    public static int steppingByIntervalsArray() {
        MyClass.log("---Stepping by intervals---");
        for (int i = 0; i < ARR1.length; i += 2) {
            MyClass.log(String.format(LOG_FORMAT_STRING, i, ARR1[i]));
        }
        return 0;
    }

    /**
     * Locates a specified targeting integer sequentially.
     * Time Complexity: O(n)
     */
    public static int linearSearch(int[] arr, int target) {
        MyClass.log("---Linear Search---");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                MyClass.log("Target value " + target + " found at index: " + i);
                return i;
            }
        }
        return -1;
    }

    /**
     * Copies and expands static allocation arrays to append incoming values.
     * Returns a new array containing the data to avoid reference mutation bugs.
     * Time Complexity: O(n)
     */
    public static int[] insertAndReturn(int[] sourceArr, int newValue) {
        MyClass.log("---Inserting a value---");

        int[] resultArr = new int[sourceArr.length + 1];
        System.arraycopy(sourceArr, 0, resultArr, 0, sourceArr.length);
        resultArr[resultArr.length - 1] = newValue;

        for (int j = 0; j < resultArr.length; j++) {
            MyClass.log(String.format(LOG_FORMAT_STRING, j, resultArr[j]));          
        }
        MyClass.log("The manual array has a size of: " + resultArr.length + " elements");
        return resultArr;
    }

    /**
     * Custom lightweight implementation of an integer dynamic list.
     */
    public static class DynamicArray {
        private int[] elements;
        private int size;

        public DynamicArray() {
            this.elements = new int[5];
            this.size = 0;
        }

        public void add(int element) {
            if (size == elements.length) {
                resize();
            }
            elements[size] = element;
            size++;
        }

        private void resize() {
            int[] newArr = new int[elements.length * 2];
            System.arraycopy(elements, 0, newArr, 0, elements.length);
            elements = newArr;
        }

        public int getSize() {
            return this.size;
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOf(elements, size));
        }
    }

    public static void runBenchmarks() {
        MyClass.log("---Testing Display Array---");
        benchmarkFunction(ArrayBasics::displayArray);

        MyClass.log("---Testing Reverse Traversal---\n");
        benchmarkFunction(ArrayBasics::reverseTraverseArray);

        MyClass.log("---Testing Step by Intervals---");
        benchmarkFunction(ArrayBasics::steppingByIntervalsArray);

        MyClass.log("---Testing Linear Search---");
        benchmarkFunction(() -> linearSearch(ARR1, 66));

        MyClass.log("---Testing Array Insertion---");
        benchmarkFunction(() -> insertAndReturn(ARR1, 5));

        MyClass.log("---Testing Dynamic Array---"); 
        benchmarkFunction(() -> {
            DynamicArray dynamicList = new DynamicArray();
            for (int i = 0; i < 10; i++) {
                dynamicList.add(i * 10);
            }
            MyClass.log("Dynamic Array Content: " + dynamicList);
        });
    }

    public static void main(String[] args) {
        runBenchmarks();
    }
}

