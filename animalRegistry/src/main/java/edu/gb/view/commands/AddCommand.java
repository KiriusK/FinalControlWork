package edu.gb.view.commands;

import edu.gb.view.ConsoleUI;

public class AddCommand extends Command{

    public AddCommand(ConsoleUI cons) {
        super("Добавить новую команду.",cons);
    }

    @Override
    public void execute() {
        getConsole().addCommand();
    }
}
