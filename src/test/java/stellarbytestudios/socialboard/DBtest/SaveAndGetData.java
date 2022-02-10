package stellarbytestudios.socialboard.DBtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.ActiveProfiles;
import stellarbytestudios.socialboard.database.DBcommunication.UserCrudRepo;
import stellarbytestudios.socialboard.database.ServiceCommunication.UserServiceRepositoryImpl;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@ActiveProfiles("test")
public class SaveAndGetData {

    // Initialisierung
    @Autowired
    UserCrudRepo dataBase;

    UserServiceRepositoryImpl repo;

    @BeforeEach
    public void setUp(){
        repo = new UserServiceRepositoryImpl(dataBase);
    }

    // User aus der Datenbank lesen
    @Test
    @DisplayName("User aus der Datenbank lesen")
    public void readUser() {

        assertThat(true).isTrue();
    }
    // Nicht vorhandener User suchen

    // Drops aus der Datenbank holen

    // Neuen Nutzer anlegen (Ohne Drops)

    // Drops hinzufügen

    // Drops bearbeiten

    // Drop Löschen
}
