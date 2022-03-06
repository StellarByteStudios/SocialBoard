package stellarbytestudios.socialboard.DBtest;

public class TemplatesForDBTests {

    // Sammlung an Nutzern
    public record UserTestData(Long id, String name, String password){}

    public static UserTestData THEFISTONE = new UserTestData(1L, "The First One", "hab ich vergessen...");
    public static UserTestData SCHULER = new UserTestData(2L, "Schüler1", "123");
    public static UserTestData SCHULERWRONGPASS = new UserTestData(2L, "Schüler1", "12345");
    public static UserTestData NOTINDATABASE = new UserTestData(2L, "NOTINDATABASE", "not avaiable");
    public static UserTestData MULLER = new UserTestData(3L, "TestingMüller", "Pass123");
    public static UserTestData MAGRET = new UserTestData(4L, "TestingMagret", "Magii123");
    public static UserTestData HANK = new UserTestData(5L, "TestingHank", "0987654321");

}
