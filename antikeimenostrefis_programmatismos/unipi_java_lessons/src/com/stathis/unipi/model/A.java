package com.stathis.unipi.model;

import com.stathis.unipi.IMyInterface;

public class A extends Parent implements IMyInterface {

    private String myName;

    //constructor for A class
    public A(String myName, String s1, int i2, boolean b3) {
        super(s1, i2, b3);
        this.myName = myName;
    }

    //secondary constructor for A class
    public A(String myName, String s1, int i2) {
        super(s1, i2);
        this.myName = myName;
    }

    //getters -  setters
    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    @Override
    public String toString() {
        return "A{" +
                "myName='" + myName + '\'' +
                '}';
    }

    @Override
    public String doSomething(int a) {
        return "Hello from ChildA Class";
    }
}
