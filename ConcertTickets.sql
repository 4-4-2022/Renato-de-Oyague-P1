

-- DDL
drop table concert;
create table if not exists concert(
	concert_id integer unique not null,
	concert_artist varchar references venue(venue_artist),
	concert_seats varchar not null,
	concert_price integer not null,
	concert_stock integer not null
);

drop table venue;
create table if not exists venue(
	venue_id integer primary key,
	venue_month varchar not null,
	venue_day integer not null,
	venue_artist varchar unique not null,
	venue_url varchar not null
);

drop table concert_ticket;
create table if not exists concert_ticket(
	venue_id integer references venue(venue_id),
	venue_artist varchar references venue(venue_artist),
	concert_id integer references concert(concert_id),
	primary key(venue_id, venue_artist, concert_id)
);

drop table quantity;
create table if not exists quantity(
	quantity integer not null,
	venue_id integer not null references venue(venue_id),
	concert_id integer references concert(concert_id),
	orders_id integer not null references orders(orders_id)
);

drop table orders;
create table if not exists orders(
	orders_id integer unique not null,
	orders_user_id integer not null,
	orders_status varchar not null
);

-- DML
insert into concert values(1, 'Foo-Fighters', 'Lawn', 50, 100);
insert into concert values(2, 'Foo-Fighters','Upper Seats', 250, 75);
insert into concert values(3, 'Foo-Fighters','Lower Seats', 450, 50);
insert into concert values(4, 'Foo-Fighters','Front Seats', 600, 25);
insert into concert values(5, 'The-Lumineers', 'Lawn', 115, 100);
insert into concert values(6, 'The-Lumineers', 'Upper Seats', 327, 75);
insert into concert values(7, 'The-Lumineers', 'Lower Seats', 631, 50);
insert into concert values(8, 'The-Lumineers', 'Front Seats', 907, 25);
insert into concert values(9, 'Robert-Plant','Lawn', 75, 100);
insert into concert values(10, 'Robert-Plant','Upper Seats', 257, 75);
insert into concert values(11, 'Robert-Plant','Lower Seats', 347, 50);
insert into concert values(12, 'Robert-Plant', 'Front Seats', 2857, 25);
insert into concert values(13, 'Paul-McCartney','Lawn', 238, 100);
insert into concert values(14, 'Paul-McCartney','Upper Seats', 1043, 75);
insert into concert values(15, 'Paul-McCartney','Lower Seats', 3756, 50);
insert into concert values(16, 'Paul-McCartney','Front Seats', 5212, 25);
insert into concert values(17, 'The-Black-Keys','Lawn', 48, 100);
insert into concert values(18, 'The-Black-Keys','Upper Seats', 193, 75);
insert into concert values(19, 'The-Black-Keys','Lower Seats', 296, 50);
insert into concert values(20, 'The-Black-Keys','Front Seats', 355, 25);
insert into concert values(21, 'Chris-Stapleton', 'Lawn', 100, 100);
insert into concert values(22, 'Chris-Stapleton', 'Upper Seats', 293, 75);
insert into concert values(23, 'Chris-Stapleton', 'Lower Seats', 449, 50);
insert into concert values(24, 'Chris-Stapleton', 'Front Seats', 1020, 25);
insert into concert values(25, 'Blondie', 'Lawn', 98, 100);
insert into concert values(26, 'Blondie', 'Upper Seats', 246, 75);
insert into concert values(27, 'Blondie', 'Lower Seats', 372, 50);
insert into concert values(28, 'Blondie', 'Front Seats', 418, 25);
insert into concert values(29, 'The-Killers', 'Lawn', 145, 100);
insert into concert values(30, 'The-Killers', 'Upper Seats', 379, 75);
insert into concert values(31, 'The-Killers', 'Lower Seats', 1462, 50);
insert into concert values(32, 'The-Killers', 'Front Seats', 2762, 25);

insert into venue values(1, 'May', 16, 'Foo-Fighters', 'http://localhost:8081/concert?artist=Foo-Fighters');
insert into venue values(2,'May', 25, 'The-Lumineers', 'http://localhost:8081/concert?artist=The-Lumineers');
insert into venue values(3, 'June', 11, 'Robert-Plant', 'http://localhost:8081/concert?artist=Robert-Plant');
insert into venue values(4, 'June', 12, 'Paul-McCartney', 'http://localhost:8081/concert?artist=Paul-McCartney');
insert into venue values(5, 'July', 25, 'The-Black-Keys', 'http://localhost:8081/concert?artist=The-Black-Keys');
insert into venue values(7, 'August', 20, 'Chris-Stapleton', 'http://localhost:8081/concert?artist=Chris-Stapleton');
insert into venue values(8, 'August', 21, 'Blondie', 'http://localhost:8081/concert?artist=Blondie');
insert into venue values(9, 'September', 29, 'The-Killers', 'http://localhost:8081/concert?artist=The-Killers');

insert into concert_ticket values(1, 'Foo-Fighters', 1);
insert into concert_ticket values('Foo-Fighters', 4);
insert into concert_ticket values('The-Lumineers', 6);
insert into concert_ticket values('The-Lumineers', 8);
insert into concert_ticket values('Robert-Plant', );
insert into concert_ticket values('Robert-Plant', );
insert into concert_ticket values('Paul-McCartney');
insert into concert_ticket values('The-Black-Keys');
insert into concert_ticket values('Chris-Stapleton');
insert into concert_ticket values('Blondie');
insert into concert_ticket values('The-Killers');

insert into quantity values(1);



select * from concert t;
select * from venue v;
select * from concert_ticket ct;
select * from quantity q;
select * from orders o;


commit;
begin transaction;