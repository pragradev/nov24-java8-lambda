package org.example;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // streams
        List<Integer> nums = List.of(22,44,55,66,77,88,99,23,45,43,32,65,55,76);
        //Stream<Integer> numsStream = nums.stream();
        nums.stream().filter(n -> n%2==0).map(n -> String.valueOf("")).map(s -> s+s).forEach( n -> System.out.println(n));

        List<Employee> employees = List.of(
                Employee.builder()
                        .fName("Karan")
                        .lName("B")
                        .salary(105000)
                        .addresses(List.of(Address.builder().postalcode("A1B2C3").city("Toronto").build(),
                                Address.builder().postalcode("A1B2C3").city("Toronto").build()))
                        .build(),

                Employee.builder()
                        .fName("Rachana")
                        .lName("M")
                        .salary(115000)
                        .addresses(List.of(Address.builder().postalcode("X7Y8Z9").city("Toronto").build(),
                                Address.builder().postalcode("A1B2C3").city("Toronto").build()))
                        .build(),

                Employee.builder()
                        .fName("Chris")
                        .lName("S")
                        .salary(120000)
                        .addresses(List.of(Address.builder().postalcode("D4E5F6").city("Toronto").build(),
                                Address.builder().postalcode("A1B2C3").city("Toronto").build()))
                        .build(),

                Employee.builder()
                        .fName("Sahil")
                        .lName("P")
                        .salary(125000)
                        .addresses(List.of(Address.builder().postalcode("J3K5L6").city("Toronto").build(),
                                Address.builder().postalcode("A1B2C3").city("Toronto").build()))
                        .build()
        );
        // flatmap -> flatten stream
        // arith => reduce
        // 105000, 115000,120000,125000
        Integer sum = employees.stream().map(e -> e.getSalary()).reduce( 0, (a, b) -> a * b);
        System.out.println(sum);
        List<String> postalcodes = employees.stream().flatMap(e -> e.getAddresses().stream()).map(a -> a.getPostalcode())..collect(Collectors.toList());
        System.out.println(postalcodes);

        //get list of employees who has morethan 117000
        // lazy loader
        // stream never mod original stream/ collection - alwasy gen new data
        List<Employee> processedEmployees = employees.stream().filter(x -> x.getSalary() > 117000).collect(Collectors.toList());
        System.out.println(processedEmployees);


//        employees.stream().map(e -> {
//            e.setSalary(200000);
//            e.setFName("test");
//            return e;
//        }).collect(Collectors.toList());
//        System.out.println( "Employees = " +employees);
        // sum of all slaries:
        // reduce:
        // flatmap

        //EmployeeBO bo = new EmployeeBO();
        //bo.process();


        // [aa,bbb,cccc,d] -> [a=2,b=3,c=4,d=1]


    }
}