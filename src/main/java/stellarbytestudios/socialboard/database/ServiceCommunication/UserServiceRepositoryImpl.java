package stellarbytestudios.socialboard.database.ServiceCommunication;

import org.springframework.stereotype.Repository;
import stellarbytestudios.socialboard.core.UserRec;
import stellarbytestudios.socialboard.database.DBcommunication.UserCrudRepo;
import stellarbytestudios.socialboard.database.DTOs.UserDTO;
import stellarbytestudios.socialboard.services.UserServiceRepository;


// Diese Klasse Implementiert das Repository aus dem Service Package
// Es ist zusammen mit diesem Interface die Schnittstelle zwischen Services und
// der Datenbank
@Repository
public class UserServiceRepositoryImpl implements UserServiceRepository {

    // Verbindung zur Datenbank
    UserCrudRepo userCrudRepo;

    // Initialisierung
    public UserServiceRepositoryImpl(UserCrudRepo userCrudRepo) {
        this.userCrudRepo = userCrudRepo;
    }

    // Überprüft ob der übergebene User so in der Datenbank steht (Name und Passwort korrekt)
    @Override
    public boolean validateUserLogin(UserRec user) {
        UserDTO userInDb = userCrudRepo.findUserDTOByUsername(user.username());
        if (userInDb == null) { return false; }
        return userInDb.equalsWithRecord(user);
    }
}
