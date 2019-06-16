
package com.merchantguidegalaxy;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.merchantguidegalaxy.exceptions.InvalidNumeralException;
import com.merchantguidegalaxy.impl.RomanToArabicConverter;

/**
 * This class tests RomanToArabicConverter class.
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class RomanToArabicConverterTest 
{
	
	@Test
	public void testRomanToArabicConverter() throws InvalidNumeralException
	{
		NumeralConverter numeralConverter = new RomanToArabicConverter();
		
		assertEquals(numeralConverter.convertToArabicNumeral("I"), 1);
	    assertEquals(numeralConverter.convertToArabicNumeral("II"), 2);
	    assertEquals(numeralConverter.convertToArabicNumeral("III"), 3);
	    assertEquals(numeralConverter.convertToArabicNumeral("IV"), 4);
	    assertEquals(numeralConverter.convertToArabicNumeral("V"), 5);
	    assertEquals(numeralConverter.convertToArabicNumeral("VI"), 6);
	    assertEquals(numeralConverter.convertToArabicNumeral("VII"), 7);
	    assertEquals(numeralConverter.convertToArabicNumeral("VIII"), 8);
	    assertEquals(numeralConverter.convertToArabicNumeral("IX"), 9);
	    assertEquals(numeralConverter.convertToArabicNumeral("X"), 10);
	    assertEquals(numeralConverter.convertToArabicNumeral("XI"), 11);
	    assertEquals(numeralConverter.convertToArabicNumeral("XII"), 12);
	    assertEquals(numeralConverter.convertToArabicNumeral("XIII"), 13);
	    assertEquals(numeralConverter.convertToArabicNumeral("XIV"), 14);
	    assertEquals(numeralConverter.convertToArabicNumeral("XV"), 15);
	    assertEquals(numeralConverter.convertToArabicNumeral("XVI"), 16);
	    assertEquals(numeralConverter.convertToArabicNumeral("XVII"), 17);
	    assertEquals(numeralConverter.convertToArabicNumeral("XVIII"), 18);
	    assertEquals(numeralConverter.convertToArabicNumeral("XIX"), 19);
	    assertEquals(numeralConverter.convertToArabicNumeral("XX"), 20);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXI"), 21);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXII"), 22);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXIII"), 23);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXIV"), 24);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXV"), 25);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXVI"), 26);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXVII"), 27);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXVIII"), 28);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXIX"), 29);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXX"), 30);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXXI"), 31);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXXII"), 32);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXXIII"), 33);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXXIV"), 34);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXXV"), 35);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXXVI"), 36);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXXVII"), 37);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXXVIII"), 38);
	    assertEquals(numeralConverter.convertToArabicNumeral("XXXIX"), 39);
	    assertEquals(numeralConverter.convertToArabicNumeral("XL"), 40);
	    assertEquals(numeralConverter.convertToArabicNumeral("XLI"), 41);
	    assertEquals(numeralConverter.convertToArabicNumeral("XLII"), 42);
	    assertEquals(numeralConverter.convertToArabicNumeral("XLIII"), 43);
	    assertEquals(numeralConverter.convertToArabicNumeral("XLIV"), 44);
	    assertEquals(numeralConverter.convertToArabicNumeral("XLV"), 45);
	    assertEquals(numeralConverter.convertToArabicNumeral("XLVI"), 46);
	    assertEquals(numeralConverter.convertToArabicNumeral("XLVII"), 47);
	    assertEquals(numeralConverter.convertToArabicNumeral("XLVIII"), 48);
	    assertEquals(numeralConverter.convertToArabicNumeral("XLIX"), 49);
	    assertEquals(numeralConverter.convertToArabicNumeral("L"), 50);
	    assertEquals(numeralConverter.convertToArabicNumeral("LI"), 51);
	    assertEquals(numeralConverter.convertToArabicNumeral("LII"), 52);
	    assertEquals(numeralConverter.convertToArabicNumeral("LIII"), 53);
	    assertEquals(numeralConverter.convertToArabicNumeral("LIV"), 54);
	    assertEquals(numeralConverter.convertToArabicNumeral("LV"), 55);
	    assertEquals(numeralConverter.convertToArabicNumeral("LVI"), 56);
	    assertEquals(numeralConverter.convertToArabicNumeral("LVII"), 57);
	    assertEquals(numeralConverter.convertToArabicNumeral("LVIII"), 58);
	    assertEquals(numeralConverter.convertToArabicNumeral("LIX"), 59);
	    assertEquals(numeralConverter.convertToArabicNumeral("LX"), 60);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXI"), 61);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXII"), 62);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXIII"), 63);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXIV"), 64);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXV"), 65);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXVI"), 66);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXVII"), 67);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXVIII"), 68);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXIX"), 69);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXX"), 70);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXI"), 71);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXII"), 72);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXIII"), 73);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXIV"), 74);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXV"), 75);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXVI"), 76);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXVII"), 77);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXVIII"), 78);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXIX"), 79);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXX"), 80);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXXI"), 81);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXXII"), 82);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXXIII"), 83);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXXIV"), 84);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXXV"), 85);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXXVI"), 86);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXXVII"), 87);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXXVIII"), 88);
	    assertEquals(numeralConverter.convertToArabicNumeral("LXXXIX"), 89);
	    assertEquals(numeralConverter.convertToArabicNumeral("XC"), 90);
	    assertEquals(numeralConverter.convertToArabicNumeral("XCI"), 91);
	    assertEquals(numeralConverter.convertToArabicNumeral("XCII"), 92);
	    assertEquals(numeralConverter.convertToArabicNumeral("XCIII"), 93);
	    assertEquals(numeralConverter.convertToArabicNumeral("XCIV"), 94);
	    assertEquals(numeralConverter.convertToArabicNumeral("XCV"), 95);
	    assertEquals(numeralConverter.convertToArabicNumeral("XCVI"), 96);
	    assertEquals(numeralConverter.convertToArabicNumeral("XCVII"), 97);
	    assertEquals(numeralConverter.convertToArabicNumeral("XCVIII"), 98);
	    assertEquals(numeralConverter.convertToArabicNumeral("XCIX"), 99);
	    assertEquals(numeralConverter.convertToArabicNumeral("C"), 100);
	    assertEquals(numeralConverter.convertToArabicNumeral("DI"), 501);
	    assertEquals(numeralConverter.convertToArabicNumeral("DL"), 550);
	    assertEquals(numeralConverter.convertToArabicNumeral("DXXX"), 530);
	    assertEquals(numeralConverter.convertToArabicNumeral("DCCVII"), 707);
	    assertEquals(numeralConverter.convertToArabicNumeral("DCCCXC"), 890);
	    assertEquals(numeralConverter.convertToArabicNumeral("MD"), 1500);
	    assertEquals(numeralConverter.convertToArabicNumeral("MDCCC"), 1800);
	    assertEquals(numeralConverter.convertToArabicNumeral("CM"), 900);
	}
	
	@Test(expected = InvalidNumeralException.class)
	public void testInvalidRomanToArabic() throws InvalidNumeralException
	{
		NumeralConverter numeralConverter = new RomanToArabicConverter();
		assertEquals(numeralConverter.convertToArabicNumeral("MMMM"), 4000);
	}
	
	@Test
	public void testIsValidRomanNumeral()
	{
		NumeralConverter numeralConverter = new RomanToArabicConverter();
		Assert.assertFalse(numeralConverter.isValidRomanNumeral("MMMM"));
		Assert.assertTrue(numeralConverter.isValidRomanNumeral("MDCCC"));
	}
	
}
