package stellarbytestudios.socialboard.services;

import org.springframework.stereotype.Service;

@Service
public class RegistationService {

    // Verbindung zu den Interfaces im gleichen Package
    private final UserHandlingRepository userRepo;

    // Diese brauchen einen Konstruktor:
    public RegistationService(UserHandlingRepository userRepo) {
        this.userRepo = userRepo;
    }

    public boolean usernameAlreadyTaken(String username) {
        return userRepo.usernameAlreadyTaken(username);
    }

    public void createNewUser(String name, String password) {
        userRepo.createNewUser(name, password);
    }
}
