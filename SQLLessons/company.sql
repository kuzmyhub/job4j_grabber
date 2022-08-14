CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) 
values (1, 'Micro'), (2, 'SameSung'), (3, 'Pear'),
(4, 'HiWei'), (5, 'Sunny'), (6, 'XP');

insert into person (id, name, company_id)
values (1, 'Jacob', 1), (2, 'Emily', 1),
(3, 'Michael', 1), (4, 'Emma', 1);

insert into person (id, name, company_id)
values (5, 'Joshua', 3), (6, 'Madison', 3),
(7, 'Matthew', 3), (8, 'Olivia', 3);

insert into person (id, name, company_id)
values (9, 'Ethan', 2), (10, 'Hannah', 2),
(11, 'Andrew', 2);

insert into person (id, name, company_id)
values (12, 'Abigail', 4), (13, 'Daniel', 4),
(14, 'Isabella', 4);

insert into person (id, name, company_id)
values (15, 'William', 5), (16, 'Ashley', 5);

insert into person (id, name, company_id)
values (17, 'Nicholas', 6), (18, 'Grace', 6),
(19, 'David', 6), (20, 'Alyssa', 6);

select p.name, c.name from person p
inner join company c on
c.id = p.company_id
where c.name != 'Sunny';

select c.name, count(p.name)
from company c
inner join person p
on c.id = p.company_id
group by c.name
having count(p.name) = (select max(foo.count) from (
select c.name, count(p.name) from company c
inner join person p
on c.id = p.company_id
group by c.name) as foo);


