package main;

import sorting.SortLibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by tinhngo on 9/19/17.
 */
public class MainSort {

    public static final String path = "file.inp";
    public static int[] array;
    public static int n;

    public static void main(String[] args) {

        ReadFile();

        SortLibrary sortLibrary = new SortLibrary();

        printArray(array);

        sortLibrary.quickSort(array, 0, n - 1);
        //sortLibrary.heapSort(array);

        printArray(array);


    }

    static void printArray(int array[]) {
        System.out.print("\n");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    static void ReadFile() {
        try {
            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String lineStr;
            int line = 1;
            while ((lineStr = bufferedReader.readLine()) != null) {
                if(line == 1) {
                    n = Integer.parseInt(lineStr);
                    array = new int[n];
                    line++;
                } else {
                    String[] temp = lineStr.split(" ");
                    for (int i = 0; i < n; i++) {
                        array[i] = Integer.parseInt(temp[i]);
                    }
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
