package org.example;

import java.util.IllformedLocaleException;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdasExample {

    public static void main(String[] args) {

        //

        //it is not working with primitives

        //this is the same, we return value
        Function<String, String> upperCaseName = name -> name.toUpperCase();
        Function<String, String> upperCaseNameSame = String::toUpperCase;

        //some logic
        Function<String, String> upperCaseNameWithException = name -> {
            if (name.isBlank()) throw new IllformedLocaleException("ex");
            return  name.toUpperCase();
        };

        BiFunction<String,Integer, String> upperCaseNameWithExceptionx = (name, age) -> {
            if (name.isBlank()) throw new IllformedLocaleException("ex");
            System.out.println(age);
            return  name.toUpperCase();
        };

        upperCaseNameWithExceptionx.apply("Alex", 22);
    }

}
