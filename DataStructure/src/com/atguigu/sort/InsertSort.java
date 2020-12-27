package com.atguigu.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 4, 2, 0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 插入排序的基本思想是：
     * 把n个待排序的元素看成为一个有序表和一个无序表，
     * 开始时有序表中只包含一个元素，无序表中包含有n-1个元素，
     * 排序过程中每次从无序表中取出第一个元素，依次与有序表元素比较大小，
     * 将它插入到有序表中的适当位置，组成新的有序表。
     *
     *
     * 假设第一个数为初始序列（有序），从第二个开始，拿每一个数插入到之前的序列。
     * 插入的时候，与之前序列从后往前比较，将所有大于插入者的数往后挪一位，空出要插入的数应该在的位置，然后插入即可。
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // i为无序序列的第一个  从1开始，因为初始有序序列只有一个值 arr[0]
            int insert = arr[i];   //本次要插入的值
            int j = i - 1;  // j为有序序列的最后一个

            while (j >= 0 && arr[j] > insert) {  //j=0是与有序序列的第一个比较 也是最后一次比较
                arr[j + 1] = arr[j];  //后挪一位
                j--;
            }
            arr[j + 1] = insert;  //while循环每次都会j--, 所以这里是arr[j+1] 插入上一轮空出的 arr[j]的位置
        }
    }
}
