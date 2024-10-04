package edu.gb.model.animals.packs;

import java.util.ArrayList;
import java.util.Date;

public class Horse extends Packs{
    public Horse(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }
}
