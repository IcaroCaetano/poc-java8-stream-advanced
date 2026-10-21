package com.project.poc_java8_stream_advanced.examples;

import java.util.Arrays;
import java.util.List;

public class Example04MatchOperations {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        boolean hasNumberGreaterThan40 = numbers.stream()
                .anyMatch(number -> number > 40);

        System.out.println("Any number greater than 40: " + hasNumberGreaterThan40);

        boolean allNumbersGreaterThan5 = numbers.stream()
                .allMatch(number -> number > 5);

        System.out.println("All numbers greater than 5: " + allNumbersGreaterThan5);

        boolean noNumberLessThan0 = numbers.stream()
                .noneMatch(number -> number < 0);

        System.out.println("No number less than 0: " + noNumberLessThan0);

        boolean allNumbersGreaterThan25 = numbers.stream()
                .allMatch(number -> number > 25);

        System.out.println("All numbers greater than 25: " + allNumbersGreaterThan25);

        List<String> emails = Arrays.asList(
                "user@email.com",
                "admin@email.com",
                "support@email.com"
        );

        boolean allEmailsContainAt = emails.stream()
                .allMatch(email -> email.contains("@"));

        System.out.println("All emails contain @: " + allEmailsContainAt);

        /**
         * Any number greater than 40: true
         * All numbers greater than 5: true
         * No number less than 0: true
         * All numbers greater than 25: false
         * All emails contain @: true
         */
    }
}
