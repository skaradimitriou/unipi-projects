package com.stathis.zoo.abstraction;

/**
 * Interface used in order to check if a given object equals another content based
 * on the fields that will be passed as parameters.
 */

public interface IUnique {
    boolean equalsContent(IUnique model);
}
