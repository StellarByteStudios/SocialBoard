package stellarbytestudios.socialboard.database.DBcommunication;

import org.springframework.data.repository.CrudRepository;
import stellarbytestudios.socialboard.database.DTOs.UserDTO;

public interface UserRepo extends CrudRepository<UserDTO, Long> {
}
