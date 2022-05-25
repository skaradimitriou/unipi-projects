package com.stathis.zoo.abstraction;

import com.stathis.zoo.models.Animal;

/**
 * Zoo has the following properties in the app
 */

public interface IZoo {
    void displayZooAnimals();
    void addAnimalToZoo(Animal animal);
    void searchAnimalByName(String name);
    void searchAnimalByCode(String code);
    void deleteAnimalByCode(String code);
    void getAnimalsByCategory(String category);
    void feedAnimal(String animalName);
    void saveZooDataToFile();
    void loadZooDataFromFile();
}
