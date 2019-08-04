package com.lyflying.algopractice.algo06linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

public class LRULinkedList {

    public static void LRU(LinkedList<Integer> list, int maxSize, int a){
        if(list.contains(a)){
            list.remove((Integer) a);
            list.add(0,a);
            return;
        }
        if(list.size() >= maxSize){
            list.removeLast();
        }
        list.add(0,a);
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        LRU(list, 5,3);
        //LRU(list, 5,6);
        //LRU(list, 5,6);
        System.out.println(list);
    }

}
