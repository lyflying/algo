package com.lyflying.algopractice.algo06linkedlist;

import java.util.LinkedList;

public class HuiWenCheck {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(checkHuiwen(list));
    }

    private static boolean checkHuiwen(LinkedList<Integer> list) {
        if(list.isEmpty() || list.size() == 1) return true;
        return false;
    }

}
