package com.stathis.zoo.models;

import com.stathis.zoo.abstraction.ICanFeed;

public class Reptile extends Animal {

    private double metersLong;
    private int legsCount;

    public Reptile(String code, String name, String category, Double averageWeight, int maxAge, double metersLong, int legsCount) {
        super(code, name, category, averageWeight, maxAge);
        this.metersLong = metersLong;
        this.legsCount = legsCount;
    }

    public double getMetersLong() {
        return metersLong;
    }

    public void setMetersLong(double metersLong) {
        this.metersLong = metersLong;
    }

    public int getLegsCount() {
        return legsCount;
    }

    public void setLegsCount(int legsCount) {
        this.legsCount = legsCount;
    }

    @Override
    public void feedAnimal(ICanFeed canBeFed) {
        System.out.println("You just fed a reptile => " + getName() + " says thank you!");
    }
}
