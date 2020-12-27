package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {

//        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561, 9, 70};
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));

        //测试一下快速排序的速度, 给80000个数据，测试
        //创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        quickSort(arr, 0, arr.length-1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    /**
     * 快速排序（Quicksort）是对冒泡排序的一种改进。
     * 基本思想是：
     * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小。
     * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int arr[], int left, int right) {
        int l = left, r = right;
        int temp;  //临时变量 用于交换
        int pivot;  //中轴值
        pivot = arr[(left + right) / 2];
        while (l < r) {
            //在pivot的左边往后一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l++;
            }
            //在pivot的右边往前一直找,找到小于等于pivot值,才退出
            while (pivot < arr[r]) {
                r--;
            }
            //此时 如果l < r 则互换
            if (l < r) {
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;   //已经换过了，往后一位
                r--;   //已经换过了，往前一位
            }
        }
        // 如果 l == r, 必须l++, r--, 否则会出现栈溢出
        // 一前一后，正好为pivot值所在下标让位
        if (l == r) {
            l++;
            r--;
        }

        //以上确保了左边的都比pivot小，右边的都比pivot大，但不能保证左侧右侧分别有序

        //左递归，同样的方法处理比pivot值小的部分
        if (left < r) {
            quickSort(arr, left, r);
        }
        //右递归 同样的方法处理比pivot值大的部分
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
