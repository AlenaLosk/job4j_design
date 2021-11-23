package ru.job4j.iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.*;
import java.util.function.Predicate;


import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenAddAndRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 5, 9));
        ListUtils.removeAll(input, Arrays.asList(1, 9, 2));
        assertThat(input, is(Arrays.asList(0, 5)));
    }

    @Test
    public void whenAddAndRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 1, 9));
        ListUtils.removeIf(input, e -> e > 1);
        assertThat(input, is(Arrays.asList(0, 1, 1)));
    }

    @Test
    public void whenAddAndReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 1, 9));
        ListUtils.replaceIf(input, e -> e > 1, 5);
        assertThat(input, is(Arrays.asList(0, 1, 5, 1, 5)));
    }
}