package edu.gb.model.service;

import edu.gb.model.animals.Animal;
import edu.gb.model.animals.packs.Camel;
import edu.gb.model.animals.packs.Donkey;
import edu.gb.model.animals.packs.Horse;
import edu.gb.model.animals.packs.Pack;
import edu.gb.model.animals.pets.Cat;
import edu.gb.model.animals.pets.Dog;
import edu.gb.model.animals.pets.Hamster;
import edu.gb.model.animals.pets.Pet;
import edu.gb.model.animalsRegistry.AnimalRegistry;

import java.util.Date;

public class RegistryService {
    private AnimalRegistry registry;


    public RegistryService() {
        this.registry = new AnimalRegistry();
    }


    public boolean addAnimal(String name, String type, Date birthDate) {
        try (Counter counter = new Counter()) {
        int id;
        if (counter.hasNext()) {
            id = counter.next();
        } else {
            return false;
        }
        switch (type.toLowerCase()) {
            case "в":
                registry.addAnimal(new Camel(id, name, birthDate));
                return true;
            case "л":
                registry.addAnimal(new Horse(id, name, birthDate));
                return true;
            case "о":
                registry.addAnimal(new Donkey(id, name, birthDate));
                return true;
            case "с":
                registry.addAnimal(new Dog(id, name, birthDate));
                return true;
            case "к":
                registry.addAnimal(new Cat(id, name, birthDate));
                return true;
            case "х":
                registry.addAnimal(new Hamster(id, name, birthDate));
                return true;
            default:
                return false;
        }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean addCommand(String name, String command) {
        try {
            Animal anim = registry.searchByName(name);
            anim.addCommand(command);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public String findByName(String name) {
        Animal anim = registry.searchByName(name);
        if (anim != null) {
            return anim.toString();
        } else {
            return "Такое животное не найдено!";
        }
    }

    public String getCommands(String name) {
        Animal anim = registry.searchByName(name);
        if (anim != null) {
            StringBuilder sb = new StringBuilder();
            for (String e:anim.getCommands()) {
                sb.append(e);
                sb.append("\n");
            }
            return sb.toString();
        } else {
            return "Такое животное не найдено, не могу показать команды";
        }
    }

    public String showAnimals() {
        StringBuilder sb = new StringBuilder();
        for (Pet p:registry.getPetsList()) {
            sb.append(p.toString());
            sb.append("\n-------------\n");
        }
        for (Pack p:registry.getPacksList()) {
            sb.append(p.toString());
            sb.append("\n-------------\n");
        }
        String result = sb.toString();
        if (!result.isEmpty()) {
            return result;
        } else {
            return "Пока нет животных!(";
        }
    }
}
