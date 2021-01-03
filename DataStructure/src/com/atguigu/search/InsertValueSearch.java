package com.atguigu.search;


/**
 * 插值查找
 */
public class InsertValueSearch {

    public static void main(String[] args) {
		int [] arr = new int[100];
		for(int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
        int index = insertValueSearch(arr, 0, arr.length - 1, 77);
        System.out.println("resIndex = " + index);
    }

    /**
     * 插值查找
     * findVal参与mid值判断的自适应算法
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        System.out.println("插值查找被调用~~");

        // 当 left > right 时，说明递归整个数组，但是没有找到
        // findVal < arr[0] || findVal > arr[arr.length - 1] 是必要的，否则可能会数组越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        if (arr[mid] > findVal) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        }
        if (arr[mid] < findVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        }

        return mid;
    }
}
