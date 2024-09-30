package ie.atu.lambda;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        MathOperation addition = new Addition();
        System.out.println("Addition: " + addition.operate(10, 13));
        // Using a lambda expression instead of implementing the interface via a class
        MathOperation add = (a, b) -> a + b;
        
        System.out.println("Addition: " + addition.operate(5, 3));

        System.out.println();

        StringOperation toUpper = new ToUpperCase();
        System.out.println("Uppercase: " + toUpper.apply("Hello World!"));

        //Using Lambd expression
        StringOperation ToUpper = (a) -> a.toUpperCase();
        System.out.println("Uppercase: " + toUpper.apply("Lambda expression"));

        System.out.println();

        // Traditional way using an anonymous class
        /* 
        Runnable task = new Runnable() {
            public void run() {
                System.out.println("Thread is running");
            }
        };
        
        Thread thread = new Thread(task);
        thread.start();
        */

        // Using a lambda expression
        /*
        Runnable task = () -> System.out.println("Thread is running");
        
        Thread thread = new Thread(task);
        thread.start();
        */

        Runnable task = () -> System.out.println("Hello from the thread.");
        Thread thread = new Thread(task);
        thread.start();

        Calculator square = (int x) -> x*x;
        int result = square.calculator(5);
        System.out.println("Square of 5 is: " + result);

        System.out.println();

        // Define a lambda to reverse a string. Function<String, String> defines a function that takes a String as input and returns a String as output
        Function<String, String> reverse = s -> new StringBuilder(s).reverse().toString();

        // Define a lambda to convert a string to uppercase
        Function<String, String> toUpperCase = s -> s.toUpperCase();

        // Combine lambdas
        Function<String, String> combinedOperation = reverse.andThen(toUpperCase);

        // Apply the combined operation
        System.out.println("Result: " + combinedOperation.apply("Lambda"));

        //Trims white space from a string
        Function<String, String> trim = s -> s.trim();

        //Replaces spaces with hyphens -
        Function<String, String> replaceSpaces = s -> s.replace(" ", "-");

        //Converts text to lowercase
        Function<String, String> toLowerCase = s -> s.toLowerCase();

        //Combine lambdas
        Function<String, String> combine = trim.andThen(replaceSpaces).andThen(toLowerCase);

        //Test the combined operation
        String stringResult = combine.apply("    Hello World from Lambda   ");
        System.out.println("Result: " + stringResult);
    }
}
