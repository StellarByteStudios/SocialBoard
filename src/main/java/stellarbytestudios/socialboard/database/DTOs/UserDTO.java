package stellarbytestudios.socialboard.database.DTOs;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import stellarbytestudios.socialboard.core.UserRec;

import java.util.HashSet;
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

    // * * Zusatzmethoden * * //
    // Drop aus dem Set bekommen durch seinen Inhalt
    private DropDTO getDropWithString(String content){
        for(DropDTO drop : this.dropDTOS) {
            if (drop.getContent().equals(content)){
                return drop;
            }
        }
        return null;
    }

    // adding
    public void addDrop(DropDTO drop){
        this.dropDTOS.add(drop);
    }

    // removing
    public void removeDropByContent(String removal){
        removeDrop(getDropWithString(removal));
    }
    private void removeDrop(DropDTO drop){
        if (drop == null) { return; }
        this.dropDTOS.remove(drop);
    }
    // changing
    public void changeDropcontent(String removal, String newContent){
        DropDTO toChange = getDropWithString(removal);
        if (toChange == null) { return; }
        this.dropDTOS.remove(toChange);
        this.dropDTOS.add(new DropDTO(newContent, toChange.getDateOfWriting()));
    }

    // Factory für Erstellung ohne Drops (Alles außer der "Alles Konstruktor" verwirrt Spring Data JDBC)
    // Factory muss immer Statisch sein
    public static UserDTO create(Long id, String username, String password) {
        return new UserDTO(id, username, password, new HashSet<>());
    }
    // Jetzt auch noch ohne ID
    public static UserDTO create(String username, String password) {
        return new UserDTO(null, username, password, new HashSet<>());
    }

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
    }

    // Interaktion mit Records des Objekts
    public boolean equalsWithRecord(UserRec userRec){
        return (this.username.equals(userRec.username()) && this.password.equals(userRec.password()));
    }
}
