package com.project.poc_java8_stream_advanced.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class Example05NumericOperations {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        long count = numbers.stream()
                .count();

        System.out.println("Count: " + count);

        Optional<Integer> min = numbers.stream()
                .min(Integer::compareTo);

        System.out.println("Minimum: " + min.orElse(0));

        Optional<Integer> max = numbers.stream()
                .max(Integer::compareTo);

        System.out.println("Maximum: " + max.orElse(0));

        Optional<Integer> sum = numbers.stream()
                .reduce((a, b) -> a + b);


        System.out.println("Sum using reduce: " + sum.orElse(0));

        Optional<Integer> product = numbers.stream()
                .reduce((a, b) -> a * b);

        System.out.println("Product using reduce: " + product.orElse(0));


        int total = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println("Total with identity: " + total);

        OptionalInt maxNumber = numbers.stream()
                .mapToInt(Integer::intValue)
                .max();

        System.out.println("Maximum using IntStream: " + maxNumber.orElse(0));

        /**
         * Count: 5
         * Minimum: 10
         * Maximum: 50
         * Sum using reduce: 150
         * Product using reduce: 12000000
         * Total with identity: 150
         * Maximum using IntStream: 50
         */
    }
}
