package edu.gb.view.commands;


import edu.gb.view.ConsoleUI;

public class showAnimals extends Command{

    public showAnimals(ConsoleUI cons) {
        super("Показать список животных.", cons);
    }

    @Override
    public void execute() {
        getConsole().showAnimals();

    }
}
