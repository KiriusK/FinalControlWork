package edu.gb.model.service;

import java.util.Iterator;

public class Counter implements AutoCloseable, Iterator<Integer> {
    private static int counter;

    public Counter() {
        counter = 1;
    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public boolean hasNext() {
        return counter<Integer.MAX_VALUE?true:false;
    }

    @Override
    public Integer next() {
        return counter++;
    }
}
