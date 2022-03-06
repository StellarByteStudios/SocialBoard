package stellarbytestudios.socialboard.database.DTOs;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("USERFOLLOWERCONJUNCTION")
public class FollowerRef {
    @Column("FOLLOWER_ID")
    private Long FollowerID;

    public FollowerRef(Long followerID) {
        FollowerID = followerID;
    }
}
