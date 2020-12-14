package org.ametyst.exchange;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.ametyst.exchange.currency.Rate;
import org.ametyst.exchange.currency.RateService;

@Path("api")
public class ExchangeResource {
    @Inject
    RateService rateService;

    @GET
    @Produces("application/json")
    @Path("/exchange/{date}")
    public Response hello(@PathParam("date") String targetDate) throws ParseException, InterruptedException, IOException, URISyntaxException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(targetDate);
        return Response.ok().entity(rateService.getExchangeRateByDate(targetDate).getRate()).build();
    }

    @GET
    @Produces("application/json")
    @Path("exchange")
    public Response getAll() {
        List<Rate> all = rateService.getAll();
        List<Rate> collect = all.stream().sorted(Comparator.comparing(Rate::getDate)).collect(Collectors.toList());
        return Response.ok().entity(collect).build();
    }
}
