package org.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class EmployeeBO {
    int instanceCount = 2;
    public void process(){
        //int localCount = 3;
         AtomicReference<Integer> localCount = new AtomicReference<>(3);
        AtomicInteger count = new AtomicInteger(5);
        Iplay playAnnonyous = (a,b) -> a+b; // calculate

        int calculated = playAnnonyous.calculate(2, 3);
        System.out.println(calculated);
        System.out.println(localCount.get());

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

        employeeService.printSalary(employee, (e) -> {
            Integer i = localCount.get();
            i++;
            localCount.set(i);
            System.out.println(e.getSalary() + localCount.get());
            return e.getSalary() + localCount.get();
        });

        Student student = employeeService.converToStudent(employee, e -> Student
                .builder()
                .fName(e.getFName())
                .lName(e.getLName())
                .build());
        System.out.println(student);
    }
}
