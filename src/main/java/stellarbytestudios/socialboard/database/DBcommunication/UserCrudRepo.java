package stellarbytestudios.socialboard.database.DBcommunication;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import stellarbytestudios.socialboard.database.DTOs.UserDTO;

import java.util.List;

// Dieses Interface ist die direkte Verbindung zur Datenbank. Es wird von
// UserServiceRepositoryImpl benutzt um mit der Datenbank zu sprechen
// Dank des CrudRepositorys werden fiele Datenbankoperationen wie findAll() oder
// save() einfach mitgeliefert. Andere müssen nur noch deklariert werden wie
// Find by... aber man kann in der Not auch händisch Querys schreiben
public interface UserCrudRepo extends CrudRepository<UserDTO, Long> {

}
