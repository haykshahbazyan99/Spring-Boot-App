create table registered_students (
            id bigint not null,
            dob date,
            email varchar(255),
            name varchar(255),
            primary key (id)) engine=InnoDB;