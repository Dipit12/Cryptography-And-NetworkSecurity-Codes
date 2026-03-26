import java.util.*;

public class SBox {

    public static void main(String[] args) {
        int[][] S1 = {
            { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
            { 0, 15, 7, 4, 14, 2, 13, 10, 3, 6, 12, 11, 9, 5, 3, 8 },
            { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
            { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 },
        };
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the input string");
        String inputString = input.nextLine();
        String row =
            "" +
            inputString.charAt(0) +
            inputString.charAt(inputString.length() - 1);
        int rowIndex = Integer.parseInt(row, 2);
        String col = inputString.substring(1, inputString.length() - 1);
        int colIndex = Integer.parseInt(col, 2);
        int output = S1[rowIndex][colIndex];
        System.out.println("Output is {" + output + "}");
        // output in decimal
        String outputString = Integer.toBinaryString(output);
        System.out.println("Output in binary is {" + outputString + "}");
    }
}
