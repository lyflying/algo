package com.lyflying.algo.algopractice.algo12quiksort;

public class QuikSortTest {

    public static void quikSort(int[] a, int p, int q){
        if(p >= q) return;
        int pi = partition(a, p , q);
        for(int i : a){
            System.out.print(i+" ");
        }
        System.out.println();
        quikSort(a, p, pi-1);
        quikSort(a, pi+1, q);
    }

    private static int partition(int[] a, int p, int q) {
        int val = a[q];
        for(int j = p; j < q ; j++){
            if(a[j] > val ){
                swap(a, p, j);
                p++;
            }
        }
        swap(a, p, q);
        return p;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,8,6,7,2,9,1,4,2};
        quikSort(a,0,a.length-1);
        for(int i : a){
            System.out.print(i+" ");
        }
    }

}
