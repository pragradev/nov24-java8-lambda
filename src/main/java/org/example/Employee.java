package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Employee {
    private String fName;
    private String lName;
    private Integer salary;
    private List<Address> addresses;
}
