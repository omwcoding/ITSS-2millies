package org.example;


public class RomanToDecimalConverter {
    //Converte un numero decimale in un numero romano.
    public static int convertRomanToDecimal(String romanNumber) {
        if (romanNumber == null || romanNumber.length() == 0)
            return 0;

        int decimalNumber = 0;
        int prevValue = 0;

        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            int value = getRomanValue(romanNumber.charAt(i));
            if (value < prevValue)
                decimalNumber -= value;
            else
                decimalNumber += value;
            prevValue = value;
        }

        return decimalNumber;
    }

    private static int getRomanValue(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static String convertDecimalToRoman(int decimalNumber) {
        if (decimalNumber <= 0)
            return "";

        int[] decimalValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanNumber = new StringBuilder();
        int i = 0;
        while (decimalNumber > 0) {
            if (decimalNumber - decimalValues[i] >= 0) {
                romanNumber.append(romanSymbols[i]);
                decimalNumber -= decimalValues[i];
            } else {
                i++;
            }
        }

        return romanNumber.toString();
    }
    //Verifica se una stringa è un numero romano valido, controllando se contiene solo     caratteri validi (I, V, X, L, C, D, M).
    public static boolean isValidRomanNumber(String romanNumber) {
        String pattern = "^[IVXLCDM]+$";
        return romanNumber.matches(pattern);
    }
    //Verifica se due numeri romani sono interdipendenti, ossia se uno dei due numeri è     divisibile per l'altro.
    public static boolean areInterdependent(String romanNumber1, String romanNumber2) {
        int decimal1 = convertRomanToDecimal(romanNumber1);
        int decimal2 = convertRomanToDecimal(romanNumber2);
        return decimal1 % decimal2 == 0 || decimal2 % decimal1 == 0;
    }
    //Verifica se un numero romano è un palindromo, cioè se può essere letto allo          stesso modo sia da sinistra a destra che da destra a sinistra.
    public static boolean isPalindrome(String romanNumber) {
        String reversedRomanNumber = new StringBuilder(romanNumber).reverse().toString();
        return romanNumber.equals(reversedRomanNumber);
    }
}