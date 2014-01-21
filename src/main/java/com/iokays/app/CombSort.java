package com.iokays.app;

/**
 * Created by andy on 14-1-19.
 */
public class CombSort {
    private static void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <E extends Comparable<? super E> > void sort(E[] input) {

        boolean sorted = false;         //假定数组尚未排好序.
        double shrink_factor = 1.247330950103979;
        int gap = input.length;                 //设定开始时的间距设定为数组长度

        while (1 < gap || !sorted) {
            sorted = true;
            if (gap > 1) {
                gap = (int)(gap / shrink_factor);
            }

            for (int i = 0; input.length > i + gap; ++i) {
                if (0 < input[i].compareTo(input[i + gap])) {
                    swap(input, i, i + gap);
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
