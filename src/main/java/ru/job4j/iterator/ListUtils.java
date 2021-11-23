package ru.job4j.iterator;

import java.util.*;
import java.util.function.*;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.next();
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        List<T> temp = list.stream().filter(filter).toList();
        removeAll(list, temp);
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> j = list.stream().filter(filter).toList().listIterator();
        while (j.hasNext()) {
            T tempJ = j.next();
            ListIterator<T> i = list.listIterator();
            while (i.hasNext()) {
                T tempI = i.next();
                if (tempI.equals(tempJ)) {
                    i.set(value);
                    break;
                }
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
