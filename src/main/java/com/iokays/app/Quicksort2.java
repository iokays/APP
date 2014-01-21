package com.iokays.app;

/**
 * Created by andy on 14-1-21.
 */
public class Quicksort2 {

    private static void swap(Object[] array, int i, int j) {        //交换
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static final int CUTOFF = 11;

    private static <E extends Comparable<? super E> > E median (E[]input, int left, int right) {
        int index = (left + right) / 2;                 //选择中间下标为基准值下标

        if (0 < input[left].compareTo(input[index])) {  //left,index,right,两两比较,确定基准值
            swap(input, left, index);
        }
        if (0 < input[left].compareTo(input[right])) {
            swap(input, left, right);
        }
        if (0 < input[index].compareTo(input[right])) {
            swap(input, index, right);
        }

        swap(input, index, right - 1);                  //将基准值放在[right-1]下标,用于原地分区

        return input[right - 1];
    }

    private static <E extends Comparable<? super E> > void qsort(E[]input, int left, int right) {
        if (left + CUTOFF <= right) {
            E pivot = median(input, left, right);       //获取基准值

            int i = left;
            int j = right - 1;
            //循环获取最左边大于基准值的值,和最右边小于基准值的值,两两交换,实现[left, i)小于基准值,(j, right]大于基准值
            while (true) {
                while (0 > input[++i].compareTo(pivot));
                while (0 < input[--j].compareTo(pivot));

                if (j > i) {
                    swap(input, i, j);
                } else {        //j=i,等于基准值, i > j[i位于大于基准值的最左边,j位于小于基准值的最右边,]
                    break;
                }
            }

            swap(input, i, right - 1);      //交换, i的左边小于基准值,i的右边大于基准值.
            qsort(input, left, i - 1);      //子串递归.
            qsort(input, i + 1, right);
        } else {
            insertionSort(input, left, right);
        }
    }


    private static <E extends Comparable<? super E> > void insertionSort(E[] input, int left, int right) {   //插入排序
        for (int i = left; i <= right; ++i) {
            E tmp = input[i];
            int j;
            for (j = i; j > left && 0 > tmp.compareTo(input[j - 1]); --j) {     //j-1下标值大于tmp,将j-1下标值向后移动一格.
                input[j] = input[j - 1];
            }
            input[j] = tmp; //插入
        }
    }

    public static <E extends Comparable<? super E> > void sort(E[]input) {
        qsort(input, 0, input.length - 1);
    }

}
