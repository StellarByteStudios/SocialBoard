package stellarbytestudios.socialboard.core;

import java.time.LocalDateTime;

public record DropRec(String author, String content, LocalDateTime creationDate) {

    public static int compareDate(DropRec dropOne, DropRec dropTwo) {
        return dropOne.creationDate.compareTo(dropTwo.creationDate) * -1;
    }
}
