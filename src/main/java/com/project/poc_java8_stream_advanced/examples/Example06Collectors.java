package com.project.poc_java8_stream_advanced.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example06Collectors {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Icaro", "Ana", "Carlos", "Ana", "Maria");

        List<String> collectedNames = names.stream()
                .collect(Collectors.toList());

        System.out.println("Collected names: " + collectedNames);

        String joinedNames = names.stream()
                .collect(Collectors.joining(", "));

        System.out.println("Joined names: " + joinedNames);

        Map<Integer, List<String>> namesByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println("Names grouped by length: " + namesByLength);

        Map<Integer, Long> countByLength = names.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.counting()
                ));

        System.out.println("Count by length: " + countByLength);

        Map<Boolean, List<String>> partitionedNames = names.stream()
                .collect(Collectors.partitioningBy(
                        name -> name.length() > 4
                ));

        System.out.println("Partitioned names: " + partitionedNames);

        /**
         * Collected names: [Icaro, Ana, Carlos, Ana, Maria]
         * Joined names: Icaro, Ana, Carlos, Ana, Maria
         * Names grouped by length: {3=[Ana, Ana], 5=[Icaro, Maria], 6=[Carlos]}
         * Count by length: {3=2, 5=2, 6=1}
         * Partitioned names: {false=[Ana, Ana], true=[Icaro, Carlos, Maria]}
         */
    }
}
