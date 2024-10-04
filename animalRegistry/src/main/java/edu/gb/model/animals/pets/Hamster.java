package edu.gb.model.animals.pets;

import java.util.ArrayList;
import java.util.Date;

public class Hamster extends Pets{
    public Hamster(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }
}
