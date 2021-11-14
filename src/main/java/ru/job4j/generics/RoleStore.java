package ru.job4j.generics;

public class RoleStore implements Store<Role> {
    private final Store<Role> store = new MemStore<>();

    @Override
    public void add(Role model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        boolean result;
        if (store.findById(id) != null) {
            store.replace(id, model);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result;
        if (store.findById(id) != null) {
            store.delete(id);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public Role findById(String id) {
        Role result;
        if (store.findById(id) != null) {
            result = store.findById(id);
        } else {
            result = null;
        }
        return result;
    }
}
