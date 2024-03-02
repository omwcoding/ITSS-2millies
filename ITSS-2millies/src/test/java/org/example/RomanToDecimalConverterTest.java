package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

class RomanToDecimalConverterTest {

    @Test
    @DisplayName("Test convertRomanToDecimal with valid inputs")
    void testConvertRomanToDecimal_ValidInputs() {
        Assertions.assertEquals(1, RomanToDecimalConverter.convertRomanToDecimal("I"));
        Assertions.assertEquals(2, RomanToDecimalConverter.convertRomanToDecimal("II"));
        Assertions.assertEquals(3, RomanToDecimalConverter.convertRomanToDecimal("III"));
        Assertions.assertEquals(4, RomanToDecimalConverter.convertRomanToDecimal("IV"));
        Assertions.assertEquals(5, RomanToDecimalConverter.convertRomanToDecimal("V"));
        Assertions.assertEquals(9, RomanToDecimalConverter.convertRomanToDecimal("IX"));
        Assertions.assertEquals(58, RomanToDecimalConverter.convertRomanToDecimal("LVIII"));
        Assertions.assertEquals(500, RomanToDecimalConverter.convertRomanToDecimal("D"));
        Assertions.assertEquals(1994, RomanToDecimalConverter.convertRomanToDecimal("MCMXCIV"));
        Assertions.assertEquals(3999,RomanToDecimalConverter.convertRomanToDecimal("MMMCMXCIX"));

    }

    @Test
    @DisplayName("Test convertDecimalToRoman with valid inputs")
    void testConvertDecimalToRoman_ValidInputs() {
        Assertions.assertEquals("I", RomanToDecimalConverter.convertDecimalToRoman(1));
        Assertions.assertEquals("II", RomanToDecimalConverter.convertDecimalToRoman(2));
        Assertions.assertEquals("III", RomanToDecimalConverter.convertDecimalToRoman(3));
        Assertions.assertEquals("IV", RomanToDecimalConverter.convertDecimalToRoman(4));
        Assertions.assertEquals("V", RomanToDecimalConverter.convertDecimalToRoman(5));
        Assertions.assertEquals("IX", RomanToDecimalConverter.convertDecimalToRoman(9));
        Assertions.assertEquals("LVIII", RomanToDecimalConverter.convertDecimalToRoman(58));
        Assertions.assertEquals("D", RomanToDecimalConverter.convertDecimalToRoman(500));
        Assertions.assertEquals("MCMXCIV", RomanToDecimalConverter.convertDecimalToRoman(1994));
        Assertions.assertEquals("MMMCMXCIX", RomanToDecimalConverter.convertDecimalToRoman(3999));
    }
    @Test
    @DisplayName("Test isValidRomanNumber with valid inputs")
    void testIsValidRomanNumber_ValidInputs() {
        Assertions.assertTrue(RomanToDecimalConverter.isValidRomanNumber("III"));
        Assertions.assertTrue(RomanToDecimalConverter.isValidRomanNumber("XLII"));
        Assertions.assertTrue(RomanToDecimalConverter.isValidRomanNumber("IC"));
    }
    @Test
    @DisplayName(("Test isValidRomanNumber with invalid inputs"))
    void testIsValidRomanNumber_InvalidInputs(){
        Assertions.assertFalse(RomanToDecimalConverter.isValidRomanNumber("ABC"));
        Assertions.assertFalse(RomanToDecimalConverter.isValidRomanNumber("XYZ"));
        Assertions.assertFalse(RomanToDecimalConverter.isValidRomanNumber("RIC"));
    }

    @Test
    @DisplayName("Test areInterdependent with valid roman numbers")
    void testAreInterdependent_ValidRomanNumbers() {
        Assertions.assertTrue(RomanToDecimalConverter.areInterdependent("III", "I"));
        Assertions.assertTrue(RomanToDecimalConverter.areInterdependent("IV", "II"));
        Assertions.assertFalse(RomanToDecimalConverter.areInterdependent("IV", "VI"));
        Assertions.assertFalse(RomanToDecimalConverter.areInterdependent("VII", "V"));
    }


    @Test
    @DisplayName("Test isPalindrome with valid inputs")
    void testIsPalindrome_ValidInputs() {
        Assertions.assertTrue(RomanToDecimalConverter.isPalindrome("IXI"));
        Assertions.assertFalse(RomanToDecimalConverter.isPalindrome("XIV"));
    }

    @Test
    @DisplayName("Test convertRomanToDecimal with null input")
    void testConvertRomanToDecimal_NullInput() {
        Assertions.assertEquals(0, RomanToDecimalConverter.convertRomanToDecimal(null));
    }

    @Test
    @DisplayName("Test isValidRomanNumber with empty string")
    void testIsValidRomanNumber_EmptyStringInput() {
        Assertions.assertFalse(RomanToDecimalConverter.isValidRomanNumber(""));
    }
    @Test
    @DisplayName("Test convertDecimalToRoman with negative input")
    void testConvertDecimalToRoman_NegativeInput() {
        Assertions.assertEquals("", RomanToDecimalConverter.convertDecimalToRoman(-5));
    }
    @Test
    @DisplayName("Test isValidRomanNumber with invalid characters")
    void testIsValidRomanNumber_InvalidCharacters() {
        Assertions.assertFalse(RomanToDecimalConverter.isValidRomanNumber("XICV#"));
        Assertions.assertFalse(RomanToDecimalConverter.isValidRomanNumber("XICV@"));
        Assertions.assertFalse(RomanToDecimalConverter.isValidRomanNumber("XIV?"));
    }
    @Test
    @DisplayName("Test convertRomanToDecimal with repeated roman numerals")
    void testConvertRomanToDecimal_RepeatedRomanNumerals() {
        Assertions.assertEquals(3, RomanToDecimalConverter.convertRomanToDecimal("III"));
        Assertions.assertEquals(20, RomanToDecimalConverter.convertRomanToDecimal("XX"));
        Assertions.assertEquals(300, RomanToDecimalConverter.convertRomanToDecimal("CCC"));
    }
    @Test
    @DisplayName("Test convertRomanToDecimal with subtractive roman numerals")
    void testConvertRomanToDecimal_SubtractiveRomanNumerals() {
        Assertions.assertEquals(4, RomanToDecimalConverter.convertRomanToDecimal("IV"));
        Assertions.assertEquals(9, RomanToDecimalConverter.convertRomanToDecimal("IX"));
        Assertions.assertEquals(40, RomanToDecimalConverter.convertRomanToDecimal("XL"));
    }
    @Test
    @DisplayName("Test convertDecimalToRoman with input equals to zero")
    void testConvertDecimalToRoman_InputZero() {
        Assertions.assertEquals("", RomanToDecimalConverter.convertDecimalToRoman(0));
    }
    @Test
    @DisplayName("Test convertRomanToDecimal with default case activated")
    void testConvertRomanToDecimal_DefaultCase() {
        Assertions.assertEquals(0, RomanToDecimalConverter.convertRomanToDecimal("Z"));
    }
    @Test
    @DisplayName("Test convertRomanToDecimal with null or empty input")
    void testConvertRomanToDecimal_NullOrEmptyInput() {
        // Verifica che il metodo restituisca 0 quando l'input è null
        Assertions.assertEquals(0, RomanToDecimalConverter.convertRomanToDecimal(null));
        // Verifica che il metodo restituisca 0 quando l'input è una stringa vuota
        Assertions.assertEquals(0, RomanToDecimalConverter.convertRomanToDecimal(""));
    }
    //saltati i test sull'interdipendenza che comprende le divisioni tra 0 o null.
}
