package stellarbytestudios.socialboard.database.ServiceCommunication;

import org.springframework.stereotype.Repository;
import stellarbytestudios.socialboard.core.UserRec;
import stellarbytestudios.socialboard.database.DBcommunication.UserCrudRepo;
import stellarbytestudios.socialboard.database.DTOs.UserDTO;
import stellarbytestudios.socialboard.services.UserServiceRepository;

import java.util.ArrayList;
import java.util.List;


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

    // Überprüft, ob ein Nutzer mit diesem Namen bereits in der Datenbank ist
    @Override
    public boolean usernameAlreadyTaken(String username) {
        // Alle Nutzer aus der Datenbank holen
        Iterable<UserDTO> usersIterable = userCrudRepo.findAll();
        // Daten zur einer Liste verarbeiten, sodass man sie vernünftig benuzten kann
        // Brauche nur die Namen zum abgleichen
        List<String> usernamesList = new ArrayList<>();
        usersIterable.forEach(userDTO -> {usernamesList.add(userDTO.getUsername());});

        // Den Namen suchen, ob er schon vorhanden ist
        return usernamesList.contains(username);
    }
}
