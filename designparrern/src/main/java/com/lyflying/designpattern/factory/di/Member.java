package com.lyflying.designpattern.factory.di;

public class Member {

    private User user;

    public Member(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void test() {
        System.out.println(user);
    }
}
