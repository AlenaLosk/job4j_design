package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LnList<E> {
    private static class Node<E> {
        public E item;
        public Node<E> next;
        public Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    transient Node<E> first;
    transient Node<E> last;
    transient int size = 0;
    private int modCount;

    @Override
    public void add(E value) {
        Node curr = new Node<>(null, value, null);
        if (first == null) {
            first = curr;
            last = curr;
        } else {
            Node node = first;
            while (node.next != null) {
                node = node.next;
            }
            node.next = curr;
            curr.prev = node;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return (E) node.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node node = first;
                for (int i = 0; i < index; i++) {
                    node = node.next;
                }
                index++;
                return (E) node.item;
            }
        };
    }
}
