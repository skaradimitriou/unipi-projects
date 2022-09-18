package com.stathis.unipi.model;

import com.stathis.unipi.IMyInterface;

import java.util.ArrayList;

public class C {
    private ArrayList<IMyInterface> list;

    //constructor for C class
    public C(ArrayList<IMyInterface> list) {
        this.list = list;
    }

    //getters -  setters
    public ArrayList<IMyInterface> getList() {
        return list;
    }

    public void setList(ArrayList<IMyInterface> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "C{" +
                "list=" + list +
                '}';
    }

    /**
     * Adds an item that implements IMyInterface to the list
     */
    public void addToList(IMyInterface object) {
        this.list.add(object);
    }

    /**
     * Counts how many items are in the list
     */

    public int countListItems() {
        if (this.list.isEmpty()) {
            return 0;
        } else {
            return this.list.size();
        }
    }

    /**
     * Prints all items that exist in the list
     */

    public void printAllItems() {
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println(this.list.get(i).toString());
        }
    }
}