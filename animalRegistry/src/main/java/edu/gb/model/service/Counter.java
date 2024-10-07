package edu.gb.model.service;

public class Counter {
    private int counter;

    public Counter() {
        this.counter = 1;
    }

    public void increase() {
        this.counter++;
    }

    public int getCounter() {
        return counter;
    }
}
