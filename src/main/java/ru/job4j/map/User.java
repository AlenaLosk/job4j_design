package ru.job4j.map;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class User {
    private String name;
    private int children;
    private Calendar birthday;


    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public User() {
        this.name = "Иван Тихонов";
        this.children = 8;
        this.birthday =  new GregorianCalendar(1980, 0, 23);
    }
}
