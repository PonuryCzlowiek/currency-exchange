package org.ametyst.exchange.external.frankfurter;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class FrankfurterApiCaller {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final HttpClient httpClient = HttpClient.newBuilder().build();

    public FrankfurterRateResponse getFrankfurterRateResponse(String dateAsString, String from, String to) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .GET()
            .uri(new URI("https://api.frankfurter.app/" + dateAsString + "?from=" + from + "&to=" + to))
            .build();
        HttpResponse<InputStream> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofInputStream());
        return objectMapper.readerFor(FrankfurterRateResponse.class)
            .readValue(httpResponse.body());
    }

}
