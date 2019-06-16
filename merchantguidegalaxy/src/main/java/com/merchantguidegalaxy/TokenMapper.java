
package com.merchantguidegalaxy;

import java.util.List;

import com.merchantguidegalaxy.exceptions.InvalidNumeralException;
import com.merchantguidegalaxy.exceptions.TokenMappingException;
import com.merchantguidegalaxy.impl.TokenRomanMapper;

/**
 * Interface for processing tokens.
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public interface TokenMapper 
{
	
	/**
	 * This method will add token and its equivalent numeral.   
	 * 
	 * @param tokenList List of Tokens
	 * @throws TokenMappingException, if same token is mapped to more than one numeral.
	 * @throws InvalidNumeralException, if mapped numeral is invalid numeral.
	 */
	public void addMapping(List<String> tokenList) throws TokenMappingException, InvalidNumeralException;

	/**
	 * This method will read token and convert them in to numeral.
	 * 
	 * @param tokenList List of token.
	 * @return Equivalent numeral of given token.
	 * @throws TokenMappingException, if tokenList contain any unmapped token
	 */
	public String getTokenValue(List<String> tokenList) throws TokenMappingException; 
	
	/**
	 * This method will read token and convert them in to Arabic numeral.
	 * 
	 * @param tokenList List of token.
	 * @return Arabic numeral of given token.
	 * @throws TokenMappingException, if tokenList contain any unmapped token
	 * @throws InvalidNumeralException, if generated numeral from tokenList is invalid.
	 */
	public int convertTokenToArabic(List<String> tokenList) throws TokenMappingException, InvalidNumeralException; 
	
	/**
	 * This method process the assignment line. 
	 * It extracts the constant literal from input string and adds it {@link TokenRomanMapper}
	 * 
	 * @param rawInputHolder, Instance of RawInputHolder
	 * @throws InvalidNumeralException, if mapped numeral is invalid numeral. 
	 * @throws TokenMappingException, if same token is mapped to more than one numeral. 
	 */
	public void processAssignmentLine(RawInputHolder rawInputHolder) throws TokenMappingException, InvalidNumeralException;
}
