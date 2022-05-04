

-- DDL
drop table concert;
create table if not exists concert(
	concert_artist varchar references venue(venue_artist),
	concert_seats varchar not null,
	concert_price integer not null
);

drop table venue;
create table if not exists venue(
	venue_month varchar not null,
	venue_day integer not null,
	venue_artist varchar primary key,
	venue_url varchar not null
);

drop table concert_ticket;
create table if not exists concert_ticket(
	--venue_month varchar references venue(venue_month),
	--venue_day integer references venue(venue_day),
	venue_artist varchar references venue(venue_artist),
	--concert_seats varchar references concert(concert_seats),
	--concert_price integer references concert(concert_price)
	primary key(venue_artist)
);

-- DML
insert into concert values('Foo-Fighters', 'Lawn', 50);
insert into concert values('Foo-Fighters','Upper Seats', 250);
insert into concert values('Foo-Fighters','Lower Seats', 450);
insert into concert values('Foo-Fighters','Front Seats', 600);
insert into concert values('The-Lumineers', 'Lawn', 115);
insert into concert values('The-Lumineers', 'Upper Seats', 327);
insert into concert values('The-Lumineers', 'Lower Seats', 631);
insert into concert values('The-Lumineers', 'GA Floor', 907);
insert into concert values('Robert-Plant','Lawn', 75);
insert into concert values('Robert-Plant','Upper Seats', 257);
insert into concert values('Robert-Plant','Lower Seats', 347);
insert into concert values('Robert-Plant', 'Front Seats', 2857);
insert into concert values('Paul-McCartney','Lawn', 238);
insert into concert values('Paul-McCartney','Upper Seats', 1043);
insert into concert values('Paul-McCartney','Lower Seats', 3756);
insert into concert values('Paul-McCartney','Front Seats', 5212);
insert into concert values('The-Black-Keys','Lawn', 48);
insert into concert values('The-Black-Keys','Upper Seats', 193);
insert into concert values('The-Black-Keys','Lower Seats', 296);
insert into concert values('The-Black-Keys','Front Seats', 355);
insert into concert values('Chris-Stapleton', 'Lawn', 100);
insert into concert values('Chris-Stapleton', 'Upper Seats', 293);
insert into concert values('Chris-Stapleton', 'Lower Seats', 449);
insert into concert values('Chris-Stapleton', 'Front Seats', 1020);
insert into concert values('Blondie', 'Lawn', 98);
insert into concert values('Blondie', 'Upper Seats', 246);
insert into concert values('Blondie', 'Lower Seats', 372);
insert into concert values('Blondie', 'Front Seats', 418);
insert into concert values('The-Killers', 'Lawn', 145);
insert into concert values('The-Killers', 'Upper Seats', 379);
insert into concert values('The-Killers', 'Lower Seats', 1462);
insert into concert values('The-Killers', 'Front Seats', 2762);

insert into venue values('May', 16, 'Foo-Fighters', 'http://localhost:8081/concert?artist=Foo-Fighters');
insert into venue values('May', 25, 'The-Lumineers', 'http://localhost:8081/concert?artist=The-Lumineers');
insert into venue values('June', 11, 'Robert-Plant', 'http://localhost:8081/concert?artist=Robert-Plant');
insert into venue values('June', 12, 'Paul-McCartney', 'http://localhost:8081/concert?artist=Paul-McCartney');
insert into venue values('July', 25, 'The-Black-Keys', 'http://localhost:8081/concert?artist=The-Black-Keys');
insert into venue values('August', 20, 'Chris-Stapleton', 'http://localhost:8081/concert?artist=Chris-Stapleton');
insert into venue values('August', 21, 'Blondie', 'http://localhost:8081/concert?artist=Blondie');
insert into venue values('September', 29, 'The-Killers', 'http://localhost:8081/concert?artist=The-Killers');



select * from concert t;
select * from venue v;
select * from concert_ticket ct;

commit;
begin transaction;