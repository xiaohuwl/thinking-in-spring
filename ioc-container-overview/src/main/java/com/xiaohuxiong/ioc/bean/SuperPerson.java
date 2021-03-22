package com.xiaohuxiong.ioc.bean;

import com.xiaohuxiong.ioc.annotation.Super;

@Super
public class SuperPerson extends Person {
    private  String addr;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "addr='" + addr + '\'' +
                "} " + super.toString();

    }
}
