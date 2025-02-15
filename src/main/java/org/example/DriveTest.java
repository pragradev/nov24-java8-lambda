package org.example;

import java.util.function.Function;
import java.util.function.Predicate;

public class DriveTest {

    public void validateLicence(Function<String, Boolean> function, String dln){
        if(function.apply(dln)){
            System.out.println("Driver Licence is validated");
        }
        else {
            System.out.println("Driver Licence is not validated");

        }
    }
}
