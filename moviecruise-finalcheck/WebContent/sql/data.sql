use movie_cruiser;

/*script to insert data into movies table-TYUC001*/
insert into movies values(1,'Avatar',2356787934,'Yes','2017-03-15','Science Fiction','Yes'),
(2,'The Avenger',1518812988,'Yes','2017-12-23','Superhero','No'),
(3,'Titanic',2187463844,'Yes','2017-08-21','Romance','No'),
(4,'Jurrasic World',1671713208,'No','2017-07-02','Science Fiction','Yes'),
(5,'Avengers: Endgame',2750760348,'Yes','2022-02-11','Superhero','Yes'); 

/*script to fetch data from movies table-TYUC001*/
select mo_id, mo_title,mo_box_office,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser from movie; 


/*script to fetch data from movies table-TYUC002*/
select*from movies where mo_date_of_launch <=now() and mo_active='Yes';

/*script to fetch data from movies table-TYUC003*/
select*from movies where mo_id=1;

/*script to edit data in menu_item table-TYUC003*/
update movies set mo_title='hit man',mo_box_office=5671545344,mo_active='Yes',mo_date_of_launch='2020=02-12',mo_genre='Super Hero',mo_has_teaser='No' where mo_id=3;

/*script to insert data in user table-TYUC004*/
insert into user values(1,'Ays'),(2,'Naddy');
/*script to insert data in favorite table-TYUC004*/
insert into favorites values(1,1,1),(2,1,3),(3,1,5);


/*script to fetch data from movies table-TYUC005*/
select mi.mo_id,mi.mo_title,mi.mo_box_office,mi.mo_active,mi.mo_date_of_launch,mi.mo_genre,mi.mo_has_teaser from movies mi inner join favorites fv on mi.mo_id=fv.fe_mo_id and fv.fe_us_id;
/*script to get total price of all menu items in cart-TYUC005*/
select count(mo_box_office) from movies inner join favorites on movies.mo_id=favorites.fe_mo_id and favorites.fe_us_id;


/*script to remove data from cart-TYUC006*/
delete from favorites where fe_us_id=1 and fe_mo_id=1;
