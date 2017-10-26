package com.github.sandor_balazs.example.spring_data_postgresql_refcursor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityMovementRepositoryIntTest {

    @Autowired
    private EntityMovementRepository entityMovementRepository;

    @Test
    public void nearbyEntities() throws Exception {
        // When
        List<EntityMovement> entityMovements = entityMovementRepository
                .nearByEntities("location", 5.0);

        // Then
        assertEquals(entityMovements.get(0), new EntityMovement(1L, "New York", 1));
        assertEquals(entityMovements.get(1), new EntityMovement(2L, "Zurich", 3));
        assertEquals(entityMovements.get(2), new EntityMovement(3L, "San Francisco", 2));
    }
}
