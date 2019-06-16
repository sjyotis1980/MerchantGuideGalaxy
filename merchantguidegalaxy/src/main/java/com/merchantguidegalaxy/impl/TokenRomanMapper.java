
package com.merchantguidegalaxy.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.merchantguidegalaxy.LineTypeEnum;
import com.merchantguidegalaxy.NumeralConverter;
import com.merchantguidegalaxy.RawInputHolder;
import com.merchantguidegalaxy.TokenMapper;
import com.merchantguidegalaxy.exceptions.InvalidNumeralException;
import com.merchantguidegalaxy.exceptions.TokenMappingException;
import com.merchantguidegalaxy.launch.AppLauncher;

/**
 * This class will hold mapping of token and Roman.
 * 
 * e.g.
 * glob is I
 * prok is V
 * pish is X
 * tegj is L
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class TokenRomanMapper implements TokenMapper
{

	private Map<String, String> tokenRomanMapping = new HashMap<String, String>();
	
	private NumeralConverter numeralConverter = new RomanToArabicConverter();
	
	/**
	 * This method will add token and its equivalent Roman numeral.   
	 * 
	 * e.g.
	 * glob is I
	 * prok is V
	 * pish is X
	 * tegj is L
	 * 
	 * @param tokenRoman
	 * @throws TokenMappingException, if same token is mapped to more than one Roman numeral.
	 * @throws InvalidNumeralException, if mapped Roman is invalid Roman numeral.
	 */
	public void addMapping(List<String> tokenRoman) throws TokenMappingException, InvalidNumeralException
	{
		String token = tokenRoman.get(0).trim();
		String roman = tokenRoman.get(2).trim().toUpperCase();
		
		if(numeralConverter.isValidRomanNumeral(roman))
		{
			if( ! tokenRomanMapping.containsKey(token))
			{
				tokenRomanMapping.put(token, roman);
			}
			else
			{
				String preRoman = tokenRomanMapping.get(token);
				
				if(preRoman != roman)
				{
					throw new TokenMappingException(token +" cannot be mapped to more than one Roman numeral [ "+preRoman+", "+roman+"], "+token+" is already mapped to "+preRoman);
				}
				
			}
		}
		else
		{
			throw new InvalidNumeralException(roman+" is not valid Roman numeral");
		}
	}

	/**
	 * This method will read token and convert them in to Roman numeral.
	 * @param tokenArray List of token.
	 * @return Roman numeral of given token.
	 * @throws TokenMappingException {@inheritDoc}
	 */
	public String getTokenValue(List<String> tokenList) throws TokenMappingException 
	{
		StringBuilder  romanString = new StringBuilder();
		
		for (String token : tokenList) 
		{
			token = token.trim();
			
			if(token != null && !token.isEmpty())
			{
				if(tokenRomanMapping.containsKey(token))
				{
					romanString.append(tokenRomanMapping.get(token));
				}
				else
				{
					throw new TokenMappingException(token+" is not mapped to any Roman numeral.");
				}
			}
		}
		
		return romanString.toString();
	}
	
	/**
	 * This method will read token and convert them in to Arabic numeral.
	 * @param tokenList List of token.
	 * @return Arabic numeral of given token.
	 * @throws TokenMappingException {@inheritDoc}
	 * @throws InvalidNumeralException  {@inheritDoc}
	 */
	public int convertTokenToArabic(List<String> tokenList) throws TokenMappingException, InvalidNumeralException 
	{
		StringBuilder  romanString = new StringBuilder();
		
		for (String token : tokenList) 
		{
			token = token.trim();
			
			if(token != null && !token.isEmpty())
			{
				if(tokenRomanMapping.containsKey(token))
				{
					romanString.append(tokenRomanMapping.get(token));
				}
				else
				{
					throw new TokenMappingException(token+" is not mapped to any Roman numeral.");
				}
			}
		}
		
		return numeralConverter.convertToArabicNumeral(romanString.toString());
	}
	
	/**
	 * This method process the assignment line<br>
	 * It extracts the constant Roman literal from input string and adds it {@link TokenRomanMapper}
	 * 
	 * @param rawInputHolder instance of {@link RawInputHolder}
	 * @throws InvalidNumeralException  {@inheritDoc}
	 * @throws TokenMappingException  {@inheritDoc}
	 */
	public void processAssignmentLine(RawInputHolder rawInputHolder) throws TokenMappingException, InvalidNumeralException
	{
		ArrayList<String> assignedTypeInputList = rawInputHolder.getRawInputByLineType(LineTypeEnum.ASSIGNED);
		
		if( ! assignedTypeInputList.isEmpty())
		{
			for (String assignedLine : assignedTypeInputList) 
			{
				this.addMapping(Arrays.asList(assignedLine.split(AppLauncher.WHITE_SPACE_REGEX)));
			}
		}
	}
}
