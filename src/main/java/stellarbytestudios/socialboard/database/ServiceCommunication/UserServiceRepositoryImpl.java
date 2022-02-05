package stellarbytestudios.socialboard.database.ServiceCommunication;

import org.springframework.stereotype.Repository;
import stellarbytestudios.socialboard.database.DBcommunication.UserRepo;
import stellarbytestudios.socialboard.services.UserServiceRepository;

@Repository
public class UserServiceRepositoryImpl implements UserServiceRepository {

    UserRepo userRepo;
}
