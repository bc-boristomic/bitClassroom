# --- !Ups

create table field (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_field primary key (id))
;