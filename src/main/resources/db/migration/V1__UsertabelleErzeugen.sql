-- Erzeugen der Tabelle in der die Userdaten gespeichert werden --
create table Users
(
    -- userId ist der Primärschlüssel --
	userID int not null auto_increment,
	-- Daten des Users --
	username varchar(100) default 'defaultusername' not null,
	userpasswordsalt int default 123456789 not null,
	userpasswordhash varchar(130) default 'someHash' not null,
	-- Macht die ID zum Primärschlüssel --
	constraint Users_pk primary key (userID)
);

-- Macht die ID des User einzigartig (keine doppelten IDs) --
create unique index Users_userID_uindex
	on Users (userID);
