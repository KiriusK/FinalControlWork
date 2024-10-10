package edu.gb.view;

import edu.gb.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI cons) {
        commandList = new ArrayList<>();
        commandList.add(new ShowAnimals(cons));
        commandList.add(new GetCommandList(cons));
        commandList.add(new FindByName(cons));
        commandList.add(new AddAnimal(cons));
        commandList.add(new AddCommand(cons));
        commandList.add(new ExitCommand(cons));
    }

    public String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n");
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }

}
