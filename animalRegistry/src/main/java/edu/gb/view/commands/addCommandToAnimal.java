package edu.gb.view.commands;

import edu.gb.view.ConsoleUI;

public class addCommandToAnimal extends Command{

    public addCommandToAnimal(ConsoleUI cons) {
        super("Показать родословное древо.",cons);
    }

    @Override
    public void execute() {
        getConsole().GetLineAgeInfo();
    }
}
