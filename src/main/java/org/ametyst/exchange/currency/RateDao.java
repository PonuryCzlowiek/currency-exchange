package org.ametyst.exchange.currency;

import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class RateDao extends GenericDao<Rate> {

    public RateDao() {
        super(Rate.class);
    }

    @Override
    public Rate save(Rate object) {
        return super.save(object);
    }

    public List<Rate> getAll() {
        return super.getAll();
    }
}
