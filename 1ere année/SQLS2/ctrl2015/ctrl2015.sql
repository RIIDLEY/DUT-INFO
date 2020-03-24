DROP TABLE IF EXISTS employe;

CREATE TABLE employe
 (
 enom varchar unique,
 -- nom de l’employe
 eId int primary key,
 -- numero de l’employe
 emanager int references employe(eid),
 -- manager de l’employe
 egrade varchar,
 -- grade de l’employe
 esalaire money
 -- salaire de l’employe
);
\copy employe FROM employe.txt;
