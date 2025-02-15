package org.example;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // streams
        List<Integer> nums = List.of(22,44,55,66,77,88,99,23,45,43,32,65,55,76);
        Stream<Integer> numsStream = nums.stream();
        numsStream.filter(n -> n%2==0).map(n -> String.valueOf("")).map(s -> s+s).forEach( n -> System.out.println(n));


        EmployeeBO bo = new EmployeeBO();
        //bo.process();


        // [aa,bbb,cccc,d] -> [a=2,b=3,c=4,d=1]


    }
}