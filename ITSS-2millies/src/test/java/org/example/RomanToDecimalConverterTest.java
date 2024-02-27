package org.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

class RomanToDecimalConverterTest {

    //TODO: test con insieme di dati sempre validi: ["III", "IV", "IX"...]

    //TODO: test con insieme di dati mai validi: ["MMMMMMIII", "IADBHV", stringhe molto lunghe...]

    //TODO: test con insieme di dati alcuni validi ed altri no

    //TODO: test con casi limite: [passando null, numeri non validi, ecc..]

    @Test
    @DisplayName("Test convertRomanToDecimal")
    void testConvertRomanToDecimal() {
        Assertions.assertEquals(3, RomanToDecimalConverter.convertRomanToDecimal("III"));
        Assertions.assertEquals(4, RomanToDecimalConverter.convertRomanToDecimal("IV"));
        Assertions.assertEquals(9, RomanToDecimalConverter.convertRomanToDecimal("IX"));
        Assertions.assertEquals(58, RomanToDecimalConverter.convertRomanToDecimal("LVIII"));
        Assertions.assertEquals(1994, RomanToDecimalConverter.convertRomanToDecimal("MCMXCIV"));
    }

    @Test
    @DisplayName("Test convertDecimalToRoman")
    void testConvertDecimalToRoman() {
        Assertions.assertEquals("III", RomanToDecimalConverter.convertDecimalToRoman(3));
        Assertions.assertEquals("IV", RomanToDecimalConverter.convertDecimalToRoman(4));
        Assertions.assertEquals("IX", RomanToDecimalConverter.convertDecimalToRoman(9));
        Assertions.assertEquals("LVIII", RomanToDecimalConverter.convertDecimalToRoman(58));
        Assertions.assertEquals("MCMXCIV", RomanToDecimalConverter.convertDecimalToRoman(1994));
    }

    @Test
    @DisplayName("Test isValidRomanNumber")
    void testIsValidRomanNumber() {
        Assertions.assertTrue(RomanToDecimalConverter.isValidRomanNumber("III"));
        Assertions.assertTrue(RomanToDecimalConverter.isValidRomanNumber("XLII"));
        Assertions.assertFalse(RomanToDecimalConverter.isValidRomanNumber("ABC"));
        Assertions.assertTrue(RomanToDecimalConverter.isValidRomanNumber("IC"));
    }

    @Test
    @DisplayName("Test areInterdependent")
    void testAreInterdependent() {
        Assertions.assertTrue(RomanToDecimalConverter.areInterdependent("III", "I"));
        Assertions.assertFalse(RomanToDecimalConverter.areInterdependent("IV", "VI"));
    }

    @Test
    @DisplayName("Test isPalindrome")
    void testIsPalindrome() {
        Assertions.assertTrue(RomanToDecimalConverter.isPalindrome("IXI"));
        Assertions.assertFalse(RomanToDecimalConverter.isPalindrome("XIV"));
    }
}
