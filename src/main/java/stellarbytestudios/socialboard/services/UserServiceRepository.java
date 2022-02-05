package stellarbytestudios.socialboard.services;

import stellarbytestudios.socialboard.core.UserRec;


// Dieses Interface gibt an, was von dem Datenbankpackage verlangt wird
// Es wird von UserServiceRepositoryImpl implementiert und Spring gibt quasie
// Die Funktionen durch
public interface UserServiceRepository {

    // Uservalidating
    boolean validateUserLogin(UserRec user);
}
