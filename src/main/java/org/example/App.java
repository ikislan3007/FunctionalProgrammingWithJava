package org.example;

import static org.example.App.Gender.FEMALE;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        List<Person> people = List.of(
            new Person("Irina", FEMALE),
            new Person("Dmitro", Gender.MALE),
            new Person("Maria", FEMALE),
            new Person("Alex", Gender.MALE),
            new Person("Anna", FEMALE),
            new Person("Max", Gender.MALE)
        );

        //predicate

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        List<Person> females = people.stream().filter(personPredicate).collect(Collectors.toList());

        females.forEach(System.out::println);
    }

    static class Person{
        private final String name;

        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

    }
    enum Gender{
        MALE, FEMALE
    }

}
