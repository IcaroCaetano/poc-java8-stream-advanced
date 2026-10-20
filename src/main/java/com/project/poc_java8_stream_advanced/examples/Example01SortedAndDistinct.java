package com.project.poc_java8_stream_advanced.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example01SortedAndDistinct {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 2, 8, 2, 1, 5, 9, 3, 1);

        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Original numbers: " + numbers);
        System.out.println("Sorted numbers: " + sortedNumbers);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Distinct numbers: " + distinctNumbers);

        List<Integer> sortedDistinctNumbers = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Sorted distinct numbers: " + sortedDistinctNumbers);

        List<Integer> descendingNumbers = numbers.stream()
                .distinct()
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());

        System.out.println("Descending numbers: " + descendingNumbers
        );

        /**
         * Original numbers: [5, 2, 8, 2, 1, 5, 9, 3, 1]
         * Sorted numbers: [1, 1, 2, 2, 3, 5, 5, 8, 9]
         * Distinct numbers: [5, 2, 8, 1, 9, 3]
         * Sorted distinct numbers: [1, 2, 3, 5, 8, 9]
         * Descending numbers: [9, 8, 5, 3, 2, 1]
         */
    }
}
