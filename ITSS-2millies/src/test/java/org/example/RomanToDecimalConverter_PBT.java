package org.example;
import net.jqwik.api.*;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.StatisticsReport;
import org.junit.jupiter.api.Assumptions;
import static org.junit.jupiter.api.Assertions.*;
import net.jqwik.api.statistics.Statistics;

public class RomanToDecimalConverter_PBT {
    @Property
    @StatisticsReport(format = Histogram.class)
    void convertRandomRomansIntoDecimalsTest(@ForAll("randomRomaNumbers") String romanNumber) {
        int decimalNumber = RomanToDecimalConverter.convertRomanToDecimal(romanNumber);
        assertTrue(decimalNumber >= 0);
        Statistics.collect(decimalNumber == 0 ? "isNotValid" : "isValid");
        //al livello di stat stiamo tenendo traccia di quelli che sono i numeri romani validi che
        //effettivamente abbiamo convertito in decimali
    }
    @Property
    @StatisticsReport(format = Histogram.class)
    void checkConvertedRomanNumberFromRandomIntegersTest(@ForAll("Integers") int decimalNumber) {
        String romanNumber = RomanToDecimalConverter.convertDecimalToRoman(decimalNumber);
        boolean ispositive = false;
        if (!romanNumber.isEmpty()){
            ispositive = true;
            assertTrue(RomanToDecimalConverter.isValidRomanNumber(romanNumber));
        }
        Statistics.collect(ispositive ? "ValidRomanNumber" : "NotValidRomanNumber");
        //al livello di stat stiamo tenendo traccia di quanti numeri romani abbiamo convertito
        //con successo partendo da un numero decimale che può essere negativo
    }
    @Property
    @StatisticsReport(format = Histogram.class)
    void isPalindromeStatisticsTest(@ForAll("palindromicRomanNumbers") String romanNumber) {
        boolean isPalindrome = RomanToDecimalConverter.isPalindrome(romanNumber);
        Statistics.collect(isPalindrome ? "Palindrome" : "NotPalindrome");
        //stat di quali sono e non sono palindromi
    }
    @Property
    @StatisticsReport(format = Histogram.class)
    void interdependentNumbersShouldBeDivisibleTest(@ForAll("randomRomaNumbers") String romanNumber1,
                                                    @ForAll("randomRomaNumbers") String romanNumber2) {
        // Ensure numbers are different
        Assumptions.assumeTrue(!romanNumber1.equals(romanNumber2));

        // Convert Roman numbers to decimals
        int decimal1 = RomanToDecimalConverter.convertRomanToDecimal(romanNumber1);
        int decimal2 = RomanToDecimalConverter.convertRomanToDecimal(romanNumber2);

        // Ensure both decimals are non-zero before performing division
        Assumptions.assumeTrue(decimal1 != 0 && decimal2 != 0);

        // Check if the numbers are interdependent
        boolean areInterdependent = RomanToDecimalConverter.areInterdependent(romanNumber1, romanNumber2);

        // Check divisibility only if the numbers are interdependent
        if (areInterdependent) {
            assertTrue(decimal1 % decimal2 == 0 || decimal2 % decimal1 == 0);
        }
        Statistics.collect(areInterdependent == true ? "IsInterdipendent" : "IsNotInterdipendet");
        //stat di quali sono tra loro divisibili e quali non.
    }
    //abbiamo definito un generatore chiamato validRomanNumbers che genera stringhe rappresentanti numeri romani validi.
    // Questo generatore viene quindi utilizzato nel test converted_decimal_should_be_greater_than_zero per fornire valori
    // validi di numeri romani.
    //ogni provide genera i valori appropriati per ogni test altrimenti il framework di jqwik non riesce a generare i valori
    //richiesti per i test
    @Provide
    Arbitrary<String> randomRomaNumbers() {
        return Arbitraries.strings().withChars('I','V','X','L','C','D','M').ofMinLength(0).ofMaxLength(9);
    }
    @Provide
    Arbitrary<Integer> Integers() {
        return Arbitraries.integers().between(-1999, 2000);
    }
    @Provide
    Arbitrary<String> palindromicRomanNumbers() {
        return Arbitraries.strings().withCharRange('I', 'M').ofMinLength(1).ofMaxLength(9);
    }
}

