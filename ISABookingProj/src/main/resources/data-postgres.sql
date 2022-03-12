insert into student (index_number, first_name, last_name) values ('ra1-2014', 'Marko', 'Marković');
insert into student (index_number, first_name, last_name) values ('ra2-2014', 'Milan', 'Milanović');
insert into student (index_number, first_name, last_name) values ('ra3-2014', 'Ivana', 'Ivanović');
insert into student (index_number, first_name, last_name) values ('ra4-2014', 'Bojan', 'Bojanović');
insert into student (index_number, first_name, last_name) values ('ra5-2014', 'Pera', 'Perić');
insert into student (index_number, first_name, last_name) values ('ra6-2014', 'Zoran', 'Zoranović');
insert into student (index_number, first_name, last_name) values ('ra7-2014', 'Bojana', 'Bojanović');
insert into student (index_number, first_name, last_name) values ('ra8-2014', 'Milana', 'Milanović');
insert into student (index_number, first_name, last_name) values ('ra9-2014', 'Jovana', 'Jovanić');

insert into course (name) values ('Matematika');
insert into course (name) values ('Osnove programiranja');
insert into course (name) values ('Objektno programiranje');

insert into teacher (first_name, last_name) values ('Strahinja', 'Simić');
insert into teacher (first_name, last_name) values ('Marina', 'Antić');
insert into teacher (first_name, last_name) values ('Siniša', 'Branković');

insert into teaching (course_id, teacher_id) values (1, 1);
insert into teaching (course_id, teacher_id) values (1, 2);
insert into teaching (course_id, teacher_id) values (2, 2);
insert into teaching (course_id, teacher_id) values (3, 3);

insert into exam (student_id, course_id, date, grade) values (1, 1, '2016-02-01', 9);
insert into exam (student_id, course_id, date, grade) values (1, 2, '2016-04-19', 8);
insert into exam (student_id, course_id, date, grade) values (2, 1, '2016-02-01', 10);
insert into exam (student_id, course_id, date, grade) values (2, 2, '2016-04-19', 10);

insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type) values ('Tony', 'Stark', 'nekimejl', '123', '43434', 'adresaNeka', 'drzava', 'grad', 'ADMIN');
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type) values ('Miroslav', 'Ribar', 'ribar@gmail.com', '123', '45434', 'Mirosaljci', 'Srbija', 'Arilje', 'INSTRUCTOR');
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type) values ('Marko', 'Antovic', 'antovic@gmail.com', '123', '45664', 'Pilatovici', 'Srbija', 'Pozega', 'BOAT_OWNER');
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type) values ('Krstoljub', 'Jakovljevic', 'krstoljub@gmail.com', '123', '45994', 'Prilipac', 'Srbija', 'Pozega', 'HOUSE_OWNER');
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type) values ('Dunja', 'Dunjic', 'dunja@gmail.com', '123', '45994', 'Nemanjina', 'Srbija', 'Pozega', 'CLIENT');

insert into fishing_class (user_id, adress, description, instructor_bio, max_cap, rules, equipment, menu, cancel_conditions) values (2, 'Narodnog Fronta 14, Novi Sad', 'Veoma lepo', 'Dobar covek', 5, 'Nema pravila', 'Sva oprema', 'Pecanje 50e, Obuka i pecanje 100e', 'Vracamo novac');

insert into fishing_class_images (image, class_id) values (null, 1);

insert into fishing_class_reservations (start, end_time, duration, location, max_cap, extra_offers, price, class_id) values (TO_TIMESTAMP('2022-02-09 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-10 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), 60, 'Narodnog Fronta 14, Novi Sad', 5, 'Imamo i camac', 100, 1 );
