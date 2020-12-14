package org.ametyst.exchange;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.ametyst.exchange.coverters.date.DateFormat;
import org.ametyst.exchange.currency.Rate;
import org.ametyst.exchange.currency.RateService;

@Path("api")
public class ExchangeResource {
    @Inject
    private RateService rateService;

    @GET
    @Produces("application/json")
    @Path("/exchange/{date}")
    public Response getByDate(@PathParam("date") @DateFormat Date targetDate) throws InterruptedException, IOException, URISyntaxException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return Response.ok()
            .entity(rateService.getExchangeRateByDate(simpleDateFormat.format(targetDate)).getCurrency_rate())
            .build();
    }

    @GET
    @Produces("application/json")
    @Path("exchange")
    public Response getAll() {
        return Response.ok()
            .entity(rateService
                .getAll()
                .stream()
                .sorted(Comparator.comparing(Rate::getSearch_date))
                .collect(Collectors.toList()))
            .build();
    }
}
