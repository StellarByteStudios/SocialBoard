package stellarbytestudios.socialboard.services;

import org.springframework.stereotype.Service;
import stellarbytestudios.socialboard.core.UserRec;

// Dieser Service wird vom Controller Aufgerufen um die Kommunikation mit dem Kern der Anwendung
// Zu gewährleisten
@Service
public class LoginService {

    // Verbindung zu den Interfaces im gleichen Package
    private final UserHandlingRepository userRepo;

    // Diese brauchen einen Konstruktor:
    public LoginService(UserHandlingRepository userRepo) {
        this.userRepo = userRepo;
    }


    // Methoden zum validieren
    public boolean validateUserLogin(UserRec user){
        return userRepo.validateUserLogin(user);
    }
}
