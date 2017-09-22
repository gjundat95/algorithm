package sorting;

/**
 * Created by tinhngo on 9/19/17.
 */
public class SortLibrary {

    private int partition(int array[], int low, int high) {

        int pivot = array[high];
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if(array[j] <= pivot ) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i+1;
    }

    /***
     * QuickSort Library
     * @param array
     * @param low
     * @param high
     */
    public void quickSort(int array[], int low, int high) {

        if(low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi -1);
            quickSort(array, pi + 1, high);
        }
    }

    private void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public void heapSort(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

}
