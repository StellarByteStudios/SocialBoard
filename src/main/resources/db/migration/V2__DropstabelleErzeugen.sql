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

