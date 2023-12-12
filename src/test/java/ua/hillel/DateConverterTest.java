package ua.hillel;
import org.junit.jupiter.api.*;

import java.time.format.DateTimeParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


class DateConverterTest {

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
    void testConvertDateInvalidInput() {
        assertThrows(DateTimeParseException.class, () -> {
            DateConverter.convertDate("2023-01-12", "dd-MM-yyyy", "yyyy-MM-dd");
        });
    }

    @Test
    void testConvertDateInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            DateConverter.convertDate("12-01-2023", "invalid-format", "yyyy-MM-dd");
        });
    }

    @Test
    void testConvertDateNullInput() {
        assertThrows(NullPointerException.class, () -> {
            DateConverter.convertDate(null, "dd-MM-yyyy", "yyyy-MM-dd");
        });
    }

    @Test
    void testDetectDateFormatInvalidDate() {
        String result = DateConverter.detectDateFormat("invalid-date");
        assertNull(result);
    }

    @Test
    void positiveTest_detectDateFormat() {
        String dateStr = "01 January 2023";
        String expectedFormat = "dd MMMM yyyy";

        String result = DateConverter.detectDateFormat(dateStr);

        assertEquals(expectedFormat, result);
    }

    @Test
    void positiveTest_detectDateFormat_null() {
        String dateStr = "2023-12-12T12:00:00";
        String result = DateConverter.detectDateFormat(dateStr);
        assertNull(result);
    }

    @Test
    void negativeTest_convertDate_invalidInput() {
        String inputDate = "2023-15-01"; // Invalid date

        assertThrows(DateTimeParseException.class, () ->
                DateConverter.convertDate(inputDate, "yyyy-MM-dd", "dd-MM-yyyy"));
    }

    @Test
    void negativeTest_convertDate_invalidFormat() {
        String inputDate = "01-01-2023";
        String inputFormat = "MM/dd/yyyy";

        assertThrows(DateTimeParseException.class, () ->
                DateConverter.convertDate(inputDate, inputFormat, "yyyy-MM-dd"));
    }


}