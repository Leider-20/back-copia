package co.udea.ssmu.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SampleTestObjectTest {

    private SampleTestObject testObject;

    @BeforeEach
    public void setUp() {
        testObject = new SampleTestObject();
    }

    @Test
    public void testAdd() {
        assertEquals(5, testObject.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    public void testSubtract() {
        assertEquals(1, testObject.subtract(3, 2), "3 - 2 should equal 1");
    }

    @Test
    public void testMultiply() {
        assertEquals(6, testObject.multiply(2, 3), "2 * 3 should equal 6");
    }

    @Test
    public void testDivide() {
        assertEquals(2, testObject.divide(4, 2), "4 / 2 should equal 2");
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> testObject.divide(1, 0), "Divide by zero should throw IllegalArgumentException");
    }
}
