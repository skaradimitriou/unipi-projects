package com.stathis.zoo.models;

import com.stathis.zoo.abstraction.ICanFeed;

public class Mammal extends Animal{

    private boolean hasFur;
    private boolean eatsMeat;

    public Mammal(String code, String name, String category, Double averageWeight, int maxAge, boolean hasFur, boolean eatsMeat) {
        super(code, name, category, averageWeight, maxAge);
        this.hasFur = hasFur;
        this.eatsMeat = eatsMeat;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }

    public boolean isEatsMeat() {
        return eatsMeat;
    }

    public void setEatsMeat(boolean eatsMeat) {
        this.eatsMeat = eatsMeat;
    }

    @Override
    public void feedAnimal(ICanFeed canBeFed) {
        System.out.println("You just fed a mammal => " + getName() + " says thank you!");
    }
}
