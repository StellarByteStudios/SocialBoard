package stellarbytestudios.socialboard.services;

import org.springframework.stereotype.Service;
import stellarbytestudios.socialboard.core.DropRec;

import java.util.List;

// Dieser Service managed alles vom User-Controller dazu gehört vorallem ziehen und
// abspeichern der Drops
@Service
public class UserService {

    // * * Kopf * * //
    // Verbindung zu den Interfaces im gleichen Package
    private final DropsHandlingRepository dropsRepo;
    // Diese brauchen einen Konstruktor:
    public UserService(DropsHandlingRepository dropsRepo) {
        this.dropsRepo = dropsRepo;
    }

    // * * Methoden * * //
    // holt alle Drops aus der Datenbank
    public List<DropRec> getAllDrops() {
        return dropsRepo.getAllDrops();
    }

    // holt auch alle Drops aus der Datenbank und sortiert diese nach dme Datum
    public List<DropRec> getAllDropsSortByDate() {
        List<DropRec> allDrops = getAllDrops();
        allDrops.sort(DropRec::compareDate);
        return allDrops;
    }

    // Nimmt die Daten für einen neuen Drop an und speichert diese in der Datenbank
    public void saveNewDrop(String username, String dropcontent) {
        dropsRepo.saveNewDrop(username, dropcontent);
    }
}
