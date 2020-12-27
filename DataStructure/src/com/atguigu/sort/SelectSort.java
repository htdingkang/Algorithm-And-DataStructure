package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class SelectSort {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 3, 4, 2, 0};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 选择排序的思想：
     * 1.所有的数中选择最小的一个与第一个交换，保证第一个最小。
     * 2.第二个开始的n-1个数中选择最小的与第二个交换。保证第二个相对最小。
     * 3.依次类推，第i次选择的是剩下的n-i个数中最小的，放在第i小的位置上。这样就确保了从小到大的排序。
     * @param arr
     */
    public static void selectSort(int[] arr) {

        int minIndex = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            //无序区的最小数据数组下标，默认第一个
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //在无序区中找到最小数据并保存其数组下标，从第一个的下一个开始与第一个比
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //将最小元素放到本次循环的前端
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

}
