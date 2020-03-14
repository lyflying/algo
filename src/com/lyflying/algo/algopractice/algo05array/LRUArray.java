package com.lyflying.algo.algopractice.algo05array;

public class LRUArray {

    static int maxSize = 5;

    public static void lru(Array array, int a){
        int index = array.getIndex(a);
        if(index != -1){
            array.delete(index);
            array.add(a);
            return;
        }
        if(array.length() >= maxSize){
            throw new ArrayIndexOutOfBoundsException();
        }
        array.add(a);
    }

    public static void main(String[] args) {
        Array array = new Array(maxSize);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.printAll();
        lru(array, 1);
        array.printAll();
        lru(array, 5);
        array.printAll();
    }

}
