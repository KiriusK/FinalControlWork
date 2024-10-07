package edu.gb.view.commands;

import edu.gb.view.ConsoleUI;

public class FindByName extends Command{
    public FindByName(ConsoleUI cons) {
        super("Найти животное по имени.", cons);
    }

    @Override
    public void execute() {
        getConsole().findByName();
    }
}
