package org.example;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Iplay playAnnonyous = (a,b) -> a+b; // calculate

        int calculated = playAnnonyous.calculate(2, 3);
        System.out.println(calculated);

        DriveTest onDriveTest = new DriveTest();
        DriveTest qcDriveTest = new DriveTest();
        DriveTest bcDriveTest = new DriveTest();
        //DLValidate dlValidate = (dl) -> dl.length()==15;
        onDriveTest.validateLicence( (dl) -> dl.length()==15 ,"H34325678789765" );
        qcDriveTest.validateLicence( (dl) -> dl.length()==16 ,"H3432567878974" );
        bcDriveTest.validateLicence( (dl) -> dl.length()==14 ,"H3432567878976" );

        EmployeeService employeeService = new EmployeeService();
        Employee employee = Employee
                .builder()
                .fName("Karan")
                .lName("B")
                .salary(115000)
                .build();
        employeeService.printSalary(employee, (e) -> e.getSalary());
        Student student = employeeService.converToStudent(employee, e -> Student
                .builder()
                .fName(e.getFName())
                .lName(e.getLName())
                .build());
        System.out.println(student);


    }
}