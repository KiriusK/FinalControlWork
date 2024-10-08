package edu.gb.view.commands;


import edu.gb.view.ConsoleUI;

public class AddAnimal extends Command{

    public AddAnimal(ConsoleUI cons) {
        super("Добавить животное.", cons);
    }

    @Override
    public void execute() {
        getConsole().addAnimal();

    }
}
