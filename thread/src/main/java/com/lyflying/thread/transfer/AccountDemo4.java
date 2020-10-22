package com.lyflying.thread.transfer;

import java.util.concurrent.TimeUnit;

public class AccountDemo4 {

    private String name;
    private int balance;

    public AccountDemo4(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    /**
     * todo ： 思考有什么问题？
     * @param target
     * @param amt
     */
    void transfer(AccountDemo4 target, int amt){
        // 锁定转出账户
        AccountDemo4 first = target.name.compareTo(this.name) <= 0 ? target : this;
        AccountDemo4 second = target.name.compareTo(this.name) > 0 ? target : this;
        synchronized(first) {
            System.out.println("获取锁"+this.toString());
            // 锁定转入账户
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(second) {
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
    }

    @Override
    public String toString() {
        return "姓名："  + name + "；余额：" + balance;
    }

    public static void main(String[] args) throws InterruptedException {
        AccountDemo4 zhangsan = new AccountDemo4("张三",200);
        AccountDemo4 lisi = new AccountDemo4("李四", 200);
        AccountDemo4 wangwu = new AccountDemo4("王五", 200);

        Thread t1 = new Thread(() -> zhangsan.transfer(lisi, 100));
        Thread t2 = new Thread(() -> lisi.transfer(zhangsan, 100));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(zhangsan);
        System.out.println(lisi);
        System.out.println(wangwu);
    }


}
