package org.example;

import static org.example.ConsumerExample.Customer.greetCustomerConsumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        //Represents an operation that accepts a single input argument and returns no result.

        Customer.greetCustomer( new Customer("Irina", "0877665532"));

        //consumer functional interface
        greetCustomerConsumer.accept( new Customer("Irina", "0877665532"));

        Customer.greetCustomerConsumerBi.accept(new Customer("Irina", "0877665532"), false);
    }

    static class Customer{
        private  final String customerName;
        private  final String customerNumber;


        Customer(String customerName, String customerNumber) {
            this.customerName = customerName;
            this.customerNumber = customerNumber;
        }

        static  void greetCustomer(Customer customer){
            System.out.println("Hello "+ customer.customerName + " , thanks for registering phone number "+
                customer.customerNumber);
        }


        static BiConsumer<Customer, Boolean> greetCustomerConsumerBi = (customer, showPhoneNumber) ->
            System.out.println("Hello "+ customer.customerName + " , thanks for registering phone number "+
                ( showPhoneNumber ? customer.customerNumber: "**********"));
        static Consumer<Customer> greetCustomerConsumer = customer ->  System.out.println("Hello "+ customer.customerName + " , thanks for registering phone number "+
            customer.customerNumber);
    }

}
