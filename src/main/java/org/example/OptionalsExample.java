package org.example;

import java.util.Optional;

public class OptionalsExample {

    public static void main(String[] args) {

        Optional.ofNullable("test@gmail.com").ifPresent(
            email -> System.out.println("Sending email to " + email)
        );

        Optional.ofNullable(null).ifPresent(
            email -> System.out.println("Sending email to " + email));

        Optional.ofNullable(null).ifPresentOrElse(
            email -> System.out.println("Sending email to " + email),
            () -> {
                System.out.println("Can not send email");
            } );
    }

}
