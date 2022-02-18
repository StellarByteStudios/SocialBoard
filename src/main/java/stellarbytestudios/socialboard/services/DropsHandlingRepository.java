package stellarbytestudios.socialboard.services;

import stellarbytestudios.socialboard.core.DropRec;

import java.util.List;

public interface DropsHandlingRepository {
    List<DropRec> getAllDrops();

    void saveNewDrop(String username, String dropcontent);
}
