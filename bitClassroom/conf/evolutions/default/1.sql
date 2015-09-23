# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table course (
  id                        bigint auto_increment not null,
  name                      varchar(50),
  description               varchar(2000),
  teacher_id                bigint,
  image                     varchar(255),
  create_date               datetime,
  created_by                varchar(255),
  update_date               datetime,
  updated_by                varchar(255),
  constraint pk_course primary key (id))
;

create table course_user (
  id                        bigint auto_increment not null,
  status                    integer(1),
  user_id                   bigint,
  course_id                 bigint,
  constraint pk_course_user primary key (id))
;

create table daily_report (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  create_date               datetime,
  data                      varchar(4000),
  constraint pk_daily_report primary key (id))
;

create table error_log (
  id                        bigint auto_increment not null,
  message                   varchar(500),
  loged_date                datetime,
  constraint pk_error_log primary key (id))
;

create table field (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_field primary key (id))
;

create table mentorship (
  id                        bigint auto_increment not null,
  mentor_id                 bigint,
  student_id                bigint,
  status                    integer(1),
  create_date               datetime,
  created_by                varchar(255),
  update_date               datetime,
  updated_by                varchar(255),
  constraint pk_mentorship primary key (id))
;

create table post (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  content                   text,
  post_type                 integer,
  visible_mentors           tinyint(1) default 0,
  link                      varchar(255),
  files                     varchar(255),
  date                      varchar(255),
  create_date               datetime,
  user_id                   bigint,
  constraint pk_post primary key (id))
;

create table private_message (
  id                        bigint auto_increment not null,
  subject                   varchar(255),
  content                   varchar(255),
  sender_id                 bigint,
  receiver_id               bigint,
  status                    integer,
  create_date               datetime,
  constraint pk_private_message primary key (id))
;

create table report_field (
  id                        bigint auto_increment not null,
  value                     varchar(255),
  daly_id                   bigint,
  field_id                  bigint,
  constraint pk_report_field primary key (id))
;

create table role (
  id                        bigint auto_increment not null,
  name                      varchar(10),
  constraint pk_role primary key (id))
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
  student_status            integer(1),
  create_date               datetime,
  created_by                varchar(50),
  update_date               datetime,
  updated_by                varchar(50),
  constraint uq_user_email unique (email),
  constraint pk_user primary key (id))
;


create table user_role (
  user_id                        bigint not null,
  role_id                        bigint not null,
  constraint pk_user_role primary key (user_id, role_id))
;
alter table course add constraint fk_course_teacher_1 foreign key (teacher_id) references user (id) on delete restrict on update restrict;
create index ix_course_teacher_1 on course (teacher_id);
alter table course_user add constraint fk_course_user_user_2 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_course_user_user_2 on course_user (user_id);
alter table course_user add constraint fk_course_user_course_3 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_course_user_course_3 on course_user (course_id);
alter table mentorship add constraint fk_mentorship_mentor_4 foreign key (mentor_id) references user (id) on delete restrict on update restrict;
create index ix_mentorship_mentor_4 on mentorship (mentor_id);
alter table mentorship add constraint fk_mentorship_student_5 foreign key (student_id) references user (id) on delete restrict on update restrict;
create index ix_mentorship_student_5 on mentorship (student_id);
alter table post add constraint fk_post_user_6 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_post_user_6 on post (user_id);
alter table private_message add constraint fk_private_message_sender_7 foreign key (sender_id) references user (id) on delete restrict on update restrict;
create index ix_private_message_sender_7 on private_message (sender_id);
alter table private_message add constraint fk_private_message_receiver_8 foreign key (receiver_id) references user (id) on delete restrict on update restrict;
create index ix_private_message_receiver_8 on private_message (receiver_id);
alter table report_field add constraint fk_report_field_dailyReport_9 foreign key (daly_id) references daily_report (id) on delete restrict on update restrict;
create index ix_report_field_dailyReport_9 on report_field (daly_id);
alter table report_field add constraint fk_report_field_field_10 foreign key (field_id) references field (id) on delete restrict on update restrict;
create index ix_report_field_field_10 on report_field (field_id);



alter table user_role add constraint fk_user_role_user_01 foreign key (user_id) references user (id) on delete restrict on update restrict;

alter table user_role add constraint fk_user_role_role_02 foreign key (role_id) references role (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table course;

drop table course_user;

drop table daily_report;

drop table error_log;

drop table field;

drop table mentorship;

drop table post;

drop table private_message;

drop table report_field;

drop table role;

drop table user;

drop table user_role;

SET FOREIGN_KEY_CHECKS=1;

