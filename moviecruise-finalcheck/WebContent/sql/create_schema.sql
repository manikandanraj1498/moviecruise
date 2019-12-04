/*script to create movie cruiser database*/
create database if not exists movie_cruiser;


/*script to create change to movie cruiser database*/
use movie_cruiser;


/*script to create user table*/

create table if not exists user(
us_id int auto_increment not null,
us_name varchar(60),
primary key(us_id));

/*script to create movies table*/
create table if not exists movies(
mo_id int auto_increment not null,
mo_title varchar(100),
mo_box_office bigint,
mo_active varchar(3),
mo_date_of_launch date,
mo_genre varchar(45),
mo_has_teaser varchar(3),
primary key(mo_id));


/*script to create favorites table*/
create table if not exists favorites(
fe_id int auto_increment not null,
fe_us_id int,
fe_mo_id int,
primary key(fe_id),
foreign key(fe_us_id) references user(us_id),
foreign key(fe_mo_id) references movies(mo_id)); 


