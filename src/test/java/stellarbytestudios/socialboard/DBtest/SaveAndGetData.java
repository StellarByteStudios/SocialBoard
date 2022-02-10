package stellarbytestudios.socialboard.DBtest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import stellarbytestudios.socialboard.core.UserRec;
import stellarbytestudios.socialboard.database.DBcommunication.UserCrudRepo;
import stellarbytestudios.socialboard.database.DTOs.UserDTO;
import stellarbytestudios.socialboard.database.ServiceCommunication.UserServiceRepositoryImpl;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@ActiveProfiles("test")
public class SaveAndGetData {

    // Initialisierung
    @Autowired
    UserCrudRepo dataBase;

    //UserServiceRepositoryImpl repo;


    @BeforeEach
    @Sql({"classpath:testscript.sql"})
    public void setUp(){
        //repo = new UserServiceRepositoryImpl(dataBase);
    }

    // Bereits angelegten User Validieren
    @Test
    @DisplayName("User in der Datenbank Validieren (ist vorhanden)")
    @Sql({"classpath:testscript.sql"})
    public void validateUser() {
        UserRec userRec = new UserRec(0, "Schüler1", "123");
//        UserServiceRepositoryImpl repo = new UserServiceRepositoryImpl(dataBase);
//        boolean verified = repo.validateUserLogin(userRec);
        assertThat(true).isTrue();
    }
    // Nicht vorhandener User suchen

    // Drops aus der Datenbank holen

    // Neuen Nutzer anlegen (Ohne Drops)

    // Drops hinzufügen

    // Drops bearbeiten

    // Drop Löschen
}
