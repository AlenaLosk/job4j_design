package ru.job4j.it;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (row == data.length) {
            return false;
        }
        if (column == data[row].length || data[row].length == 0) {
            column = 0;
            row++;
            hasNext();
        }
        return row < data.length && column < data[row].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }

    /*@Override
    public boolean hasNext() {
        if (row == data.length) {
            return false;
        }
        if (data[row].length != 0) {
            return (row < data.length) || column < data[row].length;
        } else {
            row++;
            return hasNext();
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (column < data[row].length) {
            return data[row][column++];
        } else {
            column = 0;
            row++;
            return next();
        }
    }*/
}