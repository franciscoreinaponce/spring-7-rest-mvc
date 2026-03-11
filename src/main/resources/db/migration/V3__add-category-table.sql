
drop table if exists milk_category;

drop table if exists category;

create table category (
                      id binary(16) not null,
                      version integer,
                      description varchar(50) not null,
                      created_at datetime(6) not null,
                      updated_at datetime(6) not null,
                      primary key (id)
) engine=InnoDB;

create table milk_category (
                      milk_id binary(16) not null,
                      category_id binary(16) not null,
                      primary key (milk_id, category_id)
) engine=InnoDB;

alter table milk_category
    add constraint pc_milk_id_fk foreign key (milk_id) references milk(id),
    add constraint pc_category_id_fk foreign key (category_id) references category(id);
