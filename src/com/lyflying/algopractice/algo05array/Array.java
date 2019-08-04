package com.lyflying.algopractice.algo05array;

import javax.sound.midi.Soundbank;

/**
 * 实现数据插入、删除和按照下标随机访问
 */
public class Array {

    private int[] data;
    private int n;
    private int length;

    public Array(int capacity) {
        data = new int[capacity];
        this.n = capacity;
        this.length = 0;
    }

    public int get(int index){
        checkRange(index);
        return data[index];
    }

    public boolean add(int num){
        if(length >= n){
            System.out.println("数组已满");
            return false;
        }
        data[length] = num;
        length++;
        return true;
    }

    public boolean delete(int index){
        checkRange(index);
        for(int i = index + 1; i < length; i++){
            data[i-1] = data[i];
        }
        length--;
        return true;
    }

    public boolean insert(int index, int num){
        checkRange(index);
        if(length >= n){
            System.out.println("数组已满");
            return false;
        }
        for(int i = n-1; i > index; i--){
            data[i] = data[i-1];
        }
        data[index] = num;
        length++;
        return true;
    }

    public int getIndex(int num){
        for(int i = 0; i < length ; i++){
            if(data[i] == num) return i;
        }
        return -1;
    }

    private void checkRange(int index){
        if(index < 0 || index >= length){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int length(){
        return length;
    }

    public void printAll(){
        for(int i = 0; i < length; i++){
            System.out.print(data[i]+" ");
        }
        System.out.println("长度为："+length+"\r");
    }

    public static void main(String[] args) {
        Array array = new Array(10);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.printAll();
        array.delete(3);
        array.printAll();
        array.insert(2,6);
        array.printAll();
    }
}
