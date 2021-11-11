package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] data;
    private int index = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int temp = index;
        boolean result = true;
        Integer number = nearestEvenNumber();
        if (number != null) {
            index = temp;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index = nearestEvenNumber();
        return data[index++];
    }

    private Integer nearestEvenNumber() {
        Integer result = index;
        while (true) {
            if (result == data.length) {
                result = null;
                break;
            } else if (data[result] % 2 == 0 && data[result] != 0) {
                break;
            } else {
                result++;
            }
        }
        return result;
    }
}
