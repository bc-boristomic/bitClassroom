# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table daily_report (
<<<<<<< HEAD
  id                        bigint not null,
=======
  id                        bigint auto_increment not null,
>>>>>>> master
  name                      varchar(255),
  create_date               datetime,
  data                      varchar(255),
  constraint pk_daily_report primary key (id))
;

create table error_log (
  id                        bigint not null,
  message                   varchar(255),
  loged_date                datetime,
  constraint pk_error_log primary key (id))
;

create table post (
  id                        bigint not null,
  title                     varchar(255),
  content                   text,
  post_type                 integer,
  visible_mentors           boolean,
  date                      varchar(255),
  link                      varchar(255),
  user_id                   bigint,
  constraint pk_post primary key (id))
;

create table role (
  id                        bigint not null,
  name                      varchar(10),
  constraint pk_role primary key (id))
;

create table user (
  id                        bigint not null,
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


create table user_role (
  user_id                        bigint not null,
  role_id                        bigint not null,
  constraint pk_user_role primary key (user_id, role_id))
;
create sequence daily_report_seq;

create sequence error_log_seq;

create sequence post_seq;

create sequence role_seq;

create sequence user_seq;

alter table post add constraint fk_post_user_1 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_post_user_1 on post (user_id);



alter table user_role add constraint fk_user_role_user_01 foreign key (user_id) references user (id) on delete restrict on update restrict;

alter table user_role add constraint fk_user_role_role_02 foreign key (role_id) references role (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists daily_report;

drop table if exists error_log;

drop table if exists post;

drop table if exists role;

drop table if exists user;

drop table if exists user_role;

<<<<<<< HEAD
SET REFERENTIAL_INTEGRITY TRUE;
=======
drop table daily_report;

drop table error_log;
>>>>>>> master

drop sequence if exists daily_report_seq;

drop sequence if exists error_log_seq;

drop sequence if exists post_seq;

drop sequence if exists role_seq;

drop sequence if exists user_seq;

