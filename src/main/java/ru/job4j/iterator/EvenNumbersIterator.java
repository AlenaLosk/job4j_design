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
        int position = index + 1;
        return indexOfEvenNumber(position) != null ? true : false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index = indexOfEvenNumber(index);
        return data[index];
    }

    private Integer indexOfEvenNumber(int index) {
        int position = index;
        if (position == data.length) {
            return null;
        } else if (data[position] % 2 == 0 && data[position] != 0) {
            return position;
        } else {
            return indexOfEvenNumber(++position);
        }
    }
}
