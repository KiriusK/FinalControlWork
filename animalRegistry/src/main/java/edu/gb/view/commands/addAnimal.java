package edu.gb.view.commands;


import edu.gb.view.ConsoleUI;

public class addAnimal extends Command{

    public addAnimal(ConsoleUI cons) {
        super("Добавить животное.", cons);
    }

    @Override
    public void execute() {
        getConsole().addAnimal();

    }
}
