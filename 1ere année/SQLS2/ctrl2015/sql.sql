/*CREATE FUNCTION somme(a int, b int)
RETURNs int AS
$$
  SELECT(a+b);

$$ LANGUAGE SQL;

CREATE FUNCTION somme2(a int, b int, out c int)
AS
$$
  SELECT(a+b);

$$ LANGUAGE SQL;
*/
CREATE FUNCTION renplace(a int, b int)
AS
$$
  SELECT(a,b);
$$ LANGUAGE SQL;
