package com.stathis.zoo.models;

import com.stathis.zoo.abstraction.ICanFeed;

public class Fish extends Animal {

    private boolean isEctothermic;

    public Fish(String code, String name, String category, Double averageWeight, int maxAge, boolean isEctothermic) {
        super(code, name, category, averageWeight, maxAge);
        this.isEctothermic = isEctothermic;
    }

    public boolean isEctothermic() {
        return isEctothermic;
    }

    public void setEctothermic(boolean ectothermic) {
        isEctothermic = ectothermic;
    }

    @Override
    public void feedAnimal(ICanFeed canBeFed) {
        System.out.println("You just fed a fish => " + getName() + " says thank you!");
    }
}
