package com.stathis.unipi.model;

import com.stathis.unipi.IMyInterface;

import java.util.Arrays;

public class B extends Parent implements IMyInterface {

    private int afm;
    private String[] strings;

    //constructor for B class
    public B(int afm, String[] strings, String s1, int i2, boolean b3) {
        super(s1, i2, b3);
        this.afm = afm;
        this.strings = strings;
    }
    //secondary constructor for B class
    public B(String s1, int i2, boolean b3) {
        super(s1, i2, b3);
    }

    //getters -  setters
    public int getAfm() {
        return afm;
    }

    public void setAfm(int afm) {
        this.afm = afm;
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    @Override
    public String toString() {
        return "B{" +
                "afm=" + afm +
                ", strings=" + Arrays.toString(strings) +
                '}';
    }

    @Override
    public String doSomething(int a) {
        return "Hello from ChildB Class";
    }
}
