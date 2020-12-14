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
    private String from_currency;
    private String to_currency;
    private Double currency_rate;
    private Date search_date;
    private Date search_timestamp;

    public Rate() {
        id = UUID.randomUUID().toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getFrom_currency() {
        return from_currency;
    }

    public void setFrom_currency(String from) {
        this.from_currency = from;
    }

    public String getTo_currency() {
        return to_currency;
    }

    public void setTo_currency(String to) {
        this.to_currency = to;
    }

    public Double getCurrency_rate() {
        return currency_rate;
    }

    public void setCurrency_rate(Double rate) {
        this.currency_rate = rate;
    }

    public Date getSearch_date() {
        return search_date;
    }

    public void setSearch_date(Date date) {
        this.search_date = date;
    }

    public Date getSearch_timestamp() {
        return search_timestamp;
    }

    public void setSearch_timestamp(Date searchTimestamp) {
        this.search_timestamp = searchTimestamp;
    }
}
