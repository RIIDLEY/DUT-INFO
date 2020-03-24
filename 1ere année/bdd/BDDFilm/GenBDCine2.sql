-- \i GenBDCine.sql
SET datestyle TO "DMY" ;
SET datestyle TO "SQL" ;

drop table IF EXISTS jouer;
drop table IF EXISTS projection;
drop table IF EXISTS film;
drop table IF EXISTS individu;
drop table IF EXISTS cinema;

create table individu (
    num_individu integer primary key, 
    nom varchar(64) NOT NULL, 
    prenom varchar(64));

create table film (
    num_film integer primary key, 
    num_realisateur integer references individu, 
    titre varchar(128) NOT NULL, 
    genre varchar(64) DEFAULT 'Drame',
    annee date CHECK(annee>'01/01/1929'),
    CONSTRAINT realisateur_film unique (num_realisateur, titre, annee)
    );

create table cinema (
    num_cinema integer primary key, 
    nom varchar(64), 
    adresse varchar(128));

create table jouer (
    num_acteur integer references individu, 
    num_film integer references film,
    role varchar(128),
    primary key (num_acteur, num_film),
    UNIQUE(num_film,role)
    );

create table projection (
    num_cinema integer references cinema, 
    num_film integer references film,
    jour date,
    primary key (num_cinema, num_film, jour));

\copy individu from individu.txt
\copy cinema from cinema.txt
\copy film from film.txt
\copy jouer from jouer.txt
\copy projection from projection.txt




