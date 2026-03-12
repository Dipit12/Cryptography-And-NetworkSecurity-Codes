/*
 Hill Cipher
 -----------
 Hill cipher is a polygraphic substitution cipher
 based on matrix multiplication.

 Letters are converted to numbers:
 A = 0, B = 1, ... Z = 25

 Encryption:
 C = P × K mod 26

 Decryption:
 P = C × K^-1 mod 26
*/

import java.util.Scanner;

public class HillCipher {

    // 3x3 Key Matrix
    static int[][] keyMatrix = { { 1, 2, 1 }, { 2, 3, 2 }, { 2, 2, 1 } };

    // Inverse Matrix for Decryption
    static int[][] inverseMatrix = {
        { -1, 0, 1 },
        { 2, -1, 0 },
        { -2, 2, -1 },
    };

    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Plaintext:");
        String text = sc.next().toUpperCase().replaceAll("\\s", "");

        // Padding with X if length not multiple of 3
        while (text.length() % 3 != 0) {
            text += "X";
        }

        System.out.println("Padded Text: " + text);

        String encrypted = "";
        String decrypted = "";

        char[] arr = text.toCharArray();

        // Encrypt every 3 characters
        for (int i = 0; i < text.length(); i += 3) {
            encrypted += encrypt(arr[i], arr[i + 1], arr[i + 2]);
        }

        System.out.println("Encrypted Text: " + encrypted);

        char[] encArr = encrypted.toCharArray();

        // Decrypt
        for (int i = 0; i < encrypted.length(); i += 3) {
            decrypted += decrypt(encArr[i], encArr[i + 1], encArr[i + 2]);
        }

        System.out.println("Decrypted Text: " + decrypted);
    }

    // Encryption of 3 characters
    static String encrypt(char a, char b, char c) {
        int x, y, z;

        int p1 = a - 65;
        int p2 = b - 65;
        int p3 = c - 65;

        // Matrix multiplication
        x = p1 * keyMatrix[0][0] + p2 * keyMatrix[1][0] + p3 * keyMatrix[2][0];
        y = p1 * keyMatrix[0][1] + p2 * keyMatrix[1][1] + p3 * keyMatrix[2][1];
        z = p1 * keyMatrix[0][2] + p2 * keyMatrix[1][2] + p3 * keyMatrix[2][2];

        char c1 = alphabet.charAt(x % 26);
        char c2 = alphabet.charAt(y % 26);
        char c3 = alphabet.charAt(z % 26);

        return "" + c1 + c2 + c3;
    }

    // Decryption
    static String decrypt(char a, char b, char c) {
        int x, y, z;

        int p1 = a - 65;
        int p2 = b - 65;
        int p3 = c - 65;

        x =
            p1 * inverseMatrix[0][0] +
            p2 * inverseMatrix[1][0] +
            p3 * inverseMatrix[2][0];
        y =
            p1 * inverseMatrix[0][1] +
            p2 * inverseMatrix[1][1] +
            p3 * inverseMatrix[2][1];
        z =
            p1 * inverseMatrix[0][2] +
            p2 * inverseMatrix[1][2] +
            p3 * inverseMatrix[2][2];

        char c1 = alphabet.charAt(((x % 26) + 26) % 26);
        char c2 = alphabet.charAt(((y % 26) + 26) % 26);
        char c3 = alphabet.charAt(((z % 26) + 26) % 26);

        return "" + c1 + c2 + c3;
    }
}
