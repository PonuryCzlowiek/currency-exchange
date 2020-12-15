package org.ametyst.exchange.currency;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Rate {

    @Id
    @Column(length = 255)
    private String id;
    @Column(name = "from_currency")
    private String from;
    @Column(name = "to_currency")
    private String to;
    @Column(name = "currency_rate")
    private Double rate;
    @Column(name = "rate_date")
    private Date rateDate;
    @Column(name = "search_timestamp")
    private Date searchTimestamp;

    public Rate() {
        id = UUID.randomUUID().toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getRateDate() {
        return rateDate;
    }

    public void setRateDate(Date date) {
        this.rateDate = date;
    }

    public Date getSearchTimestamp() {
        return searchTimestamp;
    }

    public void setSearchTimestamp(Date searchTimestamp) {
        this.searchTimestamp = searchTimestamp;
    }
}
