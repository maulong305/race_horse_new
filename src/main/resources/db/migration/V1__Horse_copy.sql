create table if not exists horse_copy(
    id int auto_increment primary key ,
    name varchar(255),
    color varchar(200)
);

insert into horse_copy(id, name, color) SELECT id, name, color from horse;
