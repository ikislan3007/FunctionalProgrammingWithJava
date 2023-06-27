package org.example;

import java.util.function.Consumer;

public class CallBack {

    public static void main(String[] args) {
        hello("Ann", "Smith", null);
        hello("Ann", null, value ->{
            System.out.println("Lastname not provided for "+ value);
        });
    }

    static void hello(String firstName, String lastName, Consumer<String> callback){
        if (lastName != null){
            System.out.println(lastName);
        }else{
            callback.accept(firstName);
        }

    }
}
