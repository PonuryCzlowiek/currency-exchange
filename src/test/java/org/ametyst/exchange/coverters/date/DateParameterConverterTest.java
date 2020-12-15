package org.ametyst.exchange.coverters.date;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import org.junit.jupiter.api.Test;

class DateParameterConverterTest {

    private final DateParameterConverter dateParameterConverter = new DateParameterConverter();

    @Test
    void shouldParseStringToDate() {
        // arrange
        String dateAsString = "1999-11-23";

        // act
        Date date = dateParameterConverter.fromString(dateAsString);

        // assert
        assertEquals(new Date(943311600000L), date);
    }

    @Test
    void shouldParseDateToString() {
        // arrange
        Date date = new Date(943311600000L);

        // act
        String dateAsString = dateParameterConverter.toString(date);

        // assert
        assertEquals("1999-11-23", dateAsString);
    }
}