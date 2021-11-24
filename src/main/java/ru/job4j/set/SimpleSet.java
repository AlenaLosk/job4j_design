package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;
import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>();

    @Override
    public boolean add(T value) {
        boolean result = false;
        if (set.size() == 0 || !contains(value)) {
            set.add(value);
            result = true;
        }
        return result;
    }

    @Override
    public boolean contains(T value) {
        boolean result = false;
        if (set.size() != 0) {
            for (T element : set) {
                if ((element == null && value == null)
                        || (element != null && value != null && element.equals(value))) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
