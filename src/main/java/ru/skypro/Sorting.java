package ru.skypro;

import java.util.Random;

public class Sorting {

    static final Random random = new Random();

    public static void main(String[] args) {
//        double timeForBubbleSort = timeForBubbleSort(5);
//        System.out.println("Average time for Bubble sort: " + timeForBubbleSort + " ms.");
//
//        double timeForSelectionSort = timeForSelectionSort(5);
//        System.out.println("Average time for Selection sort: " + timeForSelectionSort + " ms.");
//
//        double timeForInsertionSort = timeForInsertionSort(5);
//        System.out.println("Average time for Insertion sort: " + timeForInsertionSort + " ms.");

        timeForBubbleSort();
        timeForSelectionSort();
        timeForInsertionSort();

    }


    private static void timeForBubbleSort() {
//        double sum = 0;
//        for (int i = 0; i < iteration; i++) {
        int[] arr = generateArray(100_000);
        long start = System.currentTimeMillis();
        sortBubble(arr);
//            long stop = System.currentTimeMillis() - start;
//            sum += end;
//        }
//        return sum / iteration;
        System.out.println("Bubble sort: " + (System.currentTimeMillis() - start) + "ms.");
    }

    private static void timeForSelectionSort() {
//        double sum = 0;
//        for (int i = 0; i < iteration; i++) {
        int[] arr = generateArray(100_000);
        long start = System.currentTimeMillis();
        sortSelection(arr);
//            long stop = System.currentTimeMillis() - start;
//            sum += end;
//        }
//        return sum / iteration;
        System.out.println("Selection sort: " + (System.currentTimeMillis() - start) + "ms.");
    }

    private static void timeForInsertionSort() {
//        double sum = 0;
//        for (int i = 0; i < iteration; i++) {
        int[] arr = generateArray(100_000);
        long start = System.currentTimeMillis();
        sortInsertion(arr);
//            long stop = System.currentTimeMillis() - start;
//            sum += end;
//        }
//        return sum / iteration;
        System.out.println("Insertion sort: " + (System.currentTimeMillis() - start) + "ms.");
    }

    private static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    private static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    private static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

}
