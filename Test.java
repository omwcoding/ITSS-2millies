import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class RomanToDecimalConverterTest {

    @Test
    @DisplayName("Test convertRomanToDecimal")
    public void testConvertRomanToDecimal() {
        Assertions.assertEquals(3, RomanToDecimalConverter.convertRomanToDecimal("III"));
        Assertions.assertEquals(4, RomanToDecimalConverter.convertRomanToDecimal("IV"));
        Assertions.assertEquals(9, RomanToDecimalConverter.convertRomanToDecimal("IX"));
        Assertions.assertEquals(58, RomanToDecimalConverter.convertRomanToDecimal("LVIII"));
        Assertions.assertEquals(1994, RomanToDecimalConverter.convertRomanToDecimal("MCMXCIV"));
    }

    @Test
    @DisplayName("Test convertDecimalToRoman")
    public void testConvertDecimalToRoman() {
        Assertions.assertEquals("III", RomanToDecimalConverter.convertDecimalToRoman(3));
        Assertions.assertEquals("IV", RomanToDecimalConverter.convertDecimalToRoman(4));
        Assertions.assertEquals("IX", RomanToDecimalConverter.convertDecimalToRoman(9));
        Assertions.assertEquals("LVIII", RomanToDecimalConverter.convertDecimalToRoman(58));
        Assertions.assertEquals("MCMXCIV", RomanToDecimalConverter.convertDecimalToRoman(1994));
    }

    @Test
    @DisplayName("Test isValidRomanNumber")
    public void testIsValidRomanNumber() {
        Assertions.assertTrue(RomanToDecimalConverter.isValidRomanNumber("III"));
        Assertions.assertTrue(RomanToDecimalConverter.isValidRomanNumber("XLII"));
        Assertions.assertFalse(RomanToDecimalConverter.isValidRomanNumber("ABC"));
        Assertions.assertFalse(RomanToDecimalConverter.isValidRomanNumber("IC"));
    }

    @Test
    @DisplayName("Test areInterdependent")
    public void testAreInterdependent() {
        Assertions.assertTrue(RomanToDecimalConverter.areInterdependent("III", "I"));
        Assertions.assertFalse(RomanToDecimalConverter.areInterdependent("IV", "VI"));
    }

    @Test
    @DisplayName("Test isPalindrome")
    public void testIsPalindrome() {
        Assertions.assertTrue(RomanToDecimalConverter.isPalindrome("IXII"));
        Assertions.assertFalse(RomanToDecimalConverter.isPalindrome("XIV"));
    }
}
