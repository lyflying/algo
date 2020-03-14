package com.lyflying.algo.algopractice.algo12quiksort;

public class MergeSort {

    public static void mergeSort(int[] array, int n){
        mergeSortC(array, 0 , n-1);
    }

    private static void mergeSortC(int[] array, int start, int end) {
        if(start >= end) return;
        int mid = (start + end)/2;
        mergeSortC(array, start, mid);
        mergeSortC(array, mid+1, end);
        // todo:数组合起来
    }

}
