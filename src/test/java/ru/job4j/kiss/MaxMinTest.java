package ru.job4j.kiss;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MaxMinTest {

    public class Person {
        private int age;

        public Person(int age) {
            this.age = age;
        }

        public int getAge() {
            return this.age;
        }

        @Override
        public String toString() {
            return "Person{"
                    + "age=" + age
                    + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return age == person.age;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age);
        }
    }

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

}