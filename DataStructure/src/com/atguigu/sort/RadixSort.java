package com.atguigu.sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println("基数排序后 " + Arrays.toString(arr));
    }

    //基数排序
    public static void radixSort(int[] arr) {

        //1. 得到数组中最大的数的位数
        int max = arr[0]; //假设第一数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();


        //定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //3. 基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //比如：bucketElementCountArray[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCountArray = new int[10];


        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //(针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for (int j = 0; j < arr.length; j++) {
                //获取每个元素的对应位（个位，十位，百位。。。）的值， 即 桶下标值
                int bucketIndex = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[bucketIndex][bucketElementCountArray[bucketIndex]] = arr[j];
                bucketElementCountArray[bucketIndex]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组
            for (int k = 0; k < bucketElementCountArray.length; k++) {
                //如果桶中，有数据，我们才放入到原数组
                if (bucketElementCountArray[k] != 0) {
                    //循环该桶即第k个桶(即第k个一维数组), 放入
                    for (int l = 0; l < bucketElementCountArray[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //每轮处理后，需要将每个桶中元素个数置空 bucketElementCountArray[k] = 0 ！！！！
                bucketElementCountArray[k] = 0;
            }
        }
    }
}
