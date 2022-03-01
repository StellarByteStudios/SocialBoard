package stellarbytestudios.socialboard.database.ServiceCommunication;

import org.springframework.stereotype.Repository;
import stellarbytestudios.socialboard.core.DropRec;
import stellarbytestudios.socialboard.database.DBcommunication.UserCrudRepo;
import stellarbytestudios.socialboard.database.DTOs.DropDTO;
import stellarbytestudios.socialboard.database.DTOs.UserDTO;
import stellarbytestudios.socialboard.services.DropsHandlingRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Diese Klasse Implementiert das Repository aus dem Service Package
// Es ist zusammen mit diesem Interface die Schnittstelle zwischen Services und
// der Datenbank
@Repository
public class DropsHandlingRepositoryImpl implements DropsHandlingRepository {

    // Verbindung zur Datenbank
    UserCrudRepo userCrudRepo;

    // Initialisierung
    public DropsHandlingRepositoryImpl(UserCrudRepo userCrudRepo) {
        this.userCrudRepo = userCrudRepo;
    }

    // holt alle Drops aus der Datenbank für den Globalfeed
    @Override
    public List<DropRec> getAllDrops() {
        // Alle User aus der Datenbank holen
        Iterable<UserDTO> userDTOIterable = userCrudRepo.findAll();
        // Jetzt die Drops der einzelnen User sammeln
        List<DropRec> drops = new ArrayList<>();

        userDTOIterable.forEach(user ->     // Für jeden User
                user.getDropDTOS().         // Hol ich mir seine Drops
                        forEach(dropDTO ->  // Und füg sie alle der Dropliste hinzu
                            drops.add(mapDropDTOtoRecord(user.getUsername(),dropDTO))));
        return drops;
    }

    // Speichert einen neuen Drop in der Datenbank
    @Override
    public void saveNewDrop(String username, String dropcontent) {
        // Postenden User aus der Datenbank holen
        UserDTO user = userCrudRepo.findUserDTOByUsername(username);
        // Bei diesem einen neuen Drop hinzufügen
        user.addDrop(new DropDTO(dropcontent, LocalDateTime.now()));
        // Aktuallisierten User abspeichern
        userCrudRepo.save(user);
    }

    // Mapper der den Username und ein DropDTO annimmt und daraus ein Record macht
    private static DropRec mapDropDTOtoRecord(String username, DropDTO dropDTO){
        DropRec record = new DropRec(username,dropDTO.getContent(), dropDTO.getDateOfWriting());
        return record;
    }
}
