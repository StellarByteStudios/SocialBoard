insert into Users (username, userpasswordsalt, userpasswordhash)
values ('The First One', -1006375648, '56332867c05345993604df16ebff6130d016267419bd2ee6185a41c4b6d91a98df388079d03287fee6924627c8a4a2e26a1b615a7941cb5c7905e33dc127d31d'),
       ('Schüler1', 1267670996, '3274e8f2d8e30aa640530e99f726159f2010b95c88e9dcedabaea06f68b69aeb41f45aa54f736f8d6225cc3818f254b22b509630604679f3e6ec2fbf3500b281');

insert into Drops (content, creationDate, User_DTO)
values ('The eins nicer erste Drop', CURRENT_TIMESTAMP, 1),
        ('Zweiter nicer Drop', CURRENT_TIMESTAMP, 1),
        ('Dritter wirklich interesanter Drop', CURRENT_TIMESTAMP, 1);