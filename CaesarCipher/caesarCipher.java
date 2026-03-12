import java.util.*;

public class caesarCipher {

    public static String encrypt(String plainText, int key) {
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);

            // CASE 1: character is uppercase
            if (Character.isUpperCase(ch)) {
                char encryptedChar = (char) (((ch - 'A' + key) % 26) + 'A');
                cipherText.append(encryptedChar);
            }
            // CASE 2: character is lowercase
            else if (Character.isLowerCase(ch)) {
                char encryptedChar = (char) (((ch - 'a' + key) % 26) + 'a');
                cipherText.append(encryptedChar);
            }
            // CASE 3: character is a space
            else {
                cipherText.append(' ');
            }
        }

        return cipherText.toString();
    }

    public static String decrypt(String cipherText, int key) {
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);

            // CASE 1: character is uppercase
            if (Character.isUpperCase(ch)) {
                char decryptedChar = (char) (((ch - 'A' - key) % 26) + 'A');
                plainText.append(decryptedChar);
            }
            // CASE 2: character is lowercase
            else if (Character.isLowerCase(ch)) {
                char decryptedChar = (char) (((ch - 'a' - key) % 26) + 'a');
                plainText.append(decryptedChar);
            }
            // CASE 3: whitespace
            else {
                plainText.append(' ');
            }
        }

        return plainText.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the plaintext");
        String plainText = input.nextLine();
        System.out.println("Enter the key");
        int key = input.nextInt();
        String cipherText = encrypt(plainText, key);
        System.out.println("Ciphertext: " + cipherText);
        String decryptedText = decrypt(cipherText, key);
        System.out.println("DecryptedText: " + decryptedText);
    }
}
