
package com.merchantguidegalaxy.impl;

import java.util.regex.Pattern;

import com.merchantguidegalaxy.NumeralConverter;
import com.merchantguidegalaxy.exceptions.InvalidNumeralException;

/**
 * Convert Roman numeral to its equivalent Arabic numeral.
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class RomanToArabicConverter implements NumeralConverter 
{
	private  String VALID_ROMAN_REGEX = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
	
	/**
	 * This method will convert given Roman numeral to its equivalent Arabic numeral
	 * 
	 * @param romanNumeral
	 * @return Arabic equivalent of Roman numeral
	 * @throws InvalidNumeralException {@inheritDoc}
	 */
	public  int convertToArabicNumeral(String romanNumeral) throws InvalidNumeralException
	{
		if( !isValidRomanNumeral(romanNumeral))
		{
			throw new InvalidNumeralException(romanNumeral+" is not valid Roman numeral");
		}
		
		return (int) evaluateNextRomanNumeral(romanNumeral, romanNumeral.length() - 1, 0);
	}
	
	/**
	 * This method will read Roman numeral from right to left recursively and convert them to Arabic.
	 * 
	 * for Eg.
	 * 
	 * if romanNumeral is IV then this method will convert V fist then I.
	 * 
	 * @param romanNumeral, Roman numeral to convert
	 * @param pos, position of Roman numeral to convert 
	 * @param rightNumeral, decimal representation of previous Roman numeral.
	 * @return Arabic value of given Roman numeral.
	 */
	private  double evaluateNextRomanNumeral(String romanNumeral, int pos, double rightNumeral) 
	{
	    if (pos < 0) 
	    	return 0;
	    
	    char ch = romanNumeral.charAt(pos);
	    
	    // gives Arabic value of Roman M=1000, D=500, C=100, L=50, X=10, V=5, I=1
	    double value = Math.floor(Math.pow(10, "IXCM".indexOf(ch))) + 5 * Math.floor(Math.pow(10, "VLD".indexOf(ch)));
	    
	    return value * Math.signum(value + 0.5 - rightNumeral) + evaluateNextRomanNumeral(romanNumeral, pos - 1, value);
	}
	
	/**
	 * This method will check whether given Roman numeral is valid or not.
	 * 
	 * @param romanNumeral
	 * @return True if romanNumeral is valid Roman numeral.
	 */
	public boolean isValidRomanNumeral(String romanNumeral)
	{
		return Pattern.matches(VALID_ROMAN_REGEX, romanNumeral);
	}
}
