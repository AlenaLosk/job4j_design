package ru.job4j.list;

import java.util.*;

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
            T[] tempArray = (T[]) new Object[container.length * 2];
            System.arraycopy(container, 0, tempArray, 0, container.length);
            container = tempArray;
        }
        container[size] = value;
        size++;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        T oldValue = container[Objects.checkIndex(index, container.length)];
        container[index] = newValue;
        return oldValue;
    }

    @Override
    public T remove(int index) {
        T result = get(Objects.checkIndex(index, container.length));
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[size] = null;
        size--;
        modCount++;
        return result;
    }

    @Override
    public T get(int index) {
        return container[Objects.checkIndex(index, container.length)];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;
            Iterator temp = Arrays.asList(Arrays.copyOf(container, size)).iterator();
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return temp.hasNext();
            }
            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) temp.next();
            }
        };
    }
}
