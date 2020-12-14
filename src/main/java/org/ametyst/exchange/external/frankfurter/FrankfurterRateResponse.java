package org.ametyst.exchange.external.frankfurter;

import java.util.Date;
import java.util.Map;

public class FrankfurterRateResponse {
    private int amount;
    private String base;
    private Date date;
    private Map<String, Double> rates;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    //    amount	1
//    base	"EUR"
//    date	"2020-12-11"
//    rates
//    USD	1.2127
}
