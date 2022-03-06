package stellarbytestudios.socialboard.services;

import stellarbytestudios.socialboard.core.DropRec;

import java.util.List;

// Dieses Interface gibt an, was von dem Datenbankpackage verlangt wird
// Es wird von DropsHandlingRepositoryImpl implementiert und Spring gibt quasie
// Die Funktionen durch
// Zuständig für alles was mit dem User selbst zu tun hat
public interface DropsHandlingRepository {

    // holt alle Drops aus der Datenbank
    List<DropRec> getAllDrops();

    // holt alle Drops von einem Bestimmten Nutzer aus der Datenbank
    List<DropRec> getDropsOfUser(String username);

    // Nimmt die Daten für einen Drop an und speichert diesen in der Datenbank
    void saveNewDrop(String username, String dropcontent);
}
