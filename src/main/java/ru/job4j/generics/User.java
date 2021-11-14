package ru.job4j.generics;

public class User extends Base {
    private String name;
    private String role;
    private int age;

    public User(String id, String name, String role, int age) {
        super(id);
        this.name = name;
        this.role = role;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        if (getAge() != user.getAge()) {
            return false;
        }
        if (!getName().equals(user.getName())) {
            return false;
        }
        return getRole().equals(user.getRole());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getRole().hashCode();
        result = 31 * result + getAge();
        return result;
    }
}
