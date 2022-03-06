package stellarbytestudios.socialboard.database.DTOs;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("USERFOLLOWERCONJUNCTION")
public class FollowerRef {
    @Id
    @Column("FOLLOWER_ID")
    private Long id;

    public FollowerRef(Long followerID) {
        id = followerID;
    }

    public Long getId() {
        return id;
    }
}
