package stellarbytestudios.socialboard.database.DTOs;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("Users")
public class UserDTO {

    // Daten die in der Datenbank gespeichert werden
    @Id
    @Column("userID")
    private Long id;
    @Column("username")
    private String username;
    @Column("userpassword")
    private String password;
    // Verknüpfung zu den Drops (ein Nutzer kann mehrere Drops verfassen)
    private Set<DropDTO> dropDTOS;

    //  * * Notwendige Methoden für die Datenbank * * //
    // Set ID brauch Spring um den Autoinkrement anzupassen
    public void setID(Long newID) { this.id = newID; }

    // Konstruktor um das DTO zu erstellen
    public UserDTO(Long id, String username, String password, Set<DropDTO> dropDTOS) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.dropDTOS = dropDTOS;
    }


    // Zusatzmethoden
    public void addDrop(DropDTO dropDTO){ this.dropDTOS.add(dropDTO); }

    @Override
    public String toString() {
        String info = "\nThe User with the Name: " + username +
                        " and the ID: " + id +
                        " have this password: " + password +
                        " and the following Drops: ";
        int counter = 0;
        for (DropDTO drop : dropDTOS) {
            info += "\n\tDrop " + counter + ": " + drop;
            counter++;
        }
        return info;
//        return "User{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", drops=" + dropDTOS +
//                '}';
    }
}
