package org.example;

public class Calculator {
    Multiply multiply;

    public Calculator(Multiply multiply) {
        this.multiply = multiply;
    }

    public int calculate(int a, int b) throws Exception{
        if (a < 16){
            throw new UnderAgeLimitException("age is less then 16");
        }
        if(a > 100){
            throw new OverAgeLimitException("age is more then 100");
        }
        if(b>0&&b<=100){
            multiply.checkInDatabase(b);
        }
        if (b>100){
            multiply.checkInDatabase(a);
            multiply.checkInDatabase(b);
        }

        return multiply.multiply(a,2)/b;
    }

    public boolean checkEven(int x){
        return x%2==0;
    }
}
