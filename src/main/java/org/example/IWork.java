package org.example;

public interface IWork {
    default void display(){ // not instance-  concreat
        System.out.println("Displaying from IWork");
    }

    default void work(){
        System.out.println("working from IWork");

    }
}
