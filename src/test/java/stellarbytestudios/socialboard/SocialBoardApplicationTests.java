package stellarbytestudios.socialboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import stellarbytestudios.socialboard.database.DTOs.DropDTO;
import stellarbytestudios.socialboard.database.DTOs.UserDTO;
import stellarbytestudios.socialboard.database.Repositories.UserRepo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class SocialBoardApplicationTests {

    @Autowired
    private UserRepo userRepo;

    @Test
    void contextLoads() {

        // Einfachen User mit 3 Drops hinzufügen
        Set<DropDTO> drops = new HashSet<>();
        drops.add(new DropDTO("This is eins nice Drop",
                LocalDateTime.now()));
        drops.add(new DropDTO("This is der zweite nice Drop eine Stunde Später",
                LocalDateTime.now().plusHours(1)));
        drops.add(new DropDTO("This is der dritte nice Drop von vor 5 Stunden",
                LocalDateTime.now().minusHours(5)));

        UserDTO user1 = new UserDTO(null, "The first One", "supadupaSecred", drops);
        userRepo.save(user1);
        System.out.println("Einfachen User mit 3 Drops hinzufügen");
        System.out.println(userRepo.findAll());
        System.out.println();

        // Weiteren Drop hinzufügen
        user1.addDrop(new DropDTO("Der Nachkömmling",
                LocalDateTime.now()));
        userRepo.save(user1);
        System.out.println("Weiteren Drop hinzufügen");
        System.out.println(userRepo.findAll());
        System.out.println();


        // Weiteren User ohne Drops hinzufügen
        UserDTO user2 = UserDTO.create(null, "Schüler1", "123");
        userRepo.save(user2);
        System.out.println("Weiteren User ohne Drops hinzufügen");
        System.out.println(userRepo.findAll());
        System.out.println();

        // Dieser Droped was
        DropDTO dropUser2 = new DropDTO("Legen   ...   dary", LocalDateTime.now());
        user2.addDrop(dropUser2);
        userRepo.save(user2);
        System.out.println("Dieser Droped was");
        System.out.println(userRepo.findAll());
        System.out.println();

        // Jetzt Löscht der Erste einen Eintrag
        user1.removeDropByContent("This is eins nice Drop");
        userRepo.save(user1);
        System.out.println("Jetzt Löscht der Erste einen Eintrag (Den ersten)");
        System.out.println(userRepo.findAll());
        System.out.println();

        // Jetzt Ändert der Zweite seinen Eintrag
        user2.changeDropcontent("Legen   ...   dary", "MOOOOR LEGENNNNDAAAARY");
        userRepo.save(user2);
        System.out.println("Jetzt Ändert der Zweite seinen Eintrag");
        System.out.println(userRepo.findAll());
        System.out.println();

        // Alle Testdaten löschen
        userRepo.deleteAll();
        System.out.println("Alle Testdaten löschen");
        System.out.println(userRepo.findAll());
        System.out.println();
    }

}
