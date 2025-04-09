package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    // Mockito -> When and Then return statements
    Calculator calculator = null;
    Multiply multiply = Mockito.mock(Multiply.class);
//    @Mock
//    Multiply multiply;
    @BeforeEach
    public void before(){
        calculator = new Calculator(multiply);
    }

    @Test
    public void calculateTest() throws Exception{

//        int actual = calculator.calculate(22, 2);
//        int expected = 2;
        // assertion statements
        // happy path
        Mockito.when(multiply.multiply(22,2)).thenReturn(44);
        //Mockito.when(multiply.multiply(Mockito.any(),Mockito.any())).thenReturn(44);
        Mockito.doNothing().when(multiply).checkInDatabase(Mockito.anyInt());
        Mockito.verify(multiply,Mockito.times(1)).checkInDatabase(Mockito.anyInt());
        Assertions.assertEquals(22,calculator.calculate(22, 2));

        Mockito.verify(multiply,Mockito.times(2)).checkInDatabase(Mockito.anyInt());

        Mockito.when(multiply.multiply(44,2)).thenReturn(88);
        Assertions.assertEquals(22,calculator.calculate(44, 200));

        Mockito.when(multiply.multiply(Mockito.anyInt(),Mockito.anyInt())).thenReturn(44);




    }
    @Test
    public void calculateExceptionTest(){
        Assertions.assertThrows(ArithmeticException.class,() -> {
            calculator.calculate(22,0);
        });
        Assertions.assertThrows(UnderAgeLimitException.class,() -> {
            calculator.calculate(2,2);
        });

    }
    @Test
    public void checkEvenTest(){
        Assertions.assertTrue(calculator.checkEven(44));
        Assertions.assertFalse(calculator.checkEven(45));
    }
}