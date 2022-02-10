-- für den Fall der Fälle --
drop table if exists Drops;
drop table if exists Users;

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

-- Erzeugen der Tabelle in der die ganzen Drops (Nachrichten) gespeichert werden --
create table Drops (
    -- dropIDId ist der Primärschlüssel --
    dropID integer auto_increment,
    -- Inhalt der nachicht --
    content varchar(300),
    -- Datum, an dem die Nachricht erstellt wurde --
    creationDate datetime not null,
    -- der Verfasser des Drops (ist auch ein Fremdschlüssel) --
    User_DTO integer,
    -- Macht die ID zum Primärschlüssel --
    primary key (dropID),
    -- Macht die Fremdschlüsselverknüpfung --
    constraint Drops_Users_fk
        foreign key (User_DTO) references Users (userID)
);

insert into Users (username, userpasswordsalt, userpasswordhash)
values ('The First One', -1006375648, '56332867c05345993604df16ebff6130d016267419bd2ee6185a41c4b6d91a98df388079d03287fee6924627c8a4a2e26a1b615a7941cb5c7905e33dc127d31d'),
       ('Schüler1', 1267670996, '3274e8f2d8e30aa640530e99f726159f2010b95c88e9dcedabaea06f68b69aeb41f45aa54f736f8d6225cc3818f254b22b509630604679f3e6ec2fbf3500b281');

insert into Drops (content, creationDate, User_DTO)
values ('The eins nicer erste Drop', CURRENT_TIMESTAMP, 1),
        ('Zweiter nicer Drop', CURRENT_TIMESTAMP, 1),
        ('Dritter wirklich interesanter Drop', CURRENT_TIMESTAMP, 1);