drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence start with 100 increment by 1;

create table if not exists categoria (
     id bigint not null,
     destacada boolean not null,
     imagen varchar(512),
    nombre varchar(512),
    primary key (id)
    );

create table if not exists producto (
    id bigint not null,
    descripcion clob,
    descuento float not null,
    imagen varchar(512),
    nombre varchar(512),
    pvp float not null,
    categoria_id bigint,
    primary key (id)
    );

create table if not exists puntuacion (
    id bigint not null,
    fecha timestamp,
    puntuacion integer not null,
    producto_id bigint,
    primary key (id)
    );

alter table producto add constraint if not exists fk_producto_categoria foreign key (categoria_id) references categoria;
alter table puntuacion add constraint if not exists fk_puntuacion_producto foreign key (producto_id) references producto;