package stellarbytestudios.socialboard.services;

import stellarbytestudios.socialboard.core.UserRec;


// Dieses Interface gibt an, was von dem Datenbankpackage verlangt wird
// Es wird von UserServiceRepositoryImpl implementiert und Spring gibt quasie
// Die Funktionen durch
// Zuständig für alles was mit dem User selbst zu tun hat
public interface UserServiceRepository {

    // Uservalidating beim Anmelden
    boolean validateUserLogin(UserRec user);

    boolean usernameAlreadyTaken(String username);
}
