package main;

import sorting.SortLibrary;

/**
 * Created by tinhngo on 9/19/17.
 */
public class MainSort {

    public static void main(String[] args) {

        int array[] = {1, 4, 0, 9, 8, 3, 2, 2};

        SortLibrary sortLibrary = new SortLibrary();

        printArray(array);

        int n = array.length;

        //sortLibrary.quickSort(array, 0, n - 1);
        sortLibrary.heapSort(array);

        printArray(array);
    }

    static void printArray(int array[]) {
        System.out.print("\n");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
