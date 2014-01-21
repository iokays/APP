package com.iokays.app;

import java.util.ArrayList;

/**
 * Created by andy on 14-1-14.
 */
public class BubbleSort {

    private static void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <E extends Comparable<? super E>> void sort(E[] input) {
        int exchange = input.length - 1;        //初始化交换位置(左节点)为数组的最后一个节点
        while (0 != exchange) {
            final int bound = exchange;         //循环条件的右(最大)边界
            exchange = 0;                       //假定没有发生交换
            for (int i = 0; bound > i; ++i) {
                if (0 < input[i].compareTo(input[i + 1])) {
                    swap(input, i, i + 1);
                    exchange = i;               //记下数据交换的位置
                }
            }
        }
    }
}
