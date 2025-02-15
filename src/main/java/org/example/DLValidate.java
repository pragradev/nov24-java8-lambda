package org.example;
@FunctionalInterface
public interface DLValidate<T,R> {
    R test(T o);
}
