package com.github.sandor_balazs.example.spring_data_postgresql_refcursor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "entity_movement")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "nearbyEntities",
                procedureName = "nearby_entities",
                resultClasses = { EntityMovement.class },
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class)

                }
        )
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityMovement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String location;
    private Integer radius;
}
