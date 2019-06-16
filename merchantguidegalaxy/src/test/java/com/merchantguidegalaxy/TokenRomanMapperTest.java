
package com.merchantguidegalaxy;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

import com.merchantguide.exceptions.InvalidNumeralException;
import com.merchantguide.exceptions.TokenMappingException;
import com.merchantguide.impl.TokenRomanMapper;

/**
 * Test class for {@link TokenRomanMapper}
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class TokenRomanMapperTest 
{

	@Test()
	public void testValidTokenAdd() throws TokenMappingException, InvalidNumeralException
	{
		TokenRomanMapper  tokenRomanMapper = new TokenRomanMapper();
		tokenRomanMapper.addMapping(Arrays.asList("glob is I".split(" ")));
		tokenRomanMapper.addMapping(Arrays.asList("prok is V".split(" ")));
		tokenRomanMapper.addMapping(Arrays.asList("pish is X".split(" ")));
		tokenRomanMapper.addMapping(Arrays.asList("tegj is L".split(" ")));
		
		Assert.assertEquals("II", tokenRomanMapper.getTokenValue(Arrays.asList(new String[] {"glob","glob"})));
	}
	
	
	@Test(expected = TokenMappingException.class)
	public void testInValidTokenAdd() throws TokenMappingException, InvalidNumeralException
	{
		TokenRomanMapper  tokenRomanMapper = new TokenRomanMapper();
		tokenRomanMapper.addMapping(Arrays.asList("glob is I".split(" ")));
		tokenRomanMapper.addMapping(Arrays.asList("prok is V".split(" ")));
		tokenRomanMapper.addMapping(Arrays.asList("pish is X".split(" ")));
		tokenRomanMapper.addMapping(Arrays.asList("tegj is L".split(" ")));
		
		Assert.assertEquals("II", tokenRomanMapper.getTokenValue(Arrays.asList(new String[] {" qwerty"  ,  "glob "})));
	}
	
	@Test(expected = InvalidNumeralException.class)
	public void testInvalidRomanNumeralException() throws TokenMappingException, InvalidNumeralException
	{
		TokenRomanMapper  tokenRomanMapper = new TokenRomanMapper();
		tokenRomanMapper.addMapping(Arrays.asList("glob is I".split(" ")));
		tokenRomanMapper.addMapping(Arrays.asList("prok is V".split(" ")));
		tokenRomanMapper.addMapping(Arrays.asList("pish is Z".split(" ")));
		tokenRomanMapper.addMapping(Arrays.asList("tegj is L".split(" ")));
	}
	
	@Test(expected = TokenMappingException.class)
	public void tokenMappingExceptionTest() throws TokenMappingException, InvalidNumeralException
	{
		TokenRomanMapper  tokenRomanMapper = new TokenRomanMapper();
		tokenRomanMapper.addMapping(Arrays.asList("glob is I".split(" ")));
		tokenRomanMapper.addMapping(Arrays.asList("prok is V".split(" ")));
		tokenRomanMapper.addMapping(Arrays.asList("glob is X".split(" ")));
		tokenRomanMapper.addMapping(Arrays.asList("tegj is L".split(" ")));         
	}
}


