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

@Repository
public class DropsHandlingRepositoryImpl implements DropsHandlingRepository {

    // Verbindung zur Datenbank
    UserCrudRepo userCrudRepo;

    // Initialisierung
    public DropsHandlingRepositoryImpl(UserCrudRepo userCrudRepo) {
        this.userCrudRepo = userCrudRepo;
    }

    @Override
    public List<DropRec> getAllDrops() {
        // Alle User aus der Datenbank holen
        Iterable<UserDTO> userDTOIterable = userCrudRepo.findAll();
        // Jetzt die Drops der einzelnen User sammeln
        List<DropRec> drops = new ArrayList<>();

        userDTOIterable.forEach(user ->     // Für jeden User
                user.getDropDTOS().         // Hol ich mir seine Drops
                        forEach(dropDTO     // Und füg sie alle der Dropliste hinzu
                                -> drops.add(mapDropDTOtoRecord(user.getUsername(),dropDTO))));
        return drops;
    }

    private static DropRec mapDropDTOtoRecord(String username, DropDTO dropDTO){
        DropRec record = new DropRec(username,dropDTO.getContent(), dropDTO.getDateOfWriting());
        return record;
    }
}
