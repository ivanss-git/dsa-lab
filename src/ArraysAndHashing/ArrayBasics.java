package ArraysAndHashing;
import java.util.ArrayList;
import java.lang.Runtime;

public class ArrayBasics {
    /**
     * arr1 is an instance variable (pointer). Its reference lives on the stack, 
     * while the actual array object is stored on the heap.
     * This array contains 4 integer values.
     */
    static int[] arr1 = {99, 88, 77, 66};

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

/**
 * This function is O(n) since there is a single n function
 * @returns The value at that specific index in the array 
 * @arr1 Is a named slot in memmory (stack) that holds an address
 * The array object is the block of data on the heap. It has no name, only a memory address.
 */
   public int displayArray() {
        System.out.println("\nThe array object heap address will be the same for all since they are all elements of the arr1 array.\n");
        System.out.println("Array object heap address: " + arr1);
        System.out.println("\n---Forward traversal---");

        for (int i = 0; i < arr1.length; i++) {
                int index = i;
                int elementValue = arr1[i];
                System.out.println("Index: " + index + " - Element value: " + elementValue);
            }
            return 0;
   }

   /**
    * This function prints the reverse of the arr1 array.
    * It begins at the last elelmemt and termintes at the first element.
    */
   public int reverseTraverseArray() {
        System.out.println("---Reverse traversal---");
        for (int i  = (arr1.length - 1); i >= 0; i--) {
            int index = i;
            int elementValue = arr1[i];
            System.out.println("Index: " + index + " - Element value: " + elementValue);
        } 
            return 0;
   }

   public int steppingByIntervalsArray() {
        System.out.println("---Stepping by intevrals---");
        for (int i = 0; i < arr1.length; i +=2) {
            int index = i;
            int elementValue = arr1[i];
            System.out.println("Index: " + index + " - Element value: " + elementValue);
        }
        return 0;
   }

   public int linearSearch(int[] arr, int target) {
        System.out.println("---Linear Search---");
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                // the print statement is not needed for leetcode style questions
                System.out.println("Target value " + target + " foound at index: " + i);
                return i;
                // return the index (i) at target, not the value (arr[i])
            }
        }
        return -1;
    }

    /**
     * @newArr This is the new array we create in order to store the new value.
     * @newValue This is the new value that we will insert into the array.
     * 
     * 1. Create a new array that is bigger than the current array
     * 2. Copy the elements of the original array into the new array.
     * 3. Insert the new value into the last position of the new array
     * 
     * We have essentially 
     * 
     * It is actually to double the size to save speed since copying ad creating a new index takes more time and resources.
     * Implement this using a dynamic array.
     */
    public void insertIntoArray(int[] newArr, int newValue) {
        System.out.println("---Inserting a value---");

        // create new array of length + 1
        newArr = new int[arr1.length +1];

        // copy elements from arr1 into newArr
        for (int i = 0; i < arr1.length; i++) {
                newArr[i] = arr1[i];
        }

        // insert the new value into the last positon of the new Array
        newArr[newArr.length - 1] = newValue;
        for (int j = 0; j < newArr.length; j++) {
            int index = j;
            int elementValue = newArr[j];
            System.out.println("Index: " + index + " - Element value: " + elementValue);          
        }
        System.out.println("The manual array has a size of: " + newArr.length + " elements");

    }

    /**
     * A custom implementation of a dynamic array (like ArrayList).
     * 
     * Mechanics and Performance: 
     * - Dynamic heap allocation: Overallocates memory by doubling capacity on resize.
     * - Up to 50% of the newly allocated memory can be wasted after a resize.
     * - Primitive 'int' data is stored directly in memory blocks, avoiding Integer object autoboxing overhead.
     * - Time complexity: Amortized O(1) for additions, spiking to O(n) only during resizing.
     */
    public class DynamicArray {
        // these instance fields live on the HEAP inside the DynamicArrayObject
        private int[] array;
        private int size;

        /**
         * Initializes the dynamic array with a default capacity of 5.
         * The DynamicArray object and the underlying array are both allocated on the HEAP.
         */
        public DynamicArray() {
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

    /**  call the benchmark test using benchmarkFunction(ClassName::methodName)
     * We must invoke functions through the object instance when they are non static.
     * 
     * Instance method references:
     * When a method belongs to an object instance (non-static), you reference it
     * using objectName::methodName instead of ClassName::methodName
     * 
     * Lambda Wrappers for parameters:
     * Runnables interface run() takes zero arguments. Functions like linearSearch(arr, 5)
     * need a temporary wrapper that runnable accepts, like () -> demo.linearSearch(arr1, 66)
     *
     * DynamicArray is non-static and lives inside ArrayBasics, so it requires explicit binding to the parent instance
     * using something like demo.new DynamicArray()
     * 
     * SINCE we moved these tests out of main, we no longer use demo, but this.
    */ 
    public void testing() {
        System.out.println("---Testing Display Array---");
    this.benchmarkFunction(this::displayArray);

    System.out.println("---Testing Reverse Traversal---\n");
    this.benchmarkFunction(this::reverseTraverseArray);

    System.out.println("---Testing Stepby Intervals");
    this.benchmarkFunction(this::steppingByIntervalsArray);

    System.out.println("---Testing LinearSearch---");
    this.benchmarkFunction(() -> linearSearch(arr1, 66));

    System.out.println("---Testing Array Insertion---");
    this.benchmarkFunction(() -> insertIntoArray(arr1, 5));

    System.out.println("---Testing Dynamic Array---"); 
    this.benchmarkFunction(() -> {
        ArrayBasics.DynamicArray customArr = new DynamicArray(); 
        for (int i = 0; i < 100_000; i++) {
            customArr.add(i);
        }
    });
   }

   public void binarySearch() {}

   public void bubbleSortArray() {}

   public void selectionSortArray() {}

   public void insertionSortArray() {}

   public void arrayInsertion() {}

   public void arrayDeletion() {}

   public void reverseAlgo() {}




   public static void main(String[] args) {

    /**
     * Demo is an ArrayBasics object and is stored on the heap since we used the new keyword 
     */
    ArrayBasics demo = new ArrayBasics();
    ArrayList<Integer> numbers = new ArrayList<>();

    // modify so that we can select which function to run unless we quit.
    demo.displayArray();
    demo.reverseTraverseArray();
    demo.steppingByIntervalsArray();
    demo.linearSearch(arr1, 66);
    demo.insertIntoArray(arr1, 5 );
    numbers.add(5);
    numbers.add(3);
    numbers.add(7);
    System.out.println("The dynamic array is: " + numbers);

    demo.testing();
   }
}
