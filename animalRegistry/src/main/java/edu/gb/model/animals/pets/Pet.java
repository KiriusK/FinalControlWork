package edu.gb.model.animals.pets;

import edu.gb.model.animals.Animal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Pet implements Animal {
    private int id;
    private String name;
    private Date birthDate;
    private List<String> commands;

    Pet(int id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    @Override
    public boolean changeName(String name) {
        try {
            this.name = name;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean changeBirthdate(Date bDate) {
        try {
            this.birthDate = bDate;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public boolean addCommand(String command) {
        try {
            commands.add(command);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Date getBirthdate() {
        return birthDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(";\n");
        sb.append("Имя: ");
        sb.append(name);
        sb.append(";\n");
        sb.append("Дата рождения: ");
        sb.append(birthDate.toString());
        sb.append(";\n");
        sb.append("Знает команды: ");
        sb.append(commands.toString());
        sb.append(";\n");
        return sb.toString();
    }

}
