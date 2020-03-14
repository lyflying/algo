package com.lyflying.algo.leetcode;

public class Code0002AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode tail;
        ListNode(int x) {
            val = x;
            tail = this;
            next = null;
        }

        public void print(){
            System.out.println(val);
            ListNode temp = next;
            while (temp != null){
                System.out.println(temp.val);
                temp = temp.next;
            }
        }
    }

    private static ListNode l1;
    private static ListNode l2;

    public static void prepare() {
        l1 = new ListNode(2);
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(3);
        l1.next = l1_1;
        l1_1.next = l1_2;

        l2 = new ListNode(5);
        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(4);
        l2.next = l2_1;
        l2_1.next = l2_2;

    }

    public static void main(String[] args) {
        prepare();
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        int hodler = (l1.val + l2.val) / 10;
        ListNode a = l1.next;
        ListNode b = l2.next;
        while(a != null){
            if(b == null){
                result.next = new ListNode(a.val + hodler);
                hodler = 0;
                return;
            }
            result.next = new ListNode((a.val + b.val) % 10);
            hodler = (a.val + b.val) / 10;
            a = a.next;
            b = b.next;
        }
        while (b != null){
            result.next = new ListNode(b.val + hodler);
            hodler = 0;
        }
        if(hodler != 0){
            result.next = new ListNode(hodler);
        }
        result.print();
    }

}
