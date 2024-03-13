package org.example;
import net.jqwik.api.*;
import net.jqwik.time.api.arbitraries.CalendarArbitrary;
import org.junit.jupiter.api.Assumptions;

import java.util.Random;
import static org.assertj.core.api.Assertions.*;
import static org.example.RomanToDecimalConverter.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

            //TODO: RISOLVERE I METODI INUTILIZZATI
            //TODO: PERCHE' LA CLASSE è ROSSA???????
            //TODO: AGGIUNGERE STAMPA STATISTICHE JQWIK VEDI DOCUMENTAZIONE

public class RomanToDecimalConverter_PBT {
    @Property
    void converted_decimal_should_be_greater_than_zero(@ForAll("validRomanNumbers") String romanNumber) {
        int decimalNumber = RomanToDecimalConverter.convertRomanToDecimal(romanNumber);
        assertTrue(decimalNumber >= 0);
    }

    @Property
    void converted_roman_should_be_a_valid_roman_number(@ForAll("positiveIntegers") int decimalNumber) {
        String romanNumber = RomanToDecimalConverter.convertDecimalToRoman(decimalNumber);
        assertTrue(RomanToDecimalConverter.isValidRomanNumber(romanNumber));
    }

    @Provide
    Arbitrary<String> validRomanNumbers() {
        return Arbitraries.strings().withCharRange('I', 'M').ofMinLength(1).ofMaxLength(10);
    }

    @Provide
    Arbitrary<Integer> positiveIntegers() {
        return Arbitraries.integers().between(1, 3999);
    }

    @Property
    void palindrome_should_return_true_for_palindromic_roman_numbers(@ForAll("palindromicRomanNumbers") String romanNumber) {
        assertTrue(RomanToDecimalConverter.isPalindrome(romanNumber));
    }

    @Provide
    Arbitrary<String> palindromicRomanNumbers() {
        return Arbitraries.strings().withCharRange('I', 'M').ofMinLength(1).ofMaxLength(10)
                .filter(RomanToDecimalConverter::isPalindrome);
    }

    @Property
    void interdependent_numbers_should_be_divisible(@ForAll("validRomanNumbers") String romanNumber1,
                                                    @ForAll("validRomanNumbers") String romanNumber2) {
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
    }



}
