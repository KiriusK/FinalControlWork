package edu.gb.view.commands;


import edu.gb.view.ConsoleUI;

public class ShowAnimals extends Command{

    public ShowAnimals(ConsoleUI cons) {
        super("Показать список животных.", cons);
    }

    @Override
    public void execute() {
        getConsole().showAnimals();

    }
}
