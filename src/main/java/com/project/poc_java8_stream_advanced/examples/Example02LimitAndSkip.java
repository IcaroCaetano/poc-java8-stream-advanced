package com.project.poc_java8_stream_advanced.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example02LimitAndSkip {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);

        List<Integer> limitedNumbers = numbers.stream()
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("First 3 numbers: " + limitedNumbers);

        List<Integer> skippedNumbers = numbers.stream()
                .skip(3)
                .collect(Collectors.toList());

        System.out.println("After skipping 3 numbers: " + skippedNumbers);

        List<Integer> paginatedNumbers = numbers.stream()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Page result: " + paginatedNumbers);

        List<Integer> filteredNumbers = numbers.stream()
                .filter(number -> number >= 30)
                .skip(1)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Filtered page: " + filteredNumbers);

        /**
         * First 3 numbers: [10, 20, 30]
         * After skipping 3 numbers: [40, 50, 60, 70, 80]
         * Page result: [30, 40, 50]
         * Filtered page: [40, 50, 60]
         */
    }
}
