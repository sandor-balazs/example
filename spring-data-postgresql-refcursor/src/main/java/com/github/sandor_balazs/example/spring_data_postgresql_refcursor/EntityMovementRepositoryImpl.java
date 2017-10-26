package com.github.sandor_balazs.example.spring_data_postgresql_refcursor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class EntityMovementRepositoryImpl implements EntityMovementRepositoryWithProcedure {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<EntityMovement> nearByEntities(String location, double radius) {
        StoredProcedureQuery nearByEntities = em.createNamedStoredProcedureQuery("nearbyEntities");
        nearByEntities.setParameter(2, location);
        nearByEntities.setParameter(3, radius);
        return nearByEntities.getResultList();
    }
}
