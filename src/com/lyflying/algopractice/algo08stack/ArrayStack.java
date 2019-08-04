package com.lyflying.algopractice.algo08stack;

public class ArrayStack implements BaseStack {

    private String[] data;
    private int count;
    private int n;

    public ArrayStack(int capacity) {
        this.data = new String[capacity];
        this.count = 0;
        this.n = capacity;
    }

    public void push(String item){
        if(count == n){
            resize();
        }
        data[count] = item;
        count++;
    }

    private void resize() {
        int newSize = n*2;
        String[] newData = new String[newSize];
        System.arraycopy(this.data, 0, newData,0,n);
        this.n = newSize;
        this.data = newData;
    }

    public String pop(){
        if(count == 0) return null;
        String item = data[count-1];
        count--;
        return item;
    }

    public void printAll(){
        for(int i = 0; i < count; i++){
            System.out.print(data[i]+" ");
        }
        System.out.println("\r");
    }

    public String peek(){
        if(count == 0){
            return null;
        }
        return data[count-1];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(2);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.printAll();
        System.out.println(stack.pop());
        stack.printAll();
    }

}
