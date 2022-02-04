-- Erzeugen der Tabelle in der die Userdaten gespeichert werden --
create table Users
(
    -- userId ist der Primärschlüssel --
	userID int,
	-- Daten des Users --
	username varchar(100) default 'defaultusername' not null,
	userpassword varchar(100) default 'superSecredPassword' not null
);

-- Macht die ID des User einzigartig (keine doppelten IDs) --
create unique index Users_userID_uindex
	on Users (userID);

-- Macht die ID zum Primärschlüssel --
alter table Users
	add constraint Users_pk
		primary key (userID);

-- Die ID wird bei neuen Usern automatisch hochgezählt --
alter table Users modify userID int auto_increment;
