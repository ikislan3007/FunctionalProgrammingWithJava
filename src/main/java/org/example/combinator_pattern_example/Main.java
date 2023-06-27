package org.example.combinator_pattern_example;

import static org.example.combinator_pattern_example.CustomerRegistrationValidator.isAnAdult;
import static org.example.combinator_pattern_example.CustomerRegistrationValidator.isEmailPhoneNumber;
import static org.example.combinator_pattern_example.CustomerRegistrationValidator.isEmailValid;

import java.time.LocalDate;
import org.example.combinator_pattern_example.CustomerRegistrationValidator.ValidationResult;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Alice",
            "alice@gmail.com",
            "+0877666666", LocalDate.of(1999, 1, 1));

        ValidationResult result = isEmailValid()
            .and(isEmailPhoneNumber())
            .and(isAnAdult()).apply(customer);

        System.out.println(result);
    }

}
