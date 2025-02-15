package org.example;

import java.util.function.Function;

public class EmployeeService {
    public void printSalary(Employee employee, Function<Employee,Integer> function){
        // call some api to fetch data
        // db code
        System.out.println(function.apply(employee));
    }

    public Student converToStudent(Employee employee, Function<Employee,Student> function){
        return function.apply(employee);
    }

}
