package com.project.poc_java8_stream_advanced.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example07CollectorsRealWorld {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Ana", "IT", 7000),
                new Employee("Carlos", "HR", 4000),
                new Employee("Maria", "IT", 8500),
                new Employee("Joao", "FINANCE", 6000),
                new Employee("Pedro", "HR", 3500)
        );

        Map<String, List<Employee>> employeesByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("Employees by department:");
        employeesByDepartment.forEach((department, list) ->
                System.out.println(department + ": " + list)
        );

        Map<String, Long> countByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                                )
                        );

        System.out.println("\nEmployee count by department:");
        System.out.println(countByDepartment);

        Map<Boolean, List<Employee>> salaryPartition =
                employees.stream()
                        .collect(Collectors.partitioningBy(employee -> employee.getSalary() >= 6000));

        System.out.println("\nSalary partition:");
        System.out.println("Salary >= 6000: " + salaryPartition.get(true));
        System.out.println("Salary < 6000: " + salaryPartition.get(false));

        String employeeNames =
                employees.stream()
                        .map(Employee::getName)
                        .collect(Collectors.joining(", "));

        System.out.println("\nEmployee names:");
        System.out.println(employeeNames);

        Map<String, Integer> salaryByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.summingInt(Employee::getSalary)
                        ));

        System.out.println("\nTotal salary by department:");
        System.out.println(salaryByDepartment);

        /**
         * Employees by department:
         * FINANCE: [Joao (R$ 6000)]
         * HR: [Carlos (R$ 4000), Pedro (R$ 3500)]
         * IT: [Ana (R$ 7000), Maria (R$ 8500)]
         *
         * Employee count by department:
         * {FINANCE=1, HR=2, IT=2}
         *
         * Salary partition:
         * Salary >= 6000: [Ana (R$ 7000), Maria (R$ 8500), Joao (R$ 6000)]
         * Salary < 6000: [Carlos (R$ 4000), Pedro (R$ 3500)]
         *
         * Employee names:
         * Ana, Carlos, Maria, Joao, Pedro
         *
         * Total salary by department:
         * {FINANCE=6000, HR=7500, IT=15500}
         */
    }

    static class Employee {

        private final String name;
        private final String department;
        private final int salary;

        public Employee(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public int getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return name + " (R$ " + salary + ")";
        }
    }
}
