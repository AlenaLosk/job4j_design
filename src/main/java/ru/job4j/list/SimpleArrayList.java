package ru.job4j.list;

import java.util.*;

import static java.lang.System.arraycopy;

public class SimpleArrayList<T> implements List<T> {
    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size >= container.length) {
            this.grow();
        }
        container[size++] = value;
        modCount++;
    }

    private void grow() {
        if (container.length == 0) {
            container = (T[]) new Object[10];
        } else {
            T[] tempArray = (T[]) new Object[container.length * 2];
            System.arraycopy(container, 0, tempArray, 0, container.length);
            container = tempArray;
        }
    }

    @Override
    public T set(int index, T newValue) {
        T oldValue = get(index);
        container[index] = newValue;
        return oldValue;
    }

    @Override
    public T remove(int index) {
        T result = container[index];
        arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[size--] = null;
        modCount++;
        return result;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int expectedModCount = modCount;
            private int index = 0;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < size();
            }
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[index++];
            }
        };
    }
}
