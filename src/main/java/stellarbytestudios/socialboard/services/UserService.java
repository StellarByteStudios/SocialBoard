package stellarbytestudios.socialboard.services;

import org.springframework.stereotype.Service;
import stellarbytestudios.socialboard.core.DropRec;

import java.util.List;

// Dieser Service managed alles vom UserPageController dazu gehört vorallem ziehen und
// abspeichern der Drops
@Service
public class UserService {

    // Initialisierung
    private final DropsHandlingRepository dropsRepo;
    public UserService(DropsHandlingRepository dropsRepo) {
        this.dropsRepo = dropsRepo;
    }

    // Methoden
    public List<DropRec> getAllDrops() {
        return dropsRepo.getAllDrops();
    }

    public List<DropRec> getAllDropsSortByDate() {
        List<DropRec> allDrops = getAllDrops();
        allDrops.sort(DropRec::compareDate);
        return allDrops;
    }

}
