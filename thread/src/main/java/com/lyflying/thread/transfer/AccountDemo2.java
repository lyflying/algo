package com.lyflying.thread.transfer;

import java.util.concurrent.TimeUnit;

/**
 * @author: LY
 * @time: 2020/10/21 2:28 下午
 * @description:
 */
public class AccountDemo2 {

    private String name;
    private Integer balance;
    private Object lock;


    public AccountDemo2(String name, Integer balance, Object lock) {
        this.name = name;
        this.balance = balance;
        this.lock = lock;
    }

    void transfer(AccountDemo2 target, int amt) {
        synchronized (this.lock){
            if (this.balance >= amt) {
                int balance = this.balance - amt;
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.balance = balance;
                target.balance += amt;
            }
        }
    }

    public Integer getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "姓名："  + name + "；余额：" + balance;
    }

    /**
     * 张三，李四，王五
     * 张三 -> 李四 100
     * 李四 -> 王五 100
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        AccountDemo2 zhangsan = new AccountDemo2("张三",200, new Object());
        AccountDemo2 lisi = new AccountDemo2("李四",200, new Object());
        AccountDemo2 wangwu = new AccountDemo2("王五",200, new Object());

        Thread t1 = new Thread(() -> zhangsan.transfer(lisi, 100));
        Thread t2 = new Thread(() -> lisi.transfer(wangwu, 100));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(zhangsan);
        System.out.println(lisi);
        System.out.println(wangwu);
    }

}
