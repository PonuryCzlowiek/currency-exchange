package org.ametyst.exchange.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import org.ametyst.exchange.external.frankfurter.FrankfurterRateResponse;

@LocalBean
public class RateService {

    @Inject
    RateDao rateDao;

    ObjectMapper objectMapper = new ObjectMapper();
    HttpClient httpClient = HttpClient.newBuilder().build();

    public Rate getExchangeRateByDate(String dateAsString) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .GET()
            .uri(new URI("https://api.frankfurter.app/" + dateAsString + "?from=EUR&to=USD"))
            .build();
        HttpResponse<byte[]> send = httpClient.send(httpRequest, BodyHandlers.ofByteArray());
        FrankfurterRateResponse frankfurterRateResponse = objectMapper.readerFor(FrankfurterRateResponse.class).readValue(send.body());
        Rate rate = new Rate();
        rate.setFrom(frankfurterRateResponse.getBase());
        rate.setTo("USD");
        rate.setDate(frankfurterRateResponse.getDate());
        rate.setSearchTimestamp(new Date());
        rate.setRate(frankfurterRateResponse.getRates().get("USD"));
        rateDao.save(rate);
        return rate;
    }

    public List<Rate> getAll() {
        return rateDao.getAll();
    }
}
