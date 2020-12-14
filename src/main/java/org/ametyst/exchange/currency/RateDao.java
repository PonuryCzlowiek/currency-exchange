package org.ametyst.exchange.currency;

import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class RateDao extends GenericDao<Rate> {
    
    @Override
    public Rate save(Rate object) {
        return super.save(object);
    }

    public List<Rate> getAll() {
        return super.getAll(Rate.class);
    }
}
