package edu.gb.presenter;

import edu.gb.model.service.RegistryService;
import edu.gb.view.ConsoleUI;

import java.util.Date;

public class Presenter {
    private ConsoleUI ui;
    private RegistryService registry;

    public Presenter(ConsoleUI consoleUI) {
        this.ui = consoleUI;
        this.registry = new RegistryService();
    }

    public void addAnimal(String name, String type, Date birthDate) {
        if (registry.addAnimal(name, type, birthDate)) {
            ui.show("Животное добавлено");
        } else {
            ui.show("Ошибка при выполнении операции");
        }
    }

    public void addCommand(String name, String command) {
        if (registry.addCommand(name, command)) {
            ui.show("Команда добавлена для " + name);
        } else {
            ui.show("Ошибка при выполнении операции");
        }
    }

    public void findByName(String name) {
        ui.show(registry.findByName(name));
    }

    public void getCommands(String name) {
        ui.show(registry.getCommands(name));
    }

    public void showAnimals() {
        ui.show(registry.showAnimals());
    }
}
