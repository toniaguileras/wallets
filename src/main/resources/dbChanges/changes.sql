insert into user (email, name, role, surname, username)
values ('toniaguileras@gmail.com', 'Toni', 'ADMIN', 'Aguilera', 'toni_aguilera');
insert into user (email, name, role, surname, username)
values ('alexdiaz@gmail.com', 'Alex', 'USER', 'Diaz', 'alex_diaz');

insert into user (email, name, role, surname, username)
values ('angelramirez@gmail.com', 'Angel', 'ADMIN', 'Ramirez', 'angel_ramirez');

insert into wallet (amount, name, user_id)
values (1000.00, 'Cartera de Toni 1', 1);
insert into wallet (amount, name, user_id)
values (2000.00, 'Cartera de Toni 2', 1);
insert into wallet (amount, name, user_id)
values (1500.00, 'Cartera de Alex 1', 2);

insert into user_wallets values (1,1);
insert into user_wallets values (1,2);
insert into user_wallets values (1,3);
