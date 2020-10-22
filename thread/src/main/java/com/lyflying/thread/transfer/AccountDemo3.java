package com.lyflying.thread.transfer;

import java.util.concurrent.TimeUnit;

/**
 * @author: LY
 * @email: liuyang10@baijiahulian.com
 * @time: 2020/10/21 2:28 下午
 * @description:
 */
public class AccountDemo3 {

    private String name;
    private Integer balance;

    public AccountDemo3(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "姓名："  + name + "；余额：" + balance;
    }

    void transfer(AccountDemo3 target, int amt) {
        synchronized (AccountDemo3.class){
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

    public static void main(String[] args) throws InterruptedException {
        AccountDemo3 zhangsan = new AccountDemo3("张三",200);
        AccountDemo3 lisi = new AccountDemo3("李四", 200);
        AccountDemo3 wangwu = new AccountDemo3("王五", 200);

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
