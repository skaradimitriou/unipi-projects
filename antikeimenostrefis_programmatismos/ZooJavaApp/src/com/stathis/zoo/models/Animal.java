package com.stathis.zoo.models;

import com.stathis.zoo.abstraction.ICanFeed;
import com.stathis.zoo.abstraction.IUnique;

import java.io.Serializable;

public class Animal implements IUnique, ICanFeed, Serializable {

    private String code;
    private String name;
    private String category;
    private Double averageWeight;
    private int maxAge;

    public Animal(String code, String name, String category, Double averageWeight, int maxAge) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.averageWeight = averageWeight;
        this.maxAge = maxAge;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight(Double averageWeight) {
        this.averageWeight = averageWeight;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    @Override
    public String toString() {

        return "Name: " + name + " | Code: " + code +
                " | Category: " + category + " | Average Weight: " +
                averageWeight + " | Max Living age: " + maxAge;
    }

    /**
     * @param model
     * @return true/false whether the model equals the given properties with another model
     */

    @Override
    public boolean equalsContent(IUnique model) {
        if (model instanceof Animal) {
            return this.name.equals(((Animal) model).getName()) &&
                    this.code.equals(((Animal) model).getCode()) &&
                    this.category.equals(((Animal) model).getCategory()) &&
                    this.maxAge == ((Animal) model).getMaxAge();
        } else {
            return false;
        }
    }

    @Override
    public void feedAnimal(ICanFeed canBeFed) {
        if(canBeFed instanceof Amphibian){
            System.out.println("You just fed an amphibian => " + getName() + " says thank you!");
        } else if(canBeFed instanceof Fish){
            System.out.println("You just fed a fish => " + getName() + " says thank you!");
        } else if(canBeFed instanceof Mammal){
            System.out.println("You just fed a mammal => " + getName() + " says thank you!");
        } else {
            System.out.println("You just fed an reptile => " + getName() + " says thank you!");
        }
    }
}
