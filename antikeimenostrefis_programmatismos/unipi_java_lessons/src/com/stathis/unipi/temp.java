package com.stathis.unipi;

public class temp {
    public static void main(String[] args) {
        //instantiate an array of strings
        String[] dNames = {"Logistics","Marintime", "Economics", "Informatics", "European Studies", "asdasda"};

        //Instantiate a University class and pass dnames in constructor
        University papei = new University(dNames);

        //call static method printUniversityDepartments
        printUniversityDepartments(papei);
    }

    static void printUniversityDepartments(University university){
        //for loop to get all departments from the university class
        for (String department : university.departments){
            //print department (string) in console
            System.out.println(department);
        }

        //that won't work because university is not an array (university.departments is).
        // Look at the next lines for the correct approach
        university[0] = "Informatics";

        //change the value of a specific element by refering to the index number
        university.departments[0] = "Informatics";
    }
}

class University {

    //constructor
    public University(String[] departments) {
        this.departments = departments;
    }

    //property
    String[] departments = new String[5];
}
