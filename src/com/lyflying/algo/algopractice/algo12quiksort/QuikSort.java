package com.lyflying.algo.algopractice.algo12quiksort;

public class QuikSort {

    public static void quikSort(int[] array, int start, int end){
        if(start >= end) return;
        int mid = partition(array, start, end);
        quikSort(array, start, mid-1);
        quikSort(array, mid+1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pirot = array[end];
        int i = start;
        for(int j = start; j < end; j ++){
            if(array[j] < pirot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, end);
        for(int a : array){
            System.out.print(a+" ");
        }
        System.out.println();
        return i;
    }

    private static void swap(int[] array, int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{6,11,3,9,8};
        int length = array.length;
        quikSort(array,0, length-1);
        for(int a : array){
            System.out.print(a+" ");
        }
    }

}
