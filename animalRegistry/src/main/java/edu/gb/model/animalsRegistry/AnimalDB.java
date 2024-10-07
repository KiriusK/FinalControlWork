package edu.gb.model.animalsRegistry;

import edu.gb.model.animals.Animal;
import edu.gb.model.animals.packs.Pack;
import edu.gb.model.animals.pets.Pet;

import java.util.List;

public interface AnimalDB {
    boolean addAnimal(Animal animal);
    Animal searchByName (String name);
    List<String> getCommands(String name);
    boolean addCommand (String name, String command);
    List<Pet> getPetsList();
    List<Pack> getPacksList();
}
