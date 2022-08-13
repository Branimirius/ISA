

insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active, delete_requested) values ('Tony', 'Stark', 'nekimejl', '$2a$12$f/CV3jLdVkYeETKhdJvenO3ueaKsESVwCnJbMXcTqmFayd0escPya', '43434', 'adresaNeka', 'drzava', 'grad', 'ADMIN', true, false);
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active, delete_requested) values ('Miroslav', 'Ribar', 'ribar@gmail.com', '$2a$12$f/CV3jLdVkYeETKhdJvenO3ueaKsESVwCnJbMXcTqmFayd0escPya', '45434', 'Mirosaljci', 'Srbija', 'Arilje', 'INSTRUCTOR', true, false);
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active, delete_requested) values ('Marko', 'Antovic', 'antovic@gmail.com', '$2a$12$f/CV3jLdVkYeETKhdJvenO3ueaKsESVwCnJbMXcTqmFayd0escPya', '45664', 'Pilatovici', 'Srbija', 'Pozega', 'BOAT_OWNER', true, false);
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active, delete_requested) values ('Miki', 'Mikic', 'miki@gmail.com', '$2a$12$f/CV3jLdVkYeETKhdJvenO3ueaKsESVwCnJbMXcTqmFayd0escPya', '45994', 'Tolstojeva 25', 'Srbija', 'Pozega', 'HOUSE_OWNER', true, false);
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active, delete_requested) values ('Sara', 'Saric', 'sara@gmail.com', '$2a$12$f/CV3jLdVkYeETKhdJvenO3ueaKsESVwCnJbMXcTqmFayd0escPya', '45996', 'Narodnog fronta 5', 'Srbija', 'Novi Sad', 'HOUSE_OWNER', true, false);
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active, delete_requested) values ('Dunja', 'Dunjic', 'dunja@gmail.com', '$2a$12$f/CV3jLdVkYeETKhdJvenO3ueaKsESVwCnJbMXcTqmFayd0escPya', '45994', 'Nemanjina', 'Srbija', 'Pozega', 'CLIENT', true, false);
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active, delete_requested) values ('Jovana', 'Jovanovic', 'jovanovic@gmail.com', '$2a$12$f/CV3jLdVkYeETKhdJvenO3ueaKsESVwCnJbMXcTqmFayd0escPya', '45094', 'Bakionica', 'Srbija', 'Pozega', 'CLIENT', true, false);
insert into users (first_name, last_name, email, password, phone, adress, country, city, reg_type, active, delete_requested) values ('Milenko', 'Bukvic', 'bukvic@gmail.com', '$2a$12$f/CV3jLdVkYeETKhdJvenO3ueaKsESVwCnJbMXcTqmFayd0escPya', '456621', 'Marka Miljanova 18', 'Srbija', 'Novi Sad', 'BOAT_OWNER', false, false);

insert into fishing_class (user_id, adress, description, instructor_bio, max_cap, rules, equipment, menu, cancel_conditions) values (2, 'Narodnog Fronta 14, Novi Sad', 'Veoma lepo', 'Dobar covek', 5, 'Nema pravila', 'Sva oprema', 'Pecanje 50e, Obuka i pecanje 100e', 'Vracamo novac');

insert into fishing_class_reservations (user_id, start, end_time, duration, location, max_cap, extra_offers, price, class_id) values (5, TO_TIMESTAMP('2022-02-09 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-10 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), 60, 'Narodnog Fronta 14, Novi Sad', 5, 'Imamo i camac', 100, 1 );
insert into fishing_class_reservations (user_id, start, end_time, duration, location, max_cap, extra_offers, price, class_id) values (0, TO_TIMESTAMP('2022-02-09 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-02-10 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), 60, 'Narodnog Fronta 14, Novi Sad', 5, 'Imamo i camac', 100, 1 );

insert into instructor_availabilities (user_id, start, end_time) values (2, TO_TIMESTAMP('2022-05-09 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-05-10 15:00:00', 'YYYY-MM-DD HH24:MI:SS'));
insert into instructor_availabilities (user_id, start, end_time) values (2, TO_TIMESTAMP('2022-04-09 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-04-10 15:00:00', 'YYYY-MM-DD HH24:MI:SS'));

insert into fishing_reviews(client, instructor, comment, report, show_up) values (1, 2, 'jedan', true, false);

insert into grades(user_id, subject_id, grade) values (5, 1, 4);
insert into grades(user_id, subject_id, grade) values (6, 1, 3);

insert into loyality_program(client_points, owner_points, bronze_line, silver_line, gold_line) values (1, 2, 4, 8, 12);

insert into houses (name, address, description, rules, user_id) values ('Villa Sofia', 'Vrdnicka 3', 'Blizu grada!', 'Zabranjeno pusenje!', 4);
insert into houses (name, address, description, rules, user_id) values ('Villa Jovana', 'Vrdnicka 16', 'Povoljno!', 'Zabranjeno pusenje!', 5);