package com.stathis.zoo.models;

import com.stathis.zoo.abstraction.ICanFeed;

public class Amphibian extends Animal {

    private boolean isColdBlooded;

    public Amphibian(String code, String name, String category, Double averageWeight, int maxAge, boolean isColdBlooded) {
        super(code, name, category, averageWeight, maxAge);
        this.isColdBlooded = isColdBlooded;
    }

    private boolean getIsColdBlooded(){
        return isColdBlooded;
    }

    private void setIsColdBlooded(boolean isColdBlooded){
        this.isColdBlooded = isColdBlooded;
    }

    @Override
    public void feedAnimal(ICanFeed canBeFed) {
        if(canBeFed instanceof Amphibian){
            System.out.println("You just fed an amphibian => " + getName() + " says thank you!");
        }
    }
}
