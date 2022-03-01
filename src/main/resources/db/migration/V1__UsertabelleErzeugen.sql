-- Erzeugen der Tabelle in der die Userdaten gespeichert werden --
create table USERS
(
    -- userId ist der Primärschlüssel --
	USERID int not null auto_increment,
	-- Daten des Users --
	USERNAME varchar(100) default 'defaultusername' not null,
	USERPASSWORDSALT int default 123456789 not null,
	USERPASSWORDHASH varchar(130) default 'someHash' not null,
	-- Macht die ID zum Primärschlüssel --
	constraint USERS_pk primary key (userID)
);
--
-- -- Macht die ID des User einzigartig (keine doppelten IDs) --
-- create unique index USERS_USERID_uindex
-- 	on USERS (userID);
