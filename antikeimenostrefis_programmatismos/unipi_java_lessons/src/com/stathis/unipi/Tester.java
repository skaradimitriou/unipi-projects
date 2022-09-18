package com.stathis.unipi;

import com.stathis.unipi.model.A;
import com.stathis.unipi.model.B;
import com.stathis.unipi.model.C;

import java.util.ArrayList;

public class Tester {

    public static void main(String[] args) {

        //Instantiation of classes A,B,C
        A firstItem = new A ("Name", "s1", 1);
        A secondItem = new A ("Othername", "s2", 2);

        // list of strings
        String[] myStringList = { "One","Two","Three"};

        B thirdItem = new B(111111111,myStringList,"s3",3,true);
        B fourthItem = new B(222222222,myStringList,"s4",4,false);

        // Instantiation of an array list
        ArrayList<IMyInterface> myList = new ArrayList<>();

        C fifthItem = new C (myList);

        //add A & B items to C's list.
        fifthItem.addToList(firstItem);
        fifthItem.addToList(secondItem);
        fifthItem.addToList(thirdItem);
        fifthItem.addToList(fourthItem);

        // count how many items exist in C's list
        System.out.println("H C list exei" + " " + fifthItem.countListItems() + " " + "items");

        //prints all items in the list
        fifthItem.printAllItems();
    }
}
