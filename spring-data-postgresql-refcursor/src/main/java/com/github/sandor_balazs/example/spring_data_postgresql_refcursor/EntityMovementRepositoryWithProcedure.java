package com.github.sandor_balazs.example.spring_data_postgresql_refcursor;

import java.util.List;

public interface EntityMovementRepositoryWithProcedure {
    List<EntityMovement> nearByEntities(String location, double radius);
}
