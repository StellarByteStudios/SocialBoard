insert into Users (username, userpassword)
values ('The First One', 'SupaDupaPassword42069'),
        ('Schüler1', '123');

insert into Drops (content, creationDate, User_DTO)
values ('The eins nicer erste Drop', CURRENT_TIMESTAMP, 1),
        ('Zweiter nicer Drop', CURRENT_TIMESTAMP, 1),
        ('Dritter wirklich interesanter Drop', CURRENT_TIMESTAMP, 1);