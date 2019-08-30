import junit.Calculator;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Start calculation test")
class TestCalculator {
    private static final Logger logger = Logger.getLogger("Test Calculator");
    private static Calculator calculator;

    @BeforeAll
    static void init() {
        calculator = new Calculator();
        calculator.initializeOutputWriter();

        calculator.setRadians(150);

        assertTrue(calculator.getDegrees() != 0);
    }

    @BeforeEach
    void setupValue() {
        assertTrue(calculator.getDegrees() != 0);
        logger.log(Level.INFO, "Radians are nonnull : " + calculator.getDegrees());
    }

    @Nested
    @DisplayName("Sinus nested class")
    class Sinus {
        double[] sinValuesDoubles = new double[]{90, 230, 59, 0, 1};

        @Before
        void permissibleValuesShouldBeAppropriate() {
            for (double angle : sinValuesDoubles) {
                double value = Double.parseDouble(calculator.getSin(angle));
                assertTrue(value >= -1 && value <= 1);
            }
        }

        @Test
        void testSinValue() {
            calculator.setRadians(45);
            assertEquals(calculator.getSin(calculator.getDegrees()), "0.81");
        }
    }

    @Test
    void cosScopeShouldBeAppropriate() {
        calculator.setRadians(60);
        double value = Double.parseDouble(calculator.getCos(calculator.getDegrees()));
        assertTrue(value >= -1 && value <= 1);
    }

    @Test
    void testCosValue() {
        calculator.setRadians(60);
        assertEquals("0.66", calculator.getCos(calculator.getDegrees()));
    }

    @Test
    void testTanValue() {
        calculator.setRadians(30);
        assertEquals("0.45", calculator.getTan(calculator.getDegrees()));
    }

    @Test
    void testTanScopeShouldBeAppropriate() {
        calculator.setRadians(30);
        double N = 10;
        double value = Double.parseDouble(calculator.getTan(calculator.getDegrees()));
        System.out.println(value);
        assertTrue(value <= (-PI / 2 + PI * N));
    }

    @Test
    void testCtgValue() {
        calculator.setRadians(15);
        assertEquals("-0.21", calculator.getCtg(calculator.getDegrees()));
    }

    @AfterEach
    private void clearLog() {
        calculator.clear();
    }

    @AfterAll
    static void turnOffCalculator() {
        logger.log(Level.INFO, "Test passed completely");
        calculator = null;
    }
}