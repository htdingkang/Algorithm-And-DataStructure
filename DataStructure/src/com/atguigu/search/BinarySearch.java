package com.atguigu.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 100, 234, 1000, 1000, 1000, 1000, 1000, 1234};

        int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println("resIndex=" + resIndex);

        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println("resIndexList=" + resIndexList);
    }

    /**
     * 返回下标
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] > findVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        }
        if (arr[mid] < findVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        }

        return mid;
    }


    /**
     * 返回所有符合条件的下标集合
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        //所有满足条件的数组下标集合
        List<Integer> resultInedxList = new ArrayList<>();

        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return resultInedxList;
        }
        int mid = (left + right) / 2;
        if (arr[mid] > findVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        }
        if (arr[mid] < findVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        }

        int temp = mid - 1;
        while (temp >= 0 && arr[temp] == arr[mid]) {
            resultInedxList.add(0, temp);  //倒插，保证返回的下标从小到大有序
            temp--;
        }

        resultInedxList.add(mid);

        temp = mid + 1;
        while (temp <= arr.length && arr[temp] == arr[mid]) {
            resultInedxList.add(temp);
            temp++;
        }
        return resultInedxList;
    }
}
