package edu.gb.model.animalsRegistry;

import edu.gb.model.animals.Animal;
import edu.gb.model.animals.packs.Pack;
import edu.gb.model.animals.pets.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnimalRegistry implements AnimalDB {
    private List<Pet> petsList;
    private List<Pack> packsList;

    public AnimalRegistry() {
        this.petsList = new ArrayList<>();
        this.packsList = new ArrayList<>();
    }

    @Override
    public boolean addAnimal(Animal animal) {
        try {
            if (animal instanceof Pet) {
                petsList.add((Pet) animal);
                return true;
            } else if (animal instanceof Pack) {
                packsList.add((Pack) animal);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Animal searchByName(String name) {
        for (Pet e:petsList) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        for (Pack e:packsList) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<String> getCommands(String name) {
        Animal animal = searchByName((name));
        return animal.getCommands();
    }

    @Override
    public boolean addCommand(String name, String command) {
        Animal animal = searchByName(name);
        if (animal == null) {
            return false;
        }
        animal.addCommand(command);
        return true;
    }

    @Override
    public List<Pet> getPetsList() {
        return petsList;
    }

    @Override
    public List<Pack> getPacksList() {
        return packsList;
    }
}
