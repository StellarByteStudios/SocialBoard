package stellarbytestudios.socialboard.database.DTOs;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import stellarbytestudios.socialboard.core.UserRec;

import java.util.HashSet;
import java.util.Set;

import static stellarbytestudios.socialboard.database.security.PasswordHashing.*;

@Table("USERS")
public class UserDTO {

    // Daten die in der Datenbank gespeichert werden
    @Id
    @Column("USERID")
    private Long id;
    @Column("USERNAME")
    private String username;
    @Column("USERPASSWORDSALT")
    private int passwordsalt;
    @Column("USERPASSWORDHASH")
    private String passwordhash;
    // Verknüpfung zu den Drops (ein Nutzer kann mehrere Drops verfassen)
    private Set<DropDTO> dropDTOS;

    //  * * Notwendige Methoden für die Datenbank * * //
    // Set ID brauch Spring um den Autoinkrement anzupassen
    public void setID(Long newID) { this.id = newID; }

    // Konstruktor um das DTO zu erstellen
    public UserDTO(Long id, String username, int passwordsalt, String passwordhash, Set<DropDTO> dropDTOS) {
        this.id = id;
        this.username = username;
        this.passwordsalt = passwordsalt;
        this.passwordhash = passwordhash;
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
        // Erst das Password neu Hashen
        byte[] salt = createSalt();
        // Salz holen und zum speichern präparieren
        int saltAsInt = saltByteToInt(salt);

        // Hashen des Passwortes
        String hashcode = hashPasswordWithIntsalt(password, saltAsInt);

        // Neuen Nutzer erzeugen
        return new UserDTO(id, username, saltAsInt, hashcode , new HashSet<>());
    }
    // Jetzt auch noch ohne ID
    public static UserDTO create(String username, String password) {
        return create(null, username, password);
    }

    @Override
    public String toString() {
        String info = "\nThe User with the Name: " + username +
                        " and the ID: " + id +
                        " have this passwordsalt: " + passwordsalt +
                        " the following passwordhash: " + passwordhash +
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
        // Nutzername vergleichen
        boolean equalUsername = this.username.equals(userRec.username());

        // Passwort vergleichen
        // das übergebene Password mit dem eingenen Salz hashen
        String paramHash = hashPasswordWithIntsalt(userRec.password(), this.passwordsalt);
        // Die zwei Hashcodes überprüfen
        boolean passwordhashes = this.passwordhash.equals(paramHash);
        return equalUsername && passwordhashes;
    }

    public String getUsername() {
        return username;
    }
    public Set<DropDTO> getDropDTOS() {
        return dropDTOS;
    }
}
