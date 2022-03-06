-- Erzeugen der Tabelle in der die Userdaten gespeichert werden --
create table UserFollowerConjunction
(
    -- ID des Folgenden --
	Follower_ID int,
	-- ID des Gefolgten --
	User_DTO int,
	-- Macht die gemeinsame Verbindung zum Primärschlüssel --
	primary key (Follower_ID, User_DTO),
    -- Macht die Fremdschlüsselverknüpfung --
    constraint UserFollowerConjunction_Users_fk
        foreign key (User_DTO) references Users (userID)
);