# Using REF_CURSOR returning PostgreSQL function with Spring Data

## Prerequisites
Setup PostgreSQL database on localhost.

Create example table:
```sql
CREATE TABLE entity_movement (
  id       INT8 NOT NULL,
  location VARCHAR(255),
  radius   INT4,
  PRIMARY KEY (id)
);
```

Add example data:
```sql
INSERT INTO public.entity_movement (id, location, radius) VALUES (1, 'New York', 1.0);
INSERT INTO public.entity_movement (id, location, radius) VALUES (2, 'Zurich', 3.0);
INSERT INTO public.entity_movement (id, location, radius) VALUES (3, 'San Francisco', 2.0);
```

Create stored function that returns a REF_CURSOR:
```sql
CREATE OR REPLACE FUNCTION public.nearby_entities(
  location CHARACTER VARYING,
  radius   DOUBLE PRECISION)
  RETURNS REFCURSOR
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE ref REFCURSOR;
BEGIN
  OPEN ref FOR SELECT *
               FROM public.entity_movement;
  RETURN ref;
END
```

Setup database connection in `application.properties`.

_Note: the database init script and application properties can be found under the resources folder:_

```shell
src
`-- main
    `-- resources
        |-- application.properties
        `-- init.sql
```

## Building the application
```shell
gradle build
```
