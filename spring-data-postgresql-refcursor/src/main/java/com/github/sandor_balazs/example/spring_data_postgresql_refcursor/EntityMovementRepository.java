package com.github.sandor_balazs.example.spring_data_postgresql_refcursor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityMovementRepository extends JpaRepository<EntityMovement, Integer>,
        EntityMovementRepositoryWithProcedure {
}
