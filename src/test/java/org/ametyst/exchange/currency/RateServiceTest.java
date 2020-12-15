package org.ametyst.exchange.currency;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RateServiceTest {
    @Mock
    RateDao rateDao;

    @InjectMocks
    RateService rateService;

    @Test
    void shouldMapEntitiesToDtos() {
        // arrange
        Rate firstRate = new Rate();
        firstRate.setRateDate(new Date(943311600000L));
        firstRate.setRate(12.0);
        firstRate.setSearchTimestamp(new Date());
        Rate secondRate = new Rate();
        secondRate.setRateDate(new Date(953311600000L));
        secondRate.setRate(16.0);
        firstRate.setSearchTimestamp(new Date(new Date().getTime() - 5000));
        when(rateDao.getAll()).thenReturn(Arrays.asList(firstRate, secondRate));

        // act
        List<RateDto> allAsDtos = rateService.getAllAsDtos();

        // assert
        assertEquals(firstRate.getRateDate(), allAsDtos.get(0).getRateDate());
        assertEquals(firstRate.getRate(), allAsDtos.get(0).getRate());
        assertEquals(firstRate.getSearchTimestamp(), allAsDtos.get(0).getSearchTimestamp());
        assertEquals(secondRate.getRateDate(), allAsDtos.get(1).getRateDate());
        assertEquals(secondRate.getRate(), allAsDtos.get(1).getRate());
        assertEquals(secondRate.getSearchTimestamp(), allAsDtos.get(1).getSearchTimestamp());
    }
}