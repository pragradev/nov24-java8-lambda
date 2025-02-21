package org.example;

import java.util.List;
import java.util.Optional;

public class EmployeeDAO {
    public Optional<Employee> findEmpByFName(String firstName){
        // writting an sql query to fetch emp from db
        //----------
        Employee e = Employee.builder()
                        .fName("Karan")
                        .lName("B")
                        .salary(105000)
                        .addresses(List.of(Address.builder().postalcode("A1B2C3").city("Toronto").build(),
                                Address.builder().postalcode("A1B2C3").city("Toronto").build()))
                        .build();
        //return Optional.ofNullable(e);
        return Optional.empty();
    }
}
