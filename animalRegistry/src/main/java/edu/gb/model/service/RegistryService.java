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
//    private Counter counter;

    public RegistryService() {
        this.registry = new AnimalRegistry();
//        this.counter = new Counter();
    }


    public boolean addAnimal(String name, String type, Date birthDate) {
        Counter counter = new Counter();
        int id = counter.next();
        switch (type.toLowerCase()) {
            case "верблюд":
                registry.addAnimal(new Camel(id, name, birthDate));
                return true;
            case "лошадь":
                registry.addAnimal(new Horse(id, name, birthDate));
                return true;
            case "осел":
                registry.addAnimal(new Donkey(id, name, birthDate));
                return true;
            case "собака":
                registry.addAnimal(new Dog(id, name, birthDate));
                return true;
            case "кошка":
                registry.addAnimal(new Cat(id, name, birthDate));
                return true;
            case "хомяк":
                registry.addAnimal(new Hamster(id, name, birthDate));
                return true;
            default:
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
