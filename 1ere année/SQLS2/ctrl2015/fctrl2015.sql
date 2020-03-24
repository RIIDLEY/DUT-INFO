DROP FUNCTION empsal(varchar);
DROP FUNCTION employed(int);
DROP FUNCTION superieur(int);

CREATE OR REPLACE FUNCTION empsal(a varchar)
RETURNS money AS
$$
  SELECT esalaire FROM employe WHERE enom=a;
$$ LANGUAGE SQL;

CREATE OR REPLACE FUNCTION employed(a int)
RETURNS setof employe AS
$$
  SELECT * FROM employe WHERE emanager=a;
$$ LANGUAGE SQL;

SELECT * FROM employed(7698);

CREATE OR REPLACE FUNCTION superieur(a int)
RETURNS varchar AS
$$
  SELECT enom FROM employe WHERE eid = a;
$$ LANGUAGE SQL;
