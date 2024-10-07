package edu.gb.view.commands;

import edu.gb.view.ConsoleUI;

public class addCommand extends Command{

    public addCommand(ConsoleUI cons) {
        super("Добавить новую команду.",cons);
    }

    @Override
    public void execute() {
        getConsole().addCommand();
    }
}
