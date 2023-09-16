package Examples;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void addTest()
    {
        Calculator calc=new Calculator();

        assertEquals(9, calc.add(4, 5));


    }
}
