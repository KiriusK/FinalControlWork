package edu.gb.model.animals.packs;

import java.util.ArrayList;
import java.util.Date;

public class Donkey extends Packs{
    public Donkey(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }
}
