package com.stathis.zoo.util;

import com.stathis.zoo.abstraction.IAddAnimalUI;
import com.stathis.zoo.abstraction.IZooUI;
import com.stathis.zoo.models.*;

import java.util.Scanner;

/**
 * UI class is responsible to handle the app menu and choices.
 */

public class UI implements IZooUI, IAddAnimalUI {

    private final Scanner scanner = new Scanner(System.in);

    public void showHeaderInfo() {
        System.out.println("");
        System.out.println("Welcome to first Java Assignment!");
        System.out.println("Topic: Zoo Management System");
        System.out.println("Student: Stathis Karadimitriou, MPPL21024");
    }

    public void showInstructions() {
        System.out.println("-------");
        System.out.println("Select one of the following operations by typing 1-8");
        System.out.println("-------");
        System.out.println("1. Display all animals in the app");
        System.out.println("2. Add a new animal in the app");
        System.out.println("3. Search an animal by name");
        System.out.println("4. Search an animal by code");
        System.out.println("5. Delete an animal by code");
        System.out.println("6. Get all animals by category");
        System.out.println("7. Feed an animal");
        System.out.println("8. Exit the app");
    }

    public void loadDataFromFile(ZooImpl zoo) {
        zoo.loadZooDataFromFile();
    }

    private Choices initUserChoices() {
        showInstructions();

        int choice;
        try {
            choice = scanner.nextInt();

            return switch (choice) {
                case 1 -> Choices.DISPLAY_ALL_ANIMALS;
                case 2 -> Choices.ADD_NEW_ANIMAL;
                case 3 -> Choices.SEARCH_ANIMAL_BY_NAME;
                case 4 -> Choices.SEARCH_ANIMAL_BY_CODE;
                case 5 -> Choices.DELETE_ANIMAL_BY_CODE;
                case 6 -> Choices.GET_ANIMALS_BY_CATEGORY;
                case 7 -> Choices.FEED_ANIMAL;
                case 8 -> Choices.EXIT;
                default -> Choices.ERROR;
            };
        } catch (Exception e) {
            return Choices.ERROR;
        }
    }

    /**
     * @param zoo
     * performAction: handles the user input from the given options above
     * and performs the nessessary action.
     */

    @Override
    public void performAction(ZooImpl zoo) {
        Choices choice;
        do {
            choice = initUserChoices();
            switch (choice) {
                case DISPLAY_ALL_ANIMALS -> zoo.displayZooAnimals();
                case ADD_NEW_ANIMAL -> {
                    showAddAnimalInstructions();
                    int userChoice = getUserChoice();
                    handleUserInput(zoo, userChoice);
                }
                case SEARCH_ANIMAL_BY_NAME -> {
                    System.out.println("Give an animal name:");
                    String name = askUserForInput();
                    zoo.searchAnimalByName(name);
                }
                case SEARCH_ANIMAL_BY_CODE -> {
                    System.out.println("Give an animal code:");
                    String code = askUserForInput();
                    zoo.searchAnimalByCode(code);
                }
                case DELETE_ANIMAL_BY_CODE -> {
                    System.out.println("Give an animal code:");
                    String code = askUserForInput();
                    zoo.deleteAnimalByCode(code);
                }
                case GET_ANIMALS_BY_CATEGORY -> {
                    System.out.println("Give a category name to get all animals:");
                    System.out.println("App supports: Mammal, Reptile, Fish, Amphibian");
                    String category = askUserForInput();
                    zoo.getAnimalsByCategory(category);
                }
                case FEED_ANIMAL -> {
                    System.out.println("-------");
                    System.out.println("Give the animal's name:");
                    String name = askUserForInput();
                    zoo.feedAnimal(name);
                }
                case EXIT -> {
                    System.out.println("Thank you for using the Zoo App!");
                    zoo.saveZooDataToFile();
                }
                case ERROR -> System.out.println("Unknown command. Please try again!");
            }
        } while (choice != Choices.EXIT);
    }

    private String askUserForInput() {
        Scanner newScanner = new Scanner(System.in);
        return newScanner.nextLine();
    }

    public void showAddAnimalInstructions() {
        System.out.println("-------");
        System.out.println("Select one of the following operations by typing 1-5");
        System.out.println("-------");
        System.out.println("1. Add Amphibian Animal");
        System.out.println("2. Add Fish Animal");
        System.out.println("3. Add Mammal Animal");
        System.out.println("4. Add Reptile Animal");
    }

    private int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void handleUserInput(ZooImpl zoo, int choice) {
        switch (choice) {
            case 1 -> addAmphibian(zoo);
            case 2 -> addFish(zoo);
            case 3 -> addMammal(zoo);
            case 4 -> addReptile(zoo);
        }
    }

    @Override
    public void addAmphibian(ZooImpl zoo) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Give an amphibian code:");
        String code = myScanner.nextLine();

        System.out.println("Give the amphibian name:");
        String name = myScanner.nextLine();

        System.out.println("Give the amphibian's averageWeight (in 0.0 format):");
        double averageWeight = myScanner.nextDouble();

        System.out.println("Give the amphibian's max living age (in years):");
        int maxAge = myScanner.nextInt();

        System.out.println("Is this amphibian cold blooded? (true - false)");
        boolean coldBlooded = myScanner.nextBoolean();

        Amphibian amphibian = new Amphibian(code,name,"Amphibian",averageWeight,maxAge,coldBlooded);
        zoo.addAnimalToZoo(amphibian);
    }

    @Override
    public void addFish(ZooImpl zoo) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Give an fish code:");
        String code = myScanner.nextLine();

        System.out.println("Give the fish name:");
        String name = myScanner.nextLine();

        System.out.println("Give the fish averageWeight (in 0.0 format):");
        double averageWeight = myScanner.nextDouble();

        System.out.println("Give the fish max living age (in years):");
        int maxAge = myScanner.nextInt();

        System.out.println("Is this fish ectothermic? (true - false)");
        boolean isEctothermic = myScanner.nextBoolean();

        Fish fish = new Fish(code,name,"Fish",averageWeight,maxAge,isEctothermic);
        zoo.addAnimalToZoo(fish);
    }

    @Override
    public void addMammal(ZooImpl zoo) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Give a mammal code:");
        String code = myScanner.nextLine();

        System.out.println("Give the mammal name:");
        String name = myScanner.nextLine();

        System.out.println("Give the mammal averageWeight (in 0.0 format):");
        double averageWeight = myScanner.nextDouble();

        System.out.println("Give the mammal max living age (in years):");
        int maxAge = myScanner.nextInt();

        System.out.println("Does this mammal has fur? (true - false)");
        boolean hasFur = myScanner.nextBoolean();

        System.out.println("Does this mammal eat meat? (true - false)");
        boolean eatsMeet = myScanner.nextBoolean();

        Mammal mammal = new Mammal(code,name,"Mammal",averageWeight,maxAge,hasFur,eatsMeet);
        zoo.addAnimalToZoo(mammal);
    }

    @Override
    public void addReptile(ZooImpl zoo) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Give a reptile code:");
        String code = myScanner.nextLine();

        System.out.println("Give the reptile name:");
        String name = myScanner.nextLine();

        System.out.println("Give the reptile averageWeight (in 0.0 format):");
        double averageWeight = myScanner.nextDouble();

        System.out.println("Give the reptile max living age (in years):");
        int maxAge = myScanner.nextInt();

        System.out.println("How many meters long is this reptile?");
        double metersLong = myScanner.nextDouble();

        System.out.println("How many legs does this reptile has?");
        int legsCount = myScanner.nextInt();

        Reptile reptile = new Reptile(code,name,"Reptile",averageWeight,maxAge,metersLong,legsCount);
        zoo.addAnimalToZoo(reptile);
    }
}