package com.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {9,4,6,8,3,10,10,6,9};
        quickSort(nums, 0, nums.length - 1);

        for (int num : nums
        ) {
            System.out.println(num);
        }
    }


    //https://leetcode.cn/circle/discuss/kiHnKs/
    //分治思想，对划分的两部分分别快速排序
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high); // 划分数组
            quickSort(arr, low, pivot - 1);//递归调用左半数组
            quickSort(arr, pivot + 1, high);//递归调用右半数组
        }
    }

    //设置选取的划分值，并将数据分为两部分
    private static int partition(int[] arr, int low, int high) {
        // 选择每次数组的第一个作为基准,即 arr[low] 作为基准
        int pivot = arr[low];

        int i = low, j = high;
        while (i < j) {
            // 这里一定是右边开始，上下这两个循环不能调换,
            // 因为基准数设置为左边，那么就必须从右边开始
            while (i < j && arr[j] >= pivot) j--; // 从右往左找比基准数小的
            while (i < j && arr[i] <= pivot) i++; // 从左往右找比基准数大的

            swap(arr, i, j); // 交换
        }

        // 循环完毕后，需要将 pivot位置上的元素交换到指定位置
        // 退出循环条件时，正好是 i == j ，此时 基准的位置就是 i 或者 j
        swap(arr, i, low);

        return i;
    }

    // 对数组中下标为 i， j 的两个元素进行交换
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
