package org.example;

import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        //Represents a supplier of results.

        //returns any kind of value
    }

    static String getDBConnectionUrl(){
        return  "url";
    }

    static Supplier<String> getDBConnectionUrlSupplier =() -> "url";
}
