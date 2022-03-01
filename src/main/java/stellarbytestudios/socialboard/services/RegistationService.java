package stellarbytestudios.socialboard.services;

import org.springframework.stereotype.Service;

// Dieser Service wird vom Registrierungs-Controller aufgerufen um die Kommunikation mit dem Kern der Anwendung
// zu gewährleisten. Dieser hier ist zum überprüfen und Speichern neuner Nutzer
@Service
public class RegistationService {

    // * * Kopf * * //
    // Verbindung zu den Interfaces im gleichen Package
    private final UserHandlingRepository userRepo;
    // Diese brauchen einen Konstruktor:
    public RegistationService(UserHandlingRepository userRepo) {
        this.userRepo = userRepo;
    }


    // * * Methoden * * //
    // Schaut nach, ob es diesen Nutzernamen bereits gibt
    public boolean usernameAlreadyTaken(String username) {
        return userRepo.usernameAlreadyTaken(username);
    }

    // Legt einen neuen Nutzer in der Datenbank an
    public void createNewUser(String name, String password) {
        userRepo.createNewUser(name, password);
    }
}
