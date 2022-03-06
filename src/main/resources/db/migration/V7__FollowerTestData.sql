insert into UserFollowerConjunction (Follower_Id, User_DTO)
-- Stelle Followerbeziehungen her:
    -- Müller --> Hank
    -- Magret --> Müller, Hank
    -- Hank   -->

-- Müller: 3
-- Magret: 4
-- Hank: 5
values (3, 5),
        (4, 3),
        (4, 5);