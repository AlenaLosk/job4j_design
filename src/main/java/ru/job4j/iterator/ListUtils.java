package ru.job4j.iterator;

import java.util.*;
import java.util.function.*;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator(index);
        if (i.hasPrevious()) {
            i.previousIndex();
            i.add(value);
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator(index);
        if (i.hasNext()) {
            i.next();
            i.add(value);
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            T tempI = i.next();
            if (filter.test(tempI)) {
                i.remove();
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            T tempI = i.next();
            if (filter.test(tempI)) {
                i.set(value);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> j = elements.listIterator();
        while (j.hasNext()) {
            T tempJ = j.next();
            ListIterator<T> i = list.listIterator();
            while (i.hasNext()) {
                T tempI = i.next();
                if (tempI.equals(tempJ)) {
                    i.remove();
                    break;
                }
            }
        }
    }

}
