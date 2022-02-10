package stellarbytestudios.socialboard.database.security;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordHashing {
    
    private static String HASH_ALGORITHM = "SHA3-512";

    // Neues Salz erzeugen
    public static byte[] createSalt() {
        // Salzstreuer bauen
        byte[] salt = new byte[4];
        SecureRandom randomGenerator = new SecureRandom();
        // Salz ausschütten
        randomGenerator.nextBytes(salt);

        // Salz zurückgeben
        return salt;
    }

    public static String hashPasswordWithIntsalt(String password, int salt){
        // Erstmal Salz nutzbar machen
        byte[] saltarray = saltIntToByte(salt);
        // Jetzt einfach hashen und returnen
        return hashPassword(password, saltarray);
    }
    // Neues Password mit Salz(Byte) hashen
    public static String hashPassword(String password, byte[] salt){

        // Neuen "Hasher" erzeugen
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Hashalgorithmus falsch gewählt");
            e.printStackTrace();
            return "";
        }

        // Password Würzen
        messageDigest.reset();
        messageDigest.update(salt);

        // Passwort in den Hasher stecken
        messageDigest.update(password.getBytes());

        // HashCode wird als ByteArray ausgelesen
        byte[] hashCodeByte = messageDigest.digest();

        // Jetzt müssen wir den AusgabeString zusammen packen
        StringBuilder stringBuilder = new StringBuilder();

        for (byte codeByte : hashCodeByte) {
            stringBuilder.append(String.format("%02x", codeByte));
        }

        return stringBuilder.toString();
    }

    // Salz von ByteArray zum speicherbaren String convertieren
    public static int saltByteToInt(byte[] bytearray){
        return ByteBuffer.wrap(bytearray).getInt();
    }

    // Salz vom gespeicherten String wieder zum ByteArray machen
    public static byte[] saltIntToByte(int saltInt){
        byte[] bytearray = ByteBuffer.allocate(4).putInt(saltInt).array();
        return bytearray;
    }


}
