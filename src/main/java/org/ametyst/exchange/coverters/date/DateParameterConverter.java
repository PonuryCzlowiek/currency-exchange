package org.ametyst.exchange.coverters.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ParamConverter;

public class DateParameterConverter implements ParamConverter<Date> {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

    @Override
    public Date fromString(String string) {
        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException ex) {
            throw new WebApplicationException(ex);
        }
    }

    @Override
    public String toString(Date date) {
        return new SimpleDateFormat(DATE_FORMAT).format(date);
    }
}