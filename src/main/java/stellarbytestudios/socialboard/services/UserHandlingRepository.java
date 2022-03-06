package stellarbytestudios.socialboard.services;

import stellarbytestudios.socialboard.core.UserRec;
import stellarbytestudios.socialboard.database.DTOs.UserDTO;

import java.util.Set;


// Dieses Interface gibt an, was von dem Datenbankpackage verlangt wird
// Es wird von UserServiceRepositoryImpl implementiert und Spring gibt quasie
// Die Funktionen durch
// Zuständig für alles was mit dem User selbst zu tun hat
public interface UserHandlingRepository {

    // Uservalidating beim Anmelden, ist der Nutzer so korrekt?
    boolean validateUserLogin(String name, String password);

    // Schaut ob der Nutzername bereits benutzt wurde
    boolean usernameAlreadyTaken(String username);

    // legt einen neuen Nutzer in der Datenbank an
    void createNewUser(String name, String password);

    Set<UserRec> getFollowerByUserId(Long id);
}
