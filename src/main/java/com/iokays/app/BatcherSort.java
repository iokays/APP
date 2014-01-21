package com.iokays.app;

/**
 * Created by andy on 14-1-19.
 */
public class BatcherSort {

    private static void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <E extends Comparable<? super E> > void sort(E[] input) {
        boolean sorted = false;         //假定数组尚未排好序.

        while (!sorted) {
            sorted = true;

            for (int i = 0; i < input.length - 1; i += 2) {
                if (input[i].compareTo(input[i + 1]) > 0) {
                    swap(input, i, i + 1);
                    sorted = false;
                }
            }

            for (int i = 1; i < input.length - 1; i += 2) {
                if (input[i].compareTo(input[i + 1]) > 0) {
                    swap(input, i, i + 1);
                    sorted = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        R[] input = R.random();
        R.print(input);
        sort(input);
        R.print(input);

    }

}
