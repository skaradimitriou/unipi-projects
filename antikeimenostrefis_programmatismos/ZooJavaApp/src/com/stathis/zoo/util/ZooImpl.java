package com.stathis.zoo.util;

import com.stathis.zoo.abstraction.IZoo;
import com.stathis.zoo.models.Animal;

import java.io.*;
import java.util.ArrayList;

/**
 * This class implements the methods from IZoo interface
 * and contains all the needed logic to perform those actions.
 */

public class ZooImpl implements IZoo {

    ArrayList<Animal> zooList = new ArrayList<>();

    @Override
    public void displayZooAnimals() {
        if (zooList.isEmpty()) {
            System.out.println("There are no animals in the Zoo");
            System.out.println("");
        } else {
            if(zooList.size() != 1){
                System.out.println("There are" + " " + zooList.size() + " " + "animals in total in the zoo at the moment.");
            } else {
                System.out.println("There is only" + " " + zooList.size() + " " + "animal in the zoo at the moment.");
            }
            System.out.println("");

            for (int i = 0; i < zooList.size(); i++) {
                System.out.println("Animal No. " + (i + 1) + " " + zooList.get(i).toString());
            }
        }
    }

    /**
     * @param animal
     * adds an animal to the zooList
     */

    @Override
    public void addAnimalToZoo(Animal animal) {
        if (existsInArray(animal)) {
            System.out.println(animal.getName() + " " + "already exists in the zoo!");
        } else {
            zooList.add(animal);
            System.out.println(animal.getName() + " " + "added to the zoo!");
        }
    }

    /**
     * @param name
     * prints animals with name equals to name passed as param.
     */

    @Override
    public void searchAnimalByName(String name) {
        zooList.forEach(animal -> {
            if (animal.getName().equals(name)) System.out.println(animal);
        });
    }

    @Override
    public void searchAnimalByCode(String code) {
        zooList.forEach(animal -> {
            if (animal.getCode().equals(code)) System.out.println(animal);
        });
    }

    @Override
    public void deleteAnimalByCode(String code) {
        zooList.forEach(animal -> {
            if(animal.getCode().equals(code)){
                System.out.println(animal.getName() + " was successfuly removed from the zoo.");
            }
        });
    }

    @Override
    public void getAnimalsByCategory(String category) {
        if (categoryExistsInArray(category)) {
            int results = countResultsForCategory(category);
            if(results != 1){
                System.out.println(results + " " + "results found for" + " " + category);
            } else {
                System.out.println(results + " " + "result found for" + " " + category);
            }

            zooList.forEach(animal -> {
                if (animal.getCategory().equals(category)) System.out.println(animal);
            });
        } else {
            System.out.println("No results found for query: " + category + "animals");
        }
    }

    @Override
    public void feedAnimal(String animalName) {
        zooList.forEach(animal -> {
            if(animal.getName().equals(animalName)) animal.feedAnimal(animal);
        });
    }

    @Override
    public void saveZooDataToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("zooList");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(zooList);
            oos.close();
            fos.close();
            System.out.println("Your changes have been saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving the animals from the app to file");
        }
    }

    @Override
    public void loadZooDataFromFile() {
        try {
            FileInputStream fis = new FileInputStream("zooList");
            ObjectInputStream ois = new ObjectInputStream(fis);

            zooList = (ArrayList<Animal>) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Error reading zoo animal data from file");
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found in the app");
            c.printStackTrace();
        }
    }

    /**
     * @param animal
     *  returns if the animal exists already in zooList.
     */

    private boolean existsInArray(Animal animal) {
        return zooList.stream().anyMatch(a -> a.equalsContent(animal));
    }

    /**
     * @param category
     * returns if the category exists in zooList.
     */

    private boolean categoryExistsInArray(String category) {
        return zooList.stream().anyMatch(o -> o.getCategory().equals(category));
    }

    /**
     * @param category
     * returns how many items match the category passed as param.
     */

    private int countResultsForCategory(String category) {
        return zooList.stream().filter(a -> a.getCategory().equals(category)).toList().size();
    }
}
