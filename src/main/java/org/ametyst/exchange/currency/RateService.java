package org.ametyst.exchange.currency;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.ametyst.exchange.external.frankfurter.FrankfurterApiCaller;
import org.ametyst.exchange.external.frankfurter.FrankfurterRateResponse;

@Stateless
public class RateService {
    private static final String FROM = "EUR";
    private static final String TO = "USD";

    @Inject
    private RateDao rateDao;
    private final FrankfurterApiCaller frankfurterApiCaller = new FrankfurterApiCaller();

    public Rate getExchangeRateByDate(String dateAsString) throws URISyntaxException, IOException, InterruptedException {
        FrankfurterRateResponse frankfurterRateResponse = frankfurterApiCaller.getFrankfurterRateResponse(dateAsString, FROM, TO);
        Rate rate = getRate(frankfurterRateResponse);
        rateDao.save(rate);
        return rate;
    }

    private Rate getRate(FrankfurterRateResponse frankfurterRateResponse) {
        Rate rate = new Rate();
        rate.setFrom(FROM);
        rate.setTo(TO);
        rate.setRateDate(frankfurterRateResponse.getDate());
        rate.setSearchTimestamp(new Date());
        rate.setRate(frankfurterRateResponse.getRates().get(TO));
        return rate;
    }

    private List<Rate> getAll() {
        return rateDao.getAll();
    }

    public List<RateDto> getAllAsDtos() {
        return getAll()
            .stream()
            .map(r -> new RateDto(r.getRate(), r.getRateDate(), r.getSearchTimestamp()))
            .collect(Collectors.toList());
    }
}
