package org.example;


import static org.example.StreamExample.Gender.FEMALE;
import static org.example.StreamExample.Gender.MALE;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class StreamExample {

    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Irina", FEMALE),
            new Person("Dmitro", MALE),
            new Person("Maria", FEMALE),
            new Person("Alex", MALE),
            new Person("Anna", FEMALE),
            new Person("Max", MALE)
        );

        //stream, map - transform, print
        people.stream().map(person -> person.gender).collect(Collectors.toSet())
        .forEach(System.out::println);

        people.stream()
            .map(person -> person.name)//Function<Person,String> personStringFunction
            .mapToInt(name -> name.length())//toIntFunction
            .forEach(System.out::println);//consumer

        boolean containsOnlyFemales = people.stream()
            .allMatch(person -> FEMALE.equals(person.gender));

        Predicate<Person> containsOnlyFemalesPredicate = person -> FEMALE.equals(person.gender);

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
