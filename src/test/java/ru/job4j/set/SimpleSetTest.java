package ru.job4j.set;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddNullAndDigits() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.add(8));
        assertTrue(set.add(15));
        assertFalse(set.add(null));
        assertFalse(set.add(15));
        assertTrue(set.contains(null));
        assertTrue(set.contains(8));
        assertFalse(set.contains(0));
    }

    @Test
    public void whenAddOnlyDigits() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(8));
        assertTrue(set.add(15));
        assertFalse(set.add(15));
        assertTrue(set.contains(8));
        assertFalse(set.contains(0));
    }
}