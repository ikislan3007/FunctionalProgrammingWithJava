package org.example;

import java.util.function.Predicate;

public class PredicateExample {


    public static void main(String[] args) {

        //Represents a predicate (boolean-valued function) of one argument.
        System.out.println(isPhoneNumberValid("0712121212"));
        System.out.println(isPhoneNumberValid("0912121212"));
        System.out.println( isPhoneNumberValid("071212121222"));
        System.out.println(isPhoneNumberValidPredicate.test("0712121212"));
        System.out.println( "valid and contains 7 "+isPhoneNumberValidPredicate.and(containsNumber7Predicate).test("0712121212"));
    }
    static boolean isPhoneNumberValid(String number){
        return number.startsWith("07") && number.length() == 10;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phone ->
        phone.startsWith("07") && phone.length() == 10;

    static Predicate<String> containsNumber7Predicate = number -> number.contains("7");
}
