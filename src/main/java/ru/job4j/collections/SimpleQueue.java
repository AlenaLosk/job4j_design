package ru.job4j.collections;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size;

    /*
    Первый пришел, первый ушел.
    */

    public T poll() {
        if (out.isEmpty()) {
            if (in.isEmpty()) {
                throw new NoSuchElementException();
            }
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        T temp = out.pop();
        size--;
        return temp;
    }

    public void push(T value) {
        in.push(value);
        size++;
    }

    public int size() {
        return size;
    }
}
