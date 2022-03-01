package stellarbytestudios.socialboard.DBtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import stellarbytestudios.socialboard.core.UserRec;
import stellarbytestudios.socialboard.database.DBcommunication.UserCrudRepo;
import stellarbytestudios.socialboard.database.ServiceCommunication.UserHandlingRepositoryImpl;

import java.sql.*;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
public class SaveAndGetData {

    // Initialisierung
    @Autowired
    UserCrudRepo dataBase;

    UserHandlingRepositoryImpl repoImpl;

    @BeforeEach
    public void setup(){
        repoImpl = new UserHandlingRepositoryImpl(dataBase);
    }


    // Bereits angelegten User Validieren
    @Test
    @DisplayName("User in der Datenbank Validieren (ist vorhanden)")
    public void validateUser1(){
        UserRec userRec = new UserRec(0, "Schüler1", "123");

        boolean verified = repoImpl.validateUserLogin(userRec);

        assertThat(verified).isTrue();
    }
    // Falsches Password
    @Test
    @DisplayName("Falsches Password validiert nicht")
    public void validateUser2() {
        UserRec wrongUser = new UserRec(0, "Schüler1", "1234");

        boolean verified = repoImpl.validateUserLogin(wrongUser);

        assertThat(verified).isFalse();
    }

    // Nicht vorhandener User suchen
    @Test
    @DisplayName("User nicht abgespeichert")
    public void userNotFound() {
        UserRec wrongUser = new UserRec(0, "NotAvailable", "not there");

        boolean verified = repoImpl.validateUserLogin(wrongUser);

        assertThat(verified).isFalse();
    }

    // Drops aus der Datenbank holen

    // Neuen Nutzer anlegen (Ohne Drops)

    // Drops hinzufügen

    // Drops bearbeiten

    // Drop Löschen

//    @Test
//    @DisplayName("Test Saving")
//    public void saving_1() {
//
//        UserDTO hannes = new UserDTO(1l,
//                "Hannes3",
//                459734,
//                "464a5f9e3614a3456c3d543434d6354f3a41c254b34",
//                new HashSet<>());
//
//        database.save(hannes);
//
//        UserDTO meep = new UserDTO(2l,
//                "Meep",
//                196741,
//                "464a5f9e3614a3456c3d543434d6354f3a41c254b34",
//                new HashSet<>());
//        database.save(meep);
//        assertThat(true).isTrue();
//    }
    // * * * *
//        Connection connection= DriverManager.getConnection("jdbc:h2:mem:test");
//        Statement s=connection.createStatement();
//        s.execute("-- für den Fall der Fälle --\n" +
//                "drop table if exists Drops;\n" +
//                "drop table if exists Users;\n" +
//                "\n" +
//                "-- Erzeugen der Tabelle in der die Userdaten gespeichert werden --\n" +
//                "create table Users\n" +
//                "(\n" +
//                "    -- userId ist der Primärschlüssel --\n" +
//                "\tuserID int not null auto_increment,\n" +
//                "\t-- Daten des Users --\n" +
//                "\tusername varchar(100) default 'defaultusername' not null,\n" +
//                "\tuserpasswordsalt int default 123456789 not null,\n" +
//                "\tuserpasswordhash varchar(130) default 'someHash' not null,\n" +
//                "\t-- Macht die ID zum Primärschlüssel --\n" +
//                "\tconstraint Users_pk primary key (userID)\n" +
//                ");\n" +
//                "\n" +
//                "-- Macht die ID des User einzigartig (keine doppelten IDs) --\n" +
//                "create unique index Users_userID_uindex\n" +
//                "\ton Users (userID);\n" +
//                "\n" +
//                "-- Erzeugen der Tabelle in der die ganzen Drops (Nachrichten) gespeichert werden --\n" +
//                "create table Drops (\n" +
//                "    -- dropIDId ist der Primärschlüssel --\n" +
//                "    dropID integer auto_increment,\n" +
//                "    -- Inhalt der nachicht --\n" +
//                "    content varchar(300),\n" +
//                "    -- Datum, an dem die Nachricht erstellt wurde --\n" +
//                "    creationDate datetime not null,\n" +
//                "    -- der Verfasser des Drops (ist auch ein Fremdschlüssel) --\n" +
//                "    User_DTO integer,\n" +
//                "    -- Macht die ID zum Primärschlüssel --\n" +
//                "    primary key (dropID),\n" +
//                "    -- Macht die Fremdschlüsselverknüpfung --\n" +
//                "    constraint Drops_Users_fk\n" +
//                "        foreign key (User_DTO) references Users (userID)\n" +
//                ");\n" +
//                "\n" +
//                "insert into Users (username, userpasswordsalt, userpasswordhash)\n" +
//                "values ('The First One', -1006375648, '56332867c05345993604df16ebff6130d016267419bd2ee6185a41c4b6d91a98df388079d03287fee6924627c8a4a2e26a1b615a7941cb5c7905e33dc127d31d'),\n" +
//                "       ('Schüler1', 1267670996, '3274e8f2d8e30aa640530e99f726159f2010b95c88e9dcedabaea06f68b69aeb41f45aa54f736f8d6225cc3818f254b22b509630604679f3e6ec2fbf3500b281');\n" +
//                "\n" +
//                "insert into Drops (content, creationDate, User_DTO)\n" +
//                "values ('The eins nicer erste Drop', CURRENT_TIMESTAMP, 1),\n" +
//                "        ('Zweiter nicer Drop', CURRENT_TIMESTAMP, 1),\n" +
//                "        ('Dritter wirklich interesanter Drop', CURRENT_TIMESTAMP, 1);");
//        PreparedStatement ps=connection.prepareStatement("select * from Users");
//        ResultSet r=ps.executeQuery();
//
//        ResultSetMetaData metaData = r.getMetaData();
//        System.out.println("*");
//        System.out.println("*");
//        System.out.println("*");
//        System.out.println("*");
//        while (r.next()) {
//            int count = metaData.getColumnCount();
//            for (int i = 1; i <= count; i++)
//            {
//                String columnName = metaData.getColumnName(i);
//                System.out.print("Der Columnname: " + columnName);
//                int type = metaData.getColumnType(i);
//                if (type == Types.VARCHAR || type == Types.CHAR) {
//                    System.out.println(";   Inhalt " + r.getString(columnName));
//                }
//                if (type==Types.INTEGER){
//                    System.out.println(";   Inhalt " + r.getInt(columnName));
//                }
//            }
//        }
//        System.out.println("*");
//        System.out.println("*");
//        System.out.println("*");
//        System.out.println("*");
//        r.close();
//        ps.close();
//        s.close();
//        connection.close();
//
//        // * * * *
//
//    // * * * *
//    @Test
//    public void testDatabaseMem() throws SQLException {
//        testDatabase("jdbc:h2:mem:test");
//    }
//
//    private void testDatabase(String url) throws SQLException {
//        Connection connection= DriverManager.getConnection(url);
//        Statement s=connection.createStatement();
//        try {
//            s.execute("DROP TABLE PERSON");
//        } catch(SQLException sqle) {
//            System.out.println("Table not found, not dropping");
//        }
//        s.execute("CREATE TABLE PERSON (ID INT PRIMARY KEY, FIRSTNAME VARCHAR(64), LASTNAME VARCHAR(64))");
//        PreparedStatement ps=connection.prepareStatement("select * from PERSON");
//        ResultSet r=ps.executeQuery();
//        if(r.next()) {
//            System.out.println("data?");
//        }
//        r.close();
//        ps.close();
//        s.close();
//        connection.close();
//    }

    // * * * *

}
