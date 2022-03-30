drop database if exists foodtruck_mobile_noti;
create database foodtruck_mobile_noti;
use foodtruck_mobile_noti;

drop table if exists noti_board;
create table noti_board
(
    id       bigint auto_increment primary key,
    category enum ('one', 'two'),
    title    varchar(100),
    message  varchar(100),
    status   enum ('pass', 'redirect', 'banned'),
    location varchar(100) default 'intent'
);
insert into noti_board (id, category, title, message, status, location)
values (default, 'one', '업데이트가 필요합니다', '해당 버전은 현재 사용할 수 없습니다. OK 버튼을 클릭해서 업데이트 진행해주세요', 'redirect',
        'https://play.google.com/store/apps/details?id=com.bigstack.rise');
insert into noti_board (id, category, title, message, status, location)
values (default, 'one', '공지사항', '20:00~21:00 동안 이벤트 합니다!', 'pass', default);
insert into noti_board (id, category, title, message, status, location)
values (default, 'one', '공지사항', '시스템 점검중입니다', 'banned',
        'https://play.google.com/store/apps/details?id=com.bigstack.rise');

drop table if exists noti_app_target;
create table noti_app_target
(
    id            bigint auto_increment primary key,
    noti_board_id bigint,
    app_info_id   bigint,
    use_yn        boolean
);
insert into noti_app_target(id, noti_board_id, app_info_id, use_yn)
values (default, 1, 1, true);
insert into noti_app_target(id, noti_board_id, app_info_id, use_yn)
values (default, 1, 2, true);

drop table if exists app_info;
create table app_info
(
    id       bigint auto_increment primary key,
    category enum ('and', 'ios'),
    os_ver   varchar(10),
    app_ver  varchar(10)
);

insert into app_info (id, category, os_ver, app_ver)
values (default, 'and', '19.0.1', '0.0.1');
insert into app_info (id, category, os_ver, app_ver)
values (default, 'and', '19.0.2', '0.0.1');
insert into app_info (id, category, os_ver, app_ver)
values (default, 'ios', '19.0.1', '0.0.1');
