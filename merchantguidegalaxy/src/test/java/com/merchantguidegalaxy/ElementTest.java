
package com.merchantguidegalaxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.merchantguidegalaxy.exceptions.ElementProcessingException;
import com.merchantguidegalaxy.exceptions.InvalidNumeralException;
import com.merchantguidegalaxy.exceptions.TokenMappingException;
import com.merchantguidegalaxy.impl.RomanToArabicConverter;
import com.merchantguidegalaxy.impl.TokenRomanMapper;

/**
 * This test is use to test Element class.
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class ElementTest 
{

	private Elements element;
	
	private final static String WHITE_SPACE_REGEX = "\\s+";
	
	@Before
	public void beforeTest() throws TokenMappingException, InvalidNumeralException
	{
		TokenMapper tokenMapper = new TokenRomanMapper();
		NumeralConverter numeralConverter = new RomanToArabicConverter();
		
		tokenMapper.addMapping(Arrays.asList("glob is I".split(" ")));
		tokenMapper.addMapping(Arrays.asList("prok is V".split(" ")));
		tokenMapper.addMapping(Arrays.asList("pish is X".split(" ")));
		tokenMapper.addMapping(Arrays.asList("tegj is L".split(" ")));
		
		element = new Elements(tokenMapper, numeralConverter);
	}
	
	@Test
	public void deriveElementPerUnitCostTest() throws TokenMappingException, InvalidNumeralException, ElementProcessingException
	{
		element.deriveElementPerUnitCost(Arrays.asList("glob prok Gold is 57800 Credits".split(WHITE_SPACE_REGEX)));
		
		List<String> tokenList = new ArrayList<>();
		tokenList.add("glob");
		
		Assert.assertEquals(14450.0, element.getCredit("Gold", tokenList), 2);;
	}
	
	@Test(expected = ElementProcessingException.class)
	public void testElementProcessingException() throws TokenMappingException, InvalidNumeralException, ElementProcessingException
	{
		element.deriveElementPerUnitCost(Arrays.asList("glob prok Gold is 57800 Credits".split(WHITE_SPACE_REGEX)));
		
		List<String> tokenList = new ArrayList<>();
		tokenList.add("glob");
		
		System.out.println(element.getCredit("Pizza", tokenList));
	}
	
	@Test(expected = TokenMappingException.class)
	public void testTokenMappingException() throws ElementProcessingException, TokenMappingException, InvalidNumeralException
	{
		element.deriveElementPerUnitCost(Arrays.asList("glob prok Gold is 57800 Credits".split(WHITE_SPACE_REGEX)));
		
		List<String> tokenList = new ArrayList<>();
		tokenList.add("pish");
		tokenList.add("pish");
		tokenList.add("xxx");
		tokenList.add("glob");
		
		Assert.assertEquals(375700.0 , element.getCredit("Gold", tokenList), 2);
	}
	
	@Test(expected = InvalidNumeralException.class)
	public void testInvalidNumeralException() throws ElementProcessingException, TokenMappingException, InvalidNumeralException
	{
		element.deriveElementPerUnitCost(Arrays.asList("glob prok Gold is 57800 Credits".split(WHITE_SPACE_REGEX)));
		
		List<String> tokenList = new ArrayList<>();
		tokenList.add("pish");
		tokenList.add("prok");
		tokenList.add("glob");
		tokenList.add("pish");
		
		Assert.assertEquals(375700.0 , element.getCredit("Gold", tokenList), 2);
	}
	
	@Test
	public void getCredit() throws ElementProcessingException, TokenMappingException, InvalidNumeralException
	{
		element.deriveElementPerUnitCost(Arrays.asList("glob prok Gold is 57800 Credits".split(WHITE_SPACE_REGEX)));
		
		List<String> tokenList = new ArrayList<>();
		tokenList.add("pish");
		tokenList.add("pish");
		tokenList.add("prok");
		tokenList.add("glob");
		
		Assert.assertEquals(375700.0 , element.getCredit("Gold", tokenList), 2);
	}
	
	@Test
	public void removeAndExtractElementTest() throws TokenMappingException, InvalidNumeralException
	{
		element.deriveElementPerUnitCost(Arrays.asList("glob prok Gold is 57800 Credits".split(WHITE_SPACE_REGEX)));
		
		List<String> tokenList = new ArrayList<>();
		tokenList.add("pish");
		tokenList.add("pish");
		tokenList.add("prok");
		tokenList.add("Gold");
		
		String removeAndExtractElement = element.removeAndExtractElement(tokenList);
		
		Assert.assertEquals("Gold",removeAndExtractElement);
		
		List<String> expectedTokenList = new ArrayList<>();
		expectedTokenList.add("pish");
		expectedTokenList.add("pish");
		expectedTokenList.add("prok");
		
		Assert.assertEquals(expectedTokenList,tokenList);
	}
}
