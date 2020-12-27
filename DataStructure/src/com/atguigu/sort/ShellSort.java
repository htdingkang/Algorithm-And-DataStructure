package com.atguigu.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序。
     * <p>
     * 传统插入排序存在的问题是：当很后面的数字很小时，一次插入，要while循环移动很多次。
     * <p>
     * 希尔排序法基本思想：
     * 1.希尔排序是把待排序数组按下标的一定增量分组，对每组使用直接插入排序算法排序；
     * 2.随着增量逐渐减少，每组包含的数字越来越多，当增量减至1时，整个数组恰被分成一组，算法便终止。
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        // 增量gap, 并逐步的缩小增量，gap=1是最后一次。
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i - gap;
                int insert = arr[i];
                while (j >= 0 && insert < arr[j]) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = insert;
            }
        }
    }
}
