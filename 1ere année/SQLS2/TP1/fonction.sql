CREATE OR REPLACE FUNCTION permute(inout a int,inout b int)
AS
$$
  SELECT(b,a);
$$ LANGUAGE SQL;
