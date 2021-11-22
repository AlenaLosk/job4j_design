package ru.job4j.list;

import java.util.Iterator;

public class SimpleLinkedList<E> implements LnList<E> {
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node<E>[] container;
    private int size;
    private int modCount;

    @Override
    public void add(E value) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
