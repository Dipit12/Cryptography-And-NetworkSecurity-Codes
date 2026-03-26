import java.math.*;
import java.util.*;

public class Permutation {

    // Initial Permutation Table
    static int[] IP = {
        58,
        50,
        42,
        34,
        26,
        18,
        10,
        2,
        60,
        52,
        44,
        36,
        28,
        20,
        12,
        4,
        62,
        54,
        46,
        38,
        30,
        22,
        14,
        6,
        64,
        56,
        48,
        40,
        32,
        24,
        16,
        8,
        57,
        49,
        41,
        33,
        25,
        17,
        9,
        1,
        59,
        51,
        43,
        35,
        27,
        19,
        11,
        3,
        61,
        53,
        45,
        37,
        29,
        21,
        13,
        5,
        63,
        55,
        47,
        39,
        31,
        23,
        15,
        7,
    };
    // Final Permutation Table
    static int[] FP = {
        40,
        8,
        48,
        16,
        56,
        24,
        64,
        32,
        39,
        7,
        47,
        15,
        55,
        23,
        63,
        31,
        38,
        6,
        46,
        14,
        54,
        22,
        62,
        30,
        37,
        5,
        45,
        13,
        53,
        21,
        61,
        29,
        36,
        4,
        44,
        12,
        52,
        20,
        60,
        28,
        35,
        3,
        43,
        11,
        51,
        19,
        59,
        27,
        34,
        2,
        42,
        10,
        50,
        18,
        58,
        26,
        33,
        1,
        41,
        9,
        49,
        17,
        57,
        25,
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the input string");
        String inputString = input.nextLine();

        // convert hex to binary
        String binaryString = String.format(
            "%64s",
            new java.math.BigInteger(inputString, 16).toString(2)
        ).replace(' ', '0');
        System.out.println("Binary string: " + binaryString);

        // apply initial Permutation
        String ipResult = permutate(binaryString, IP);
        System.out.println("Initial Permutation result: " + ipResult);

        // apply final Permutation
        String fpResult = permutate(ipResult, FP);
        System.out.println("Final permutation result: " + fpResult);

        // convert binary to hex
        String hexResult = new java.math.BigInteger(fpResult, 2).toString(16);
        System.out.println("Hex result: " + hexResult);
    }

    static String permutate(String input, int[] table) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            output.append(input.charAt(table[i] - 1));
        }
        return output.toString();
    }
}
