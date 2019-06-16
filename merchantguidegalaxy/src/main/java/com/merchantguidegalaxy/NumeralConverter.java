
package com.merchantguidegalaxy;

import com.merchantguidegalaxy.exceptions.InvalidNumeralException;

/**
 * Interface for numeral conversion
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public interface NumeralConverter 
{
	/**
	 * This method will convert given numeral to its equivalent Arabic numeral
	 * 
	 * @param numeral 
	 * @return Arabic equivalent of numeral
	 * @throws InvalidNumeralException if given numeral is invalid
	 */
	public int convertToArabicNumeral(String numeral) throws InvalidNumeralException;
	
	
	/**
	 * This method will check whether given numeral is valid or not.
	 * 
	 * @param numeral
	 * @return True if numeral is valid numeral.
	 */
	public boolean isValidRomanNumeral(String numeral);
}
