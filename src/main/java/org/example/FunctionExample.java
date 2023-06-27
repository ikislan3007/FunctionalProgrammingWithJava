package org.example;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {

        //method
        int increment = incrementByOne(2);
        System.out.println(increment);

        //function takes 1 argument and produce 1 result
        // Represents a function that accepts one argument and produces a result.
        int increment2 =  incrementByOneFunc.apply(2);
        System.out.println(increment2);

        int multiply  = multipleBy10Func.apply(increment2);
        System.out.println(multiply);

        //bifunction takes 2 arguments and produce 1 result



        int resuiltIncrementByOneAndMultiply = incrementByOneAndMultiply(2, 100);
        System.out.println("resuiltIncrementByOneAndMultiply "+resuiltIncrementByOneAndMultiply);

        int resuiltIncrementByOneAndMultiplyFunc = incrementByOneAndMultiplyFunc.apply(2, 100);
        System.out.println("resuiltIncrementByOneAndMultiplyFunc "+resuiltIncrementByOneAndMultiplyFunc);

    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyFunc = (numberToIncrementByOne, numberToMultiplyBy)
        -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static Function<Integer, Integer> incrementByOneFunc = number -> number + 1;

    static Function<Integer, Integer> multipleBy10Func = number -> number * 10;
    static int incrementByOne(int number){
        return number +1;
    }

    static int incrementByOneAndMultiply(int number, int nomMultiply){
        return (number +1) * nomMultiply;
    }

}

