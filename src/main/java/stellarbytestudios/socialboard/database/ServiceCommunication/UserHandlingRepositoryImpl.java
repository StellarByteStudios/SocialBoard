package stellarbytestudios.socialboard.database.ServiceCommunication;

import org.springframework.stereotype.Repository;
import stellarbytestudios.socialboard.core.UserRec;
import stellarbytestudios.socialboard.database.DBcommunication.UserCrudRepo;
import stellarbytestudios.socialboard.database.DTOs.UserDTO;
import stellarbytestudios.socialboard.services.UserHandlingRepository;

import java.util.ArrayList;
import java.util.List;


// Diese Klasse Implementiert das Repository aus dem Service Package
// Es ist zusammen mit diesem Interface die Schnittstelle zwischen Services und
// der Datenbank
@Repository
public class UserHandlingRepositoryImpl implements UserHandlingRepository {

    // Verbindung zur Datenbank
    UserCrudRepo userCrudRepo;

    // Initialisierung
    public UserHandlingRepositoryImpl(UserCrudRepo userCrudRepo) {
        this.userCrudRepo = userCrudRepo;
    }

    // Überprüft ob der übergebene User so in der Datenbank steht (Name und Passwort korrekt)
    @Override
    public boolean validateUserLogin(UserRec user) {
        // User mit diesem Namen aus der Datenbank holen
        UserDTO userInDb = userCrudRepo.findUserDTOByUsername(user.username());
        // Ist dieser Name überhaupt abgespeichert
        if (userInDb == null) { return false; }
        // Nutzt die Methode von UserDTO um es mit dem UserRec zu vergleichen
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

    // Registriert und speichert einen neuen User
    @Override
    public void createNewUser(String name, String password) {
        // Factory von UserDTO um einen neuen zu erstellen
        UserDTO newUser = UserDTO.create(name, password);
        // Abspeichern des neuen Nutzers in der Datenbank
        userCrudRepo.save(newUser);
    }
}
