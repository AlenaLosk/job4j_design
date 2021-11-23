package ru.job4j.collections;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private int size;

    public T pop() {
        T temp = linked.deleteFirst();
        size--;
        return temp;
    }

    public void push(T value) {
        linked.addFirst(value);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
