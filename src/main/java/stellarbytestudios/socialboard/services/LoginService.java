package stellarbytestudios.socialboard.services;

import org.springframework.stereotype.Service;
import stellarbytestudios.socialboard.core.UserRec;

// Dieser Service wird vom Anmeldungs-Controller aufgerufen um die Kommunikation mit dem Kern der Anwendung
// zu gewährleisten
@Service
public class LoginService {

    // * * Kopf * * //
    // Verbindung zu den Interfaces im gleichen Package
    private final UserHandlingRepository userRepo;
    // Diese brauchen einen Konstruktor:
    public LoginService(UserHandlingRepository userRepo) {
        this.userRepo = userRepo;
    }

    // * * Methoden * * //
    // Methoden zum validieren
    public boolean validateUserLogin(String name, String password){
        return userRepo.validateUserLogin(name, password);
    }
}
