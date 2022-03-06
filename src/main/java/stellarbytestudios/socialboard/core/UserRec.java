package stellarbytestudios.socialboard.core;

import java.util.List;
import java.util.Set;

public record UserRec(String username, List<DropRec> drops, Set<UserRec> follower) {
}
