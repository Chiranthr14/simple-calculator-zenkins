package com.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class calculatortest {
    private final calculator calc = new calculator();

    @Test
    public void testAdd() { 
        assertEquals(8, calc.add(5, 3)); 
    }

    @Test
    public void testSubtract() { 
        assertEquals(2, calc.subtract(5, 3)); 
    }
}
