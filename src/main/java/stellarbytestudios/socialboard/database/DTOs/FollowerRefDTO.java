package stellarbytestudios.socialboard.database.DTOs;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("USERFOLLOWERCONJUNCTION")
public class FollowerRefDTO {

    @Column("FOLLOWER_ID")
    private Long followerID;

    public FollowerRefDTO(Long followerID) {
        this.followerID = followerID;
    }

    public Long getFollowerID() {
        return followerID;
    }
}
