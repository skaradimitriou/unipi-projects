package com.stathis.zoo.abstraction;

import com.stathis.zoo.util.ZooImpl;

/**
 * The user will choose one of the following actions before trying to feed an animal
 */

public interface IAddAnimalUI {
    void addAmphibian(ZooImpl zoo);
    void addFish(ZooImpl zoo);
    void addMammal(ZooImpl zoo);
    void addReptile(ZooImpl zoo);
}
