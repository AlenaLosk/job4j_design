package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
        mem.put(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result;
        if (mem.containsKey(id)) {
            mem.put(id, model);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result;
        if (mem.containsKey(id)) {
            mem.remove(id);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public T findById(String id) {
       return mem.getOrDefault(id, null);
    }
}
