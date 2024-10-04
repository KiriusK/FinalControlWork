package edu.gb.view.commands;


import edu.gb.view.ConsoleUI;

public class ExitCommand extends Command{
    public ExitCommand(ConsoleUI cons) {
        super("Выход.", cons);
    }

    @Override
    public void execute() {
        getConsole().exit();
    }
}
