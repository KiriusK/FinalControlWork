package edu.gb.model.animals.pets;

import java.util.ArrayList;
import java.util.Date;

public class Dog extends Pets{
    public Dog(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }
}
