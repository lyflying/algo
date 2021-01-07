package com.lyflying.thread.transfer;

import java.util.concurrent.TimeUnit;

/**
 * @author: LY
 * @time: 2020/10/21 2:28 下午
 * @description:
 */
public class AccountDemo1 {

    private String name;
    private Integer balance;
    private String password;

    public AccountDemo1(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "姓名："  + name + "；余额：" + balance;
    }

    /**
     * todo：如何保证转账的原子性，加锁后，锁的是什么
     * @param target
     * @param amt
     */
    synchronized void transfer(AccountDemo1 target, int amt) {
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

    public Integer getBalance() {
        return balance;
    }

    /**
     * 张三，李四，王五
     * 张三 -> 李四 100
     * 李四 -> 王五 100
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        AccountDemo1 zhangsan = new AccountDemo1("张三",200);
        AccountDemo1 lisi = new AccountDemo1("李四", 200);
        AccountDemo1 wangwu = new AccountDemo1("王五", 200);

        Thread t1 = new Thread(() -> zhangsan.transfer(lisi, 100));
        Thread t2 = new Thread(() -> zhangsan.transfer(wangwu, 100));

//        Thread t1 = new Thread(() -> zhangsan.transfer(lisi, 100));
//        Thread t2 = new Thread(() -> lisi.transfer(wangwu, 100));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(zhangsan);
        System.out.println(lisi);
        System.out.println(wangwu);
    }

}
