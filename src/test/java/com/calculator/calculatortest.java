
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAddition() {
        assertEquals(10, 5 + 5);
    }

    @Test
    public void testSubtraction() {
        assertEquals(5, 10 - 5);
    }

    @Test
    public void testMultiplication() {
        assertEquals(20, 5 * 4);
    }

    @Test
    public void testDivision() {
        assertEquals(5, 20 / 4);
    }
}
