package ru.job4j.kiss;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static junit.framework.Assert.assertNull;
import static org.hamcrest.core.Is.*;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MaxMinTest {

    @Test
    public void max() {
        List<Person> list = List.of(
                new Person(15),
                new Person(25),
                new Person(30),
                new Person(60),
                new Person(12)
        );
        Comparator<Person> comparator = (o1, o2) -> o1.getAge() - o2.getAge();
        MaxMin maxMin = new MaxMin();
        Person expected = new Person(60);
        assertThat(expected, is(maxMin.max(list, comparator)));
    }

    @Test
    public void min() {
        List<Person> list = List.of(
                new Person(15),
                new Person(25),
                new Person(30),
                new Person(60),
                new Person(12)
        );
        Comparator<Person> comparator = (o1, o2) -> o1.getAge() - o2.getAge();
        MaxMin maxMin = new MaxMin();
        Person expected = new Person(12);
        assertThat(expected, is(maxMin.min(list, comparator)));
    }

    @Test
    public void whenValueIsEmpty() {
        List<Person> list = List.of();
        Comparator<Person> comparator = (o1, o2) -> o1.getAge() - o2.getAge();
        MaxMin maxMin = new MaxMin();
        assertNull(maxMin.min(list, comparator));
    }
}