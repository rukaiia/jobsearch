create table users (
                       id int auto_increment primary key,
                       phone varchar(20),
                       name varchar(100),
                       password varchar(255),
                       role varchar(20) default 'USER'
);

create table accounts (
                          id int auto_increment primary key,
                          user_id int,
                          currency varchar(10),
                          balance double ,
                         foreign key  (user_id) references users(id)
);

create  table transactions (
                              id int auto_increment primary key,
                              from_account_id int,
                              to_account_id int,
                              amount double ,
                              transaction_date timestamp,
                              status varchar(20) default 'PENDING',
                              foreign key (from_account_id) references accounts(id),
                              foreign key (to_account_id) references accounts(id)
);

create table transaction_logs (
                                  id int auto_increment primary key,
                                  transaction_id INT,
                                  action varchar(50),
                                  action_date timestamp,
                                  foreign key (transaction_id) references transactions(id)
);

insert into users (phone, name, password, role) values
                                                    ('123-456-7890', 'John Doe', 'password1', 'USER'),
                                                    ('987-654-3210', 'Jane Smith', 'password2', 'USER');

insert into accounts (user_id, currency, balance) values
                                                      (1, 'USD', 1000),
                                                      (2, 'USD', 1500);
