CREATE TABLE entity_movement (
  id       INT8 NOT NULL,
  location VARCHAR(255),
  radius   INT4,
  PRIMARY KEY (id)
);

INSERT INTO public.entity_movement (id, location, radius) VALUES (1, 'New York', 1.0);
INSERT INTO public.entity_movement (id, location, radius) VALUES (2, 'Zurich', 3.0);
INSERT INTO public.entity_movement (id, location, radius) VALUES (3, 'San Francisco', 2.0);

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
$BODY$;
