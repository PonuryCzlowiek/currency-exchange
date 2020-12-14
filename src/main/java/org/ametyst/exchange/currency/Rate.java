package org.ametyst.exchange.currency;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Rate {

    @Id
    private UUID id;
    private String from;
    private String to;
    private Double rate;
    private Date date;
    private Date searchTimestamp;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getSearchTimestamp() {
        return searchTimestamp;
    }

    public void setSearchTimestamp(Date searchTimestamp) {
        this.searchTimestamp = searchTimestamp;
    }
}
