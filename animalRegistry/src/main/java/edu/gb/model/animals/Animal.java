package edu.gb.model.animals;

import java.util.Date;
import java.util.List;

public interface Animal {
    boolean changeName(String name);
    boolean changeBirthdate(Date bDate);
    boolean addCommand(String command);
    Date getBirthdate();
    String getName();
    List<String> getCommands();
    int getID();
}
