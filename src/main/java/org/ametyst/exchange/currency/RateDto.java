package org.ametyst.exchange.currency;

import java.util.Date;

public class RateDto {
    private Double rate;
    private Date rateDate;
    private Date searchTimestamp;
    
    public RateDto(Double rate, Date rateDate, Date searchTimestamp) {
        this.rate = rate;
        this.rateDate = rateDate;
        this.searchTimestamp = searchTimestamp;
    }

    public Double getRate() {
        return rate;
    }

    public Date getRateDate() {
        return rateDate;
    }

    public Date getSearchTimestamp() {
        return searchTimestamp;
    }
}
