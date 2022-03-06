-- Noch mehr Testdaten um etwas besser zu testen

insert into Users (username, userpasswordsalt, userpasswordhash)
values ('TestingMüller', -883060817, '3253d290b99de78d680a70567c3a283d4f0c045a702b13d9e029db82f810529e9193b172bf4fa2b95654b0ac95c8ba8ab5af09e2aaa77e20447c852a3aa0921e'),
       ('TestingMagret', 1682645245, '2cd1c092c8539ddb72f3f4d2cea8bb603b6ff03baf69145b8f3ab339fc901df8fa2c52d0f0e80e0e3fdf33dcb5d37b72f2d6f5a1abc07f6a1ca0969d3095b2e3'),
       ('TestingHank', 1412531232, '6b861c69a82a223dbb480485221f6a1f3499bb9e5ae1421771061d55ea9c120ba05fd36e7b167a276062ced94a7db042685f68f545823bbc02df622391dba3e7');

insert into Drops (content, creationDate, User_DTO)
values ('Hey Leute, ich bin Müller, ich bin neu hier', '2021-01-01T12:30:00', 3),
        ('Ich hatte gehoft hier nette leute kennen zu lernen ^^', '2021-01-01T12:31:00', 3),
        ('Hey Müller o/, ich bin Magret und auch neu hier', '2021-01-01T12:32:00', 4),
        ('Was geht denn so bei dir?', '2021-01-01T12:33:00', 4),
        ('Ach nicht viel, habe gerade Urlaub und versuche ein wenig zu entspannen', '2021-01-01T12:34:00', 3),
        ('Oha, das hört sich echt nice an :)', '2021-01-01T12:35:00', 3),
        ('Was geht leude? Freut mich, das ihr hier zu uns gefunden habt. Ich bin Hank und bin schon etwas länger hier.
        Es ist immer eine Freude, wenn sich hier neue Leute hin verirren', '2021-01-01T12:36:00', 6),
        ('Hey Hank, freut mich dich kennen zu lernen \o/', '2021-01-01T12:37:00', 4),
        ('Mich auch', '2021-01-01T12:38:00', 5);