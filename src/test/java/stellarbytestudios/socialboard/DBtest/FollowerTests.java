package stellarbytestudios.socialboard.DBtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import stellarbytestudios.socialboard.core.UserRec;
import stellarbytestudios.socialboard.database.DBcommunication.UserCrudRepo;
import stellarbytestudios.socialboard.database.ServiceCommunication.DropsHandlingRepositoryImpl;
import stellarbytestudios.socialboard.database.ServiceCommunication.UserHandlingRepositoryImpl;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static stellarbytestudios.socialboard.DBtest.TemplatesForDBTests.*;

@DataJdbcTest
public class FollowerTests {

    // Initialisierung
    @Autowired
    UserCrudRepo dataBase;

    UserHandlingRepositoryImpl userRepoImpl;
    DropsHandlingRepositoryImpl dropRepoImpl;

    // Vor jedem Test werden die Repos neu initialisiert
    @BeforeEach
    public void setup(){
        userRepoImpl = new UserHandlingRepositoryImpl(dataBase);
        dropRepoImpl = new DropsHandlingRepositoryImpl(dataBase);
    }


    // Bereits angelegten User Validieren
    @Test
    @DisplayName("Einen Follower durch die Id bekommen")
    public void getFollower1(){
        // Daten herholen
        Long toSearchId = MULLER.id();
        String nameMagret = MAGRET.name();

        UserRec magret = new UserRec(nameMagret,
                dropRepoImpl.getDropsOfUser(nameMagret),
                new HashSet<>());
        // Hole alle Follower aus der Datenbank
        Set<UserRec> follower = userRepoImpl.getFollowerByUserId(toSearchId);


        assertThat(follower).contains(magret);
    }

    @Test
    @DisplayName("Mehrere Follower durch die Id bekommen")
    public void getFollower2(){
        // Daten herholen
        Long toSearchId = HANK.id();
        String nameMagret = MAGRET.name();
        String nameMuller = MULLER.name();

        // Hole alle Follower aus der Datenbank
        Set<UserRec> follower = userRepoImpl.getFollowerByUserId(toSearchId);

        // Einfachere Methode nach den Followern zu überprüfen
        assertThat(follower).hasSize(2);
        assertThat(follower).extracting(UserRec::username).contains(nameMagret, nameMuller);
    }
}