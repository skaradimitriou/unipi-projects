package com.stathis.zoo.abstraction;

/**
 * feed animal triggers the feeding mechanism
 */

public interface ICanFeed {
    void feedAnimal(ICanFeed canBeFed);
}
