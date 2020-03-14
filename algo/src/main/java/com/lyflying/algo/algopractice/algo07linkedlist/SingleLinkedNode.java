package com.lyflying.algo.algopractice.algo07linkedlist;

public class SingleLinkedNode<E> {

    private int length;
    private Node<E> head;
    private Node<E> tail;

    public SingleLinkedNode() {
        this.length = 0;
        this.head = new Node<>(null);
        this.tail = head;
    }

    public void add(E element){
        Node node = new Node(element);
        tail.next = node;
        tail = node;
        this.length++;
    }

    public void remove(E element){
        Node temp = head;
        while (temp != null){
            if(element.equals(temp.next.getItem())){
                temp.next = temp.next.next;
                this.length--;
            }
            temp = temp.next;
        }
    }

    public void print(){
        Node node = head.next;
        while (node != null){
            System.out.print(node.getItem().toString()+",");
            node = node.next;
        }
        System.out.println("\r");
        System.out.println("长度为："+length);
        System.out.println("tail's vlue is："+tail.getItem().toString());
    }

    public void insert(int index, E element) throws Exception {
        if(index < 0 || index > this.length) throw new Exception();
        Node node = head.next;
        for(int i=0; i < length; i++){

        }
    }

    public int length(){
        return this.length;
    }

    public E getFirst(){
        return this.head.next.getItem();
    }

    public E getLast(){
        return this.tail.getItem();
    }

    public class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
            next = null;
        }

        public E getItem() {
            return item;
        }
    }

    public static void main(String[] args) {
        SingleLinkedNode<Integer> list = new SingleLinkedNode();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        list.remove(5);
        list.print();
    }

}
