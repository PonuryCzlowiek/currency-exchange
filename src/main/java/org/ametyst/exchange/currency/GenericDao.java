package org.ametyst.exchange.currency;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDao<T> {

    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;

    T save(T object) {
//        entityManager.persist(object);
        return object;
    }

    protected List<T> getAll(Class<T> entityClass) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<T> cq = cb.createQuery(entityClass);
//        Root<T> rootEntry = cq.from(entityClass);
//        CriteriaQuery<T> all = cq.select(rootEntry);
//        TypedQuery<T> allQuery = entityManager.createQuery(all);
//        return allQuery.getResultList();
        return new ArrayList<>();
    }
}
