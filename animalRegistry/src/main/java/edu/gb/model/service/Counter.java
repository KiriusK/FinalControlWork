package edu.gb.model.service;

import java.util.Iterator;

public class Counter implements AutoCloseable, Iterator<Integer> {
    private static int counter = 1;


    @Override
    public void close() throws Exception {
        System.out.println("Ресурс закрыт");
    }

    @Override
    public boolean hasNext() {
        return counter < Integer.MAX_VALUE;
    }

    @Override
    public Integer next() {
        return counter++;
    }
}
