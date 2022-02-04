package stellarbytestudios.socialboard.database.DTOs;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("Drops")
public class DropDTO {

    // Daten die in der Datenbank gespeichert werden
    @Column("content")
    private String content;
    @Column("creationDate")
    private LocalDateTime dateOfWriting;

    //  * * Notwendige Methoden für die Datenbank * * //
    // Konstruktor um das DTO zu erstellen
    public DropDTO(String content, LocalDateTime dateOfWriting) {
        this.content = content;
        this.dateOfWriting = dateOfWriting;
    }

    // * * Zusatzmethoden * * //

    // Getter
    public String getContent() {
        return content;
    }
    public LocalDateTime getDateOfWriting() {
        return dateOfWriting;
    }

    @Override
    public String toString() {
        return "DropDTO{" +
                "content='" + content + '\'' +
                ", dateOfWriting=" + dateOfWriting +
                '}';
    }
}
