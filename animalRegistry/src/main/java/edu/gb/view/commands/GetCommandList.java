package edu.gb.view.commands;

import edu.gb.view.ConsoleUI;

public class GetCommandList extends  Command{
    public GetCommandList(ConsoleUI cons) {
        super("Показать список команд.", cons);
    }

    @Override
    public void execute() {
        getConsole().getCommands();
    }
}
