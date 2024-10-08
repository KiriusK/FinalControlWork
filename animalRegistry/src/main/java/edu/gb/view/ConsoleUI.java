package edu.gb.view;

import edu.gb.presenter.Presenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUI implements UI{
    private final Presenter presenter;
    private final MainMenu menu;
    private final Scanner scan;
    private boolean flag;

    public ConsoleUI(Presenter presenter) {
        this.presenter = presenter;
        this.menu = new MainMenu(this);
        this.scan = new Scanner(System.in);
        flag = true;
    }

    @Override
    public void start() {
        while (flag) {
            System.out.println(menu.menu());
            menuChoice();
        }
    }

    @Override
    public void show(String result) {
        System.out.println(result);
    }

    private void menuChoice() {
        String input = scan.nextLine();
        if (checkForDigit(input)) {
            int numInput = Integer.parseInt(input);
            if (checkCommand(numInput)) {
                menu.execute(numInput);
            }
        }
    }

    private boolean checkCommand(int numInput) {
        if (numInput <= menu.getSize()) {
            return true;
        } else {
            printError();
            return false;
        }
    }

    private void printError() {
        System.out.println("Неверный ввод, повторите попытку!");
    }

    private boolean checkForDigit(String input) {
        if (input.matches("[0-9]+")) {
            return true;
        } else {
            printError();
            return false;
        }
    }

    public void addAnimal() {
        String name = readName();
        System.out.print("Введите дату рождения в формате дд-мм-гггг: ");
        String birthStr = scan.nextLine();
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Date birthDate = df.parse(birthStr);
            presenter.addAnimal(name, birthDate);
        } catch (Exception ex) {
            printError();
            show(ex.getMessage());
        }
    }


    public void addCommand() {
        String name = readName();
        System.out.print("Введите новую команду: ");
        String command = scan.nextLine();
        presenter.addCommand(name,command);
    }


    public void exit() {
        System.out.println("Всего доброго!");
        flag=false;
    }


    public void findByName() {
        String name = readName();
        presenter.findByName(name);
    }


    public void getCommands() {
        String name = readName();
        presenter.getCommands(name);
    }

    private String readName() {
        System.out.print("Введите имя животного: ");
        return scan.nextLine();
    }


    public void showAnimals() {
        presenter.showAnimals();
    }
}
