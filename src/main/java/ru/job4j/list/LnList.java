package ru.job4j.list;

public interface LnList<E> extends Iterable<E> {
    void add(E value);
    E get(int index);
    int size();
}
