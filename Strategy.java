import java.util.*;

interface SortingTechniques {
    void sort(int[] arr);
}

class BubbleSort implements SortingTechniques {
    public void sort(int[] numbers) {
        System.out.println("Sorting using Bubble Sort...");
        
        Arrays.sort(numbers); // Using built-in sort for simplicity
    }
}

class SelectionSort implements SortingTechniques {
    public void sort(int[] numbers) {
        System.out.println("Sorting using selecction Sort...");
        
        Arrays.sort(numbers); // Using built-in sort for simplicity
    }
}

class InsertionSort implements SortingTechniques {
    public void sort(int[] numbers) {
        System.out.println("Sorting using insertion Sort...");
        
        Arrays.sort(numbers); // Using built-in sort for simplicity
    }
}

class QuickSort implements SortingTechniques {
    public void sort(int[] numbers) {
        System.out.println("Sorting using Quick Sort...");
        Arrays.sort(numbers); // Using built-in sort for simplicity
    }
}

class MergeSort implements SortingTechniques {
    public void sort(int[] numbers) {
        System.out.println("Sorting using merge Sort...");
        
        Arrays.sort(numbers); // Using built-in sort for simplicity
    }
}

public class Strategy {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};

        SortingTechniques sorter = new MergeSort(); // Change to any sorting algorithm
        sorter.sort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}