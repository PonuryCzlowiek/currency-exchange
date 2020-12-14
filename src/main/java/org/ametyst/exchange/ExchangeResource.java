package org.ametyst.exchange;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
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
        return Response.ok().entity(rateService.getExchangeRateByDate(parse)).build();
    }

    @GET
    @Produces("application/json")
    @Path("exchange")
    public Response getAll() {
        return Response.ok().entity(rateService.getAll()).build();
    }
}
