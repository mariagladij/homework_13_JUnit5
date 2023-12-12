package ua.hillel;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ErrorCodeMapperTest {

    ErrorCodeMapper errorCodeMapper = new ErrorCodeMapper();

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 404})
    void shouldReturnNotSupported(Integer code){
        assertEquals("Not Supported", errorCodeMapper.getMessage(code));

    }

    @ParameterizedTest
    @NullSource
    void shouldReturnCannotBeNull(Integer code){
        assertEquals("Cannot be null", errorCodeMapper.getMessage(code));

    }

    @ParameterizedTest
    @MethodSource("errorData")
    void shouldReturnCorrectErrorMessage(Integer code, String expectedMessage){
        assertEquals(expectedMessage, errorCodeMapper.getMessage(code));
    }

    static Stream<Arguments> errorData() {
        return Stream.of(
                Arguments.arguments(100, "Continue"),
                Arguments.arguments(200, "OK"),
                Arguments.arguments(201, "Created"),
                Arguments.arguments(302, "Found"),
                Arguments.arguments(304, "Not Modified")

        );
    }

}