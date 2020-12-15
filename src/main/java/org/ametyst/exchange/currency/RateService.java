package org.ametyst.exchange.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.ametyst.exchange.external.frankfurter.FrankfurterRateResponse;

@Stateless
public class RateService {
    private static final String FROM = "EUR";
    private static final String TO = "USD";

    @Inject
    private RateDao rateDao;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final HttpClient httpClient = HttpClient.newBuilder().build();

    public Rate getExchangeRateByDate(String dateAsString) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .GET()
            .uri(new URI("https://api.frankfurter.app/" + dateAsString + "?from=" + FROM + "&to=" + TO))
            .build();
        HttpResponse<InputStream> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofInputStream());
        FrankfurterRateResponse frankfurterRateResponse = objectMapper.readerFor(FrankfurterRateResponse.class).readValue(httpResponse.body());
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

    public List<Rate> getAll() {
        return rateDao.getAll();
    }
}
