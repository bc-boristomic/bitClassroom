# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table error_log (
  id                        bigint auto_increment not null,
  message                   varchar(255),
  loged_date                datetime,
  constraint pk_error_log primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  email                     varchar(100),
  password                  varchar(100),
  first_name                varchar(100),
  last_name                 varchar(100),
  nick_name                 varchar(50),
  birth_date                varchar(255),
  gender                    integer(1),
  location                  varchar(150),
  home_phone                varchar(15),
  cell_phone                varchar(15),
  website                   varchar(255),
  skype                     varchar(255),
  facebook                  varchar(255),
  twitter                   varchar(255),
  youtube                   varchar(255),
  picture                   varchar(255),
  status                    integer(1),
  create_date               datetime,
  created_by                varchar(255),
  update_date               datetime,
  updated_by                varchar(255),
  constraint uq_user_email unique (email),
  constraint pk_user primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table error_log;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

