


create table ems (
  nom varchar,
  prenom varchar,
  matiere varchar,
  salle varchar
);
grant select on ems to public;




create or replace function ems_ins(varchar,varchar,varchar,varchar)
returns void as $$
  insert into ems values(case when ($1!='' and upper($1)!='NULL') then $1 end,
          	case when ($2!='' and upper($2)!='NULL') then $2 end,
 		case when ($3!='' and upper($3)!='NULL') then $3 end,
    		case when ($4!='' and upper($4)!='NULL') then $4 end);
$$ language SQL
  SECURITY DEFINER;
grant execute on function ems_ins(varchar,varchar,varchar,varchar) to public;

create or replace function ems_del(tid)
returns void as $$
  delete from ems where ctid=$1;
$$ language SQL
  SECURITY DEFINER;
grant execute on function ems_del(tid) to public;

create or replace function ems_upd(varchar,varchar,varchar,varchar,tid)
returns void as $$
  update ems set 
         nom=case when ($1!='' and upper($1)!='NULL') then $1 end,
         prenom=case when ($2!='' and upper($2)!='NULL') then $2 end,
 	 matiere=case when ($3!='' and upper($3)!='NULL') then $3 end,
    	 salle=	case when ($4!='' and upper($4)!='NULL') then $4 end
  where ctid= $5;
$$ language SQL
  SECURITY DEFINER;
grant execute on function ems_upd(varchar,varchar,varchar,varchar,tid) to public;


