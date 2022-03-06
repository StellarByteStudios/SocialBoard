package stellarbytestudios.socialboard.database.ServiceCommunication;

import org.springframework.stereotype.Repository;
import stellarbytestudios.socialboard.core.DropRec;
import stellarbytestudios.socialboard.core.UserRec;
import stellarbytestudios.socialboard.database.DBcommunication.UserCrudRepo;
import stellarbytestudios.socialboard.database.DTOs.FollowerRefDTO;
import stellarbytestudios.socialboard.database.DTOs.UserDTO;
import stellarbytestudios.socialboard.services.UserHandlingRepository;

import java.util.*;


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
    public boolean validateUserLogin(String name, String password) {
        // User mit diesem Namen aus der Datenbank holen
        UserDTO userInDb = userCrudRepo.findUserDTOByUsername(name);
        // Ist dieser Name überhaupt abgespeichert
        if (userInDb == null) { return false; }
        // Nutzt die Methode von UserDTO um es mit dem UserRec zu vergleichen
        return userInDb.evaluatePassword(name, password);
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

    // Hole alle Follower eines Nutzers aus der Datenbank
    @Override
    public Set<UserRec> getFollowerByUserId(Long id) {
        // Alle User aus der Datenbank holen
        Optional<UserDTO> userdto = userCrudRepo.findById(id);
        // Gibt es den Nutzer?
        if (userdto.isEmpty()) {
            return null;
        }
        // Jetzt die Follower des übergebenen Users rausfischen
        Set<UserRec> follower = new HashSet<>();
        userdto.get().getFollower().            // Hol ich mir wer ihm folgt (sind noch nur die Referenzen)
                forEach(followerRefDTO ->       // Muss jetzt die Referenzen in User umwandeln
                follower.add(mapFollowerReftoUser(followerRefDTO)));
        return  follower;
    }

    // Mappt eine FollowerReferenz (also die Id) eines Followers auf desses Daten
    private UserRec mapFollowerReftoUser(FollowerRefDTO followerRefDTO) {
        Optional<UserDTO> databaseDataOpt = userCrudRepo.findById(followerRefDTO.getFollowerID());
        if (databaseDataOpt.isEmpty()) {
            return null;
        }

        String username = databaseDataOpt.get().getUsername();
        List<DropRec> drops = new ArrayList<>();
        databaseDataOpt.get().getDropDTOS().forEach(drop -> drops.add(DropsHandlingRepositoryImpl.mapDropDTOtoRecord(databaseDataOpt.get().getUsername(), drop)));
        // Greifen erstmal nicht auf die Follower zu, denn dann kämen wir zu den Followern der Follower usw...
        Set<UserRec> followerSet = new HashSet<>();
        return new UserRec(username, drops, followerSet);
    }
}
