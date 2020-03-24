CREATE OR REPLACE FUNCTION nboccur(t int [],n int)
RETURNS INT AS
$$
DECLARE
  nb_occ int;
  taille int;
BEGIN
  taille := array_upper(t,1);
  nb_occ := 0;
  FOR i IN 1..taille LOOP
    IF t[i] = n THEN
      nb_occ = nb_occ + 1;
    END IF;
  END LOOP;
  RETURN nb_occ;
END;
$$ LANGUAGE PLPGSQL;

CREATE OR REPLACE FUNCTION empsal(id int)
RETURNS MONEY AS
$$
DECLARE
  res MONEY;
BEGIN
select salaire INTO res FROM employe WHERE emploid = id;
RETURN res;
END;
$$LANGUAGE PLPGSQL

CREATE OR REPLACE FUNCTION tribulle(inout t int [])
RETURNS INT AS
$$
DECLARE
  taille INT;
  tmp INT;
BEGIN
  taille := array_upper(t,1);
  FOR i in 1..taille LOOP;
    FOR J in 1.taille LOOP;
     IF t[i]< t[j] THEN
      tmp := t[i];
      t[i] := t[j];
      t[j] := tmp;
    END IF;
  END LOOP;
END LOOP;
END;
$$ LANGUAGE PLPGSQL;

SELECT * FROM tribulle('{1,2,3,1,4,5,6}')
