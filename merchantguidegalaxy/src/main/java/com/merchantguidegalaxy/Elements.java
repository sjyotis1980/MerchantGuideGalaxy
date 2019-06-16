
package com.merchantguidegalaxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import com.merchantguidegalaxy.exceptions.ElementProcessingException;
import com.merchantguidegalaxy.exceptions.InvalidNumeralException;
import com.merchantguidegalaxy.exceptions.TokenMappingException;
import com.merchantguidegalaxy.impl.RomanToArabicConverter;
import com.merchantguidegalaxy.launch.AppLauncher;

/**
 * This class holds information about element.
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class Elements 
{

	//map to hold element and per unit price.
	private Map<String, Double> elementValueMap = new HashMap<String, Double>();
	
	private TokenMapper tokenMapper;
	
	private NumeralConverter numeralConverter = new RomanToArabicConverter();
	
	public Elements(TokenMapper tokenMapper, NumeralConverter numeralConverter) 
	{
		this.tokenMapper = tokenMapper;
		this.numeralConverter = numeralConverter;
	}

	/**
	 * This method will derive element cost per unit.
	 * 
	 * @param elementValueStringSplit
	 * @throws TokenMappingException if unmapped token is found
	 * @throws InvalidNumeralException  if given numeral is invalid
	 */
	public void deriveElementPerUnitCost(List<String> elementValueStringSplit) throws TokenMappingException, InvalidNumeralException
	{
		int splitIndex = 0;
		int creditValue = 0; 
		String element= null; 
		List<String> valueofElement = null;
		
		for (int i = 0; i < elementValueStringSplit.size(); i++) 
		{
			if(elementValueStringSplit.get(i).toLowerCase().equals("credits"))
			{
				creditValue = Integer.parseInt(elementValueStringSplit.get(i-1));
			}
			if(elementValueStringSplit.get(i).toLowerCase().equals("is"))
			{
				splitIndex = i-1;
				element = elementValueStringSplit.get(i-1).toUpperCase();
			}
			valueofElement = new ArrayList<>(elementValueStringSplit.subList(0, splitIndex));
		}

		String roman = tokenMapper.getTokenValue(valueofElement);
		
		int valueOfElementInDecimal = numeralConverter.convertToArabicNumeral(roman);
		
		if( ! elementValueMap.containsKey(element))
		{
			elementValueMap.put(element, new Double((double)creditValue/valueOfElementInDecimal));
		}
		else
		{
			 Double preValue = elementValueMap.get(element);
			
			if(preValue.equals(creditValue/valueOfElementInDecimal))
			{
				throw new TokenMappingException(element +" must have only on per unit cost [ "+preValue+", "+(creditValue/valueOfElementInDecimal)+"]");
			}
			
		}	
	}
	
	/**
	 * Get credit based on element and tokenList. tokenList will converted to Arabic.
	 * 
	 * @param element, type of element
	 * @param tokenList token list
	 * @return credit based on element and tokenList
	 * @throws ElementProcessingException if 'element' doesn't exists.
	 * @throws InvalidNumeralException if given numeral is invalid
	 * @throws TokenMappingException if unmapped token is found
	 */
	public double getCredit(String element, List<String> tokenList) throws ElementProcessingException, TokenMappingException, InvalidNumeralException
	{
		element = element != null ? element.toUpperCase() : element;
		
		if(elementValueMap.containsKey(element))
		{
			return elementValueMap.get(element) * tokenMapper.convertTokenToArabic(tokenList);
		}
		else
		{
			throw new ElementProcessingException(element+" is unknow element");
		}
	}

	/**
	 * This method will remove and return element from tokens.
	 * 
	 * @param tokens List of tokens
	 * @return element if match else return null.
	 */
	public String removeAndExtractElement(List<String> tokens) 
	{
		Set<String> allElements = elementValueMap.keySet();
		
		String result = null;
		
		ListIterator<String> tokensIterator = tokens.listIterator(tokens.size());

		// Iterate in reverse.
		while(tokensIterator.hasPrevious()) 
		{
			String previous = tokensIterator.previous();
			
			if(allElements.contains(previous.toUpperCase()))
			{
				result = previous;
				tokensIterator.remove();
			}
		}
		
		return result;
	}
	

	/**
	 * This method process the line for credit computation.<br>
	 * It extracts the element from line and compute element cost per unit.<br>
	 * 
	 * @param rawInputHolder Instance of {@link RawInputHolder}.
	 * @throws TokenMappingException if unmapped token is found
	 * @throws InvalidNumeralException if given numeral is invalid
	 */
	public void processCreditsLine(RawInputHolder rawInputHolder) throws TokenMappingException, InvalidNumeralException
	{
		ArrayList<String> creditTypeInputList = rawInputHolder.getRawInputByLineType(LineTypeEnum.CREDITS);
		
		for (String assignedLine : creditTypeInputList) 
		{
			this.deriveElementPerUnitCost(Arrays.asList(assignedLine.split(AppLauncher.WHITE_SPACE_REGEX)));
		}
		
	}

	public Double getUnitCredit(String element) throws ElementProcessingException
	{
		element = element != null ? element.toUpperCase() : element;
		
		if(elementValueMap.containsKey(element))
		{
			return elementValueMap.get(element);
		}
		else
		{
			throw new ElementProcessingException(element+" is unknow element");
		}
		
	}
	
}
