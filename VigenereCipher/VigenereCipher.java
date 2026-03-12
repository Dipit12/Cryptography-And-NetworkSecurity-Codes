import java.util.*;

public class VigenereCipher {

    public static String expandKey(String key, String plainText) {
        key = key.toUpperCase();
        plainText = plainText.toUpperCase();

        String newKey = key;

        while (newKey.length() < plainText.length()) {
            newKey += key;
        }

        // trim the extra part
        return newKey.substring(0, plainText.length());
    }

    public static String encrypt(String plainText, String expandedKey) {
        StringBuilder encryptedKey = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            char key = expandedKey.charAt(i);

            int value = (ch - 'A' + key - 'A') % 26;
            char encryptedChar = (char) (value + 'A');
            encryptedKey.append(encryptedChar);
        }

        return encryptedKey.toString();
    }

    public static String decrypt(String encryptedText, String expandedKey) {
        StringBuilder decryptedKey = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i++) {
            char ch = encryptedText.charAt(i);
            char key = expandedKey.charAt(i);

            int value = (ch - key + 26) % 26;
            char decryptedChar = (char) (value + 'A');

            decryptedKey.append(decryptedChar);
        }

        return decryptedKey.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the plaintext");
        String plainText = input.nextLine();
        System.out.println("Enter the key");
        String key = input.nextLine();

        String expandedKey = expandKey(key, plainText);

        String encryptedText = encrypt(plainText, expandedKey);
        String decryptedText = decrypt(encryptedText, expandedKey);

        System.out.println("Encrypted Text is: " + encryptedText);
        System.out.println("Decrypted Text is: " + decryptedText);
    }
}
