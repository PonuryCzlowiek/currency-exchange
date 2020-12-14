package org.ametyst.exchange;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class DateParameterConverterProvider implements ParamConverterProvider {

    @SuppressWarnings("unchecked")
    @Override
    public <T> ParamConverter<T> getConverter(final Class<T> rawType, final Type genericType, final Annotation[] annotations) {
        if (Date.class.equals(rawType)) {
            for (Annotation annotation : annotations) {
                if (DateFormat.class.equals(annotation.annotationType())) {
                    return (ParamConverter<T>) new DateParameterConverter();
                }
            }
        }
        return null;
    }
}
