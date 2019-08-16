package com.lyflying.algopractice.algo12quiksort;

public class FindTopK {

    public static int quikSort(int[] a, int p, int q, int k){
        int pi = partition(a, p , q);
        if(k == pi){
            return a[k];
        }
        if(k > pi){
            return quikSort(a, pi+1, q, k);
        }else{
            return quikSort(a, p, pi-1, k);
        }
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
        int top = 2;
        System.out.println(quikSort(a,0,a.length-1, top-1));
    }

}
