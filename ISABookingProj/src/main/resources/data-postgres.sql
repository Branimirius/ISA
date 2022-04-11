

insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active) values ('Tony', 'Stark', 'nekimejl', '123', '43434', 'adresaNeka', 'drzava', 'grad', 'ADMIN', true);
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active) values ('Miroslav', 'Ribar', 'ribar@gmail.com', '123', '45434', 'Mirosaljci', 'Srbija', 'Arilje', 'INSTRUCTOR', true);
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active) values ('Marko', 'Antovic', 'antovic@gmail.com', '123', '45664', 'Pilatovici', 'Srbija', 'Pozega', 'BOAT_OWNER', true);
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active) values ('Krstoljub', 'Jakovljevic', 'krstoljub@gmail.com', '123', '45994', 'Prilipac', 'Srbija', 'Pozega', 'HOUSE_OWNER', true);
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active) values ('Dunja', 'Dunjic', 'dunja@gmail.com', '123', '45994', 'Nemanjina', 'Srbija', 'Pozega', 'CLIENT', true);
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active) values ('Jovana', 'Jovanovic', 'jovanovic@gmail.com', '123', '45094', 'Bakionica', 'Srbija', 'Pozega', 'CLIENT', true);
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active) values ('Milenko', 'Bukvic', 'bukvic@gmail.com', '123', '45664', 'Pilatovici', 'Srbija', 'Pozega', 'BOAT_OWNER', false);

insert into fishing_class (user_id, adress, description, instructor_bio, max_cap, rules, equipment, menu, cancel_conditions) values (2, 'Narodnog Fronta 14, Novi Sad', 'Veoma lepo', 'Dobar covek', 5, 'Nema pravila', 'Sva oprema', 'Pecanje 50e, Obuka i pecanje 100e', 'Vracamo novac');

insert into fishing_class_reservations (user_id, start, end_time, duration, location, max_cap, extra_offers, price, class_id) values (5, TO_TIMESTAMP('2022-02-09 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-10 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), 60, 'Narodnog Fronta 14, Novi Sad', 5, 'Imamo i camac', 100, 1 );
insert into fishing_class_reservations (user_id, start, end_time, duration, location, max_cap, extra_offers, price, class_id) values (0, TO_TIMESTAMP('2022-02-09 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-10 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), 60, 'Narodnog Fronta 14, Novi Sad', 5, 'Imamo i camac', 100, 1 );

insert into instructor_availabilities (user_id, start, end_time) values (2, TO_TIMESTAMP('2022-05-09 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-05-10 15:00:00', 'YYYY-MM-DD HH24:MI:SS'));
insert into instructor_availabilities (user_id, start, end_time) values (2, TO_TIMESTAMP('2022-04-09 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-04-10 15:00:00', 'YYYY-MM-DD HH24:MI:SS'));

insert into fishing_reviews(client, instructor, comment, report, show_up) values (1, 2, 'jedan', true, false);
