package com.stathis.unipi.model;

import com.stathis.unipi.IMyInterface;

public class Parent implements IMyInterface {

    private String s1;
    private int i2;
    private boolean b3;

    //constructor for Parent class
    public Parent(String s1, int i2, boolean b3) {
        this.s1 = s1;
        this.i2 = i2;
        this.b3 = b3;
    }

    //secondary constructor for Parent class
    public Parent(String s1, int i2) {
        this.s1 = s1;
        this.i2 = i2;
    }

    //getters -  setters

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public int getI2() {
        return i2;
    }

    public void setI2(int i2) {
        this.i2 = i2;
    }

    public boolean isB3() {
        return b3;
    }

    public void setB3(boolean b3) {
        this.b3 = b3;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "s1='" + s1 + '\'' +
                ", i2=" + i2 +
                ", b3=" + b3 +
                '}';
    }

    @Override
    public String doSomething(int a) {
        return "Hello from Parent Class";
    }
}
