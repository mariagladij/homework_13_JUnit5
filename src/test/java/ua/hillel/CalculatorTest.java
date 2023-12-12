package ua.hillel;

import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class CalculatorTest {
    Calculator calculator = new Calculator();

    @BeforeAll
    static void start(){
        System.out.println("Testing starts");
    }

    @AfterAll
    static void finish(){
        System.out.println("Testing finished");
    }

    @BeforeEach
    void startEach(){
        System.out.println("Test starts at: " + new Date().getTime());
    }

    @AfterEach
    void finishEach(){
        System.out.println("Test finished");
    }

    @Test
   // @Order(1)
    void checkAddition(){
        assertEquals(11, calculator.add(4,7), "Addition result is incorrect");
    }

    @Test
    //@Order(3)
    void checkDivision(){
        assertTrue(calculator.divide(25,5) == 5);
    }

    @Test
    //@Order(2)
    @DisplayName("Division by zero should throw exception")
    void checkDivisionByZero(){
        assertEquals(0, calculator.divide(3,0));
        assertThrows(ArithmeticException.class, () -> calculator.divide(3,0));
    }

}