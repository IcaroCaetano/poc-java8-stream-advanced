package com.project.poc_java8_stream_advanced.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Example03FindFirstAndFindAny {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Carlos", "Ana", "Icaro", "Maria", "Joao");

        Optional<String> firstName = names.stream()
                .filter(name -> name.length() > 3)
                .findFirst();

        System.out.println("First matching name: " + firstName);

        Optional<String> anyName = names.stream()
                .filter(name -> name.length() > 3)
                .findAny();

        System.out.println("Any matching name: " + anyName);

        Optional<String> missingName = names.stream()
                .filter(name -> name.startsWith("Z"))
                .findFirst();

        System.out.println("Missing name: " + missingName);

        String result = names.stream()
                .filter(name -> name.startsWith("Z"))
                .findFirst()
                .orElse("Name not found");

        System.out.println("Final result: " + result);

        List<Integer> numbers = Arrays.asList(3, 7, 8, 10, 12);

        Optional<Integer> firstEven = numbers.stream()
                .filter(number -> number % 2 == 0)
                .findFirst();

        System.out.println("First even number: " + firstEven);

        /**
         * First matching name: Optional[Carlos]
         * Any matching name: Optional[Carlos]
         * Missing name: Optional.empty
         * Final result: Name not found
         * First even number: Optional[8]
         */
    }
}
