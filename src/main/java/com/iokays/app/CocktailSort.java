package com.iokays.app;

/**
 * Created by andy on 14-1-19.
 */
public class CocktailSort {
    private static void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <E extends Comparable<? super E> > void sort(E[] input) {
        int bottom = 0;                 //初始化比较范围上限[左边]
        int top = input.length - 1;     //初始化比较范围下限[右边]

        boolean exchange = true;        //初始化假定已数据交换.

        while (exchange) {
            exchange = false;           //设置本次比较尚未发生数据交换.

            for (int i = bottom; top > i; ++i) {
                if (0 < input[i].compareTo(input[i + 1])) {     //较大值上浮
                    swap(input, i, i + 1);
                    exchange = true;
                }
            }
            --top;

            for (int j = top; bottom < j; --j) {
                if (0 < input[j - 1].compareTo(input[j])) {    //较小值下降
                    swap(input, j - 1, j);
                    exchange = true;
                }

            }
            ++bottom;
        }
    }

    public static void main(String[] args) {
        R[] input = R.random();
        R.print(input);
        sort(input);
        R.print(input);

    }
}

