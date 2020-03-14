package com.lyflying.algo.algopractice.algo08stack;

import com.lyflying.algo.algopractice.algo07linkedlist.SingleLinkedNode;

public class LinkedStack implements BaseStack {

    private SingleLinkedNode<String> list;
    private int count;

    public LinkedStack() {
        this.list = new SingleLinkedNode<String>();
        this.count = 0;
    }

    @Override
    public String pop() {
        return null;
    }

    @Override
    public void push(String item) {
        list.add(item);
        count++;
    }

    @Override
    public String peek() {
        return list.getLast();
    }
}
