
package com.merchantguidegalaxy;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.merchantguidegalaxy.exceptions.ElementProcessingException;
import com.merchantguidegalaxy.exceptions.InvalidNumeralException;
import com.merchantguidegalaxy.exceptions.TokenMappingException;
import com.merchantguidegalaxy.launch.AppLauncher;

/**
 * QueryProcessor will process query and generate output.
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class QueryProcessor 
{
	/**
	 * This method will process 'How Much' question and add result to output.
	 * 
	 * @param tokenMapper instance of {@link TokenMapper}
	 * @param rawInputHolder instance of {@link RawInputHolder}
	 * @param output, holder for result
	 */
	public  void processHowMuchQuestion(TokenMapper tokenRomanMapper, RawInputHolder rawInputHolder, String [] output)
	{
		ArrayList<String> howMuchInputList = rawInputHolder.getRawInputByLineType(LineTypeEnum.QUESTION_HOW_MUCH);
		
		for (String howMuchInput : howMuchInputList) 
		{
			String[] split = howMuchInput.split(AppLauncher.LINE_NUMBER_SEPARATOR);
			
			int lineNumber = Integer.parseInt(split[0]);
			
			List<String> tokens = MerchantUtility.splitQuery(split[1]);
			try 
			{
				output[lineNumber] = MerchantUtility.formatOutput(tokens)+" is "+tokenRomanMapper.convertTokenToArabic(tokens);
			} 
			catch (TokenMappingException | InvalidNumeralException e) 
			{
				output[lineNumber] = AppLauncher.NO_IDEA;
			}
		}

	}
	
	/**
	 * This method will process 'How Many' question and add result to output.
	 * 
	 * @param elements for which credit to computed
	 * @param awInputHolder instance of {@link RawInputHolder}
	 * @param output, holder for result
	 */
	public void processHowManyQuestion(Elements elements, RawInputHolder rawInputHolder, String [] output) 
	{
		ArrayList<String> howManyInputList = rawInputHolder.getRawInputByLineType(LineTypeEnum.QUESTION_HOW_MANY);
		
		DecimalFormat formater = new DecimalFormat();
		formater.applyPattern("#.#");
	    
		for (String howManyInput : howManyInputList) 
		{
			String[] split = howManyInput.split(AppLauncher.LINE_NUMBER_SEPARATOR);
			
			int lineNumber = Integer.parseInt(split[0]);
			
			List<String> tokens = MerchantUtility.splitQuery(split[1]);
			
			String element = elements.removeAndExtractElement(tokens);
			
			try 
			{
				output[lineNumber] = MerchantUtility.formatOutput(tokens) +" "+ element +" is "+ formater.format(elements.getCredit(element, tokens)) +" Credits";
			} 
			catch (ElementProcessingException | TokenMappingException
					| InvalidNumeralException e) 
			{
				output[lineNumber] = AppLauncher.NO_IDEA;
			}
		}
	}
	

	/**
	 * This method will process those query which are neither 'How Much' nor 'How Many'
	 * 
	 * @param rawInputHolder instance of {@link RawInputHolder}
	 * @param output, holder for result
	 */
	public void processNoMatchLines(RawInputHolder rawInputHolder, String [] output)
	{
		ArrayList<String> noMatchInputList = rawInputHolder.getRawInputByLineType(LineTypeEnum.NOMATCH);
		
		for (String noMatchInput : noMatchInputList)
		{
			String[] split = noMatchInput.split(AppLauncher.LINE_NUMBER_SEPARATOR);
			
			int lineNumber = Integer.parseInt(split[0]);
			
			output[lineNumber] = AppLauncher.NO_IDEA;
		}
		
	}

	/**
	 * This mothod will process those query which are of comm exchange.
	 * @param elements
	 * @param rawInputHolder
	 * @param outputList
	 * @throws InvalidNumeralException 
	 * @throws TokenMappingException 
	 * @throws ElementProcessingException 
	 */
	public void processHowMuchComm(Elements elements,RawInputHolder rawInputHolder, String[] outputList) throws ElementProcessingException, TokenMappingException, InvalidNumeralException 
	{
		ArrayList<String> matchCommList = rawInputHolder.getRawInputByLineType(LineTypeEnum.QUESTION_HOW_MUCH_COMM);
		
		for (String matchComm : matchCommList) 
		{
			String[] split = matchComm.split(AppLauncher.LINE_NUMBER_SEPARATOR);
			
			int lineNumber = Integer.parseInt(split[0]);
			
			String [] splitByWhiteSpace = split[1].split(AppLauncher.WHITE_SPACE_REGEX);
			
			List<String> tokenList = new ArrayList<>();
			tokenList.add(splitByWhiteSpace[3]);
					
			String metal1 = splitByWhiteSpace[5];
							
			String metal2 = splitByWhiteSpace[7];
			metal2 = metal2.substring(0, metal2.length()-1);
			
			double creditMetal1 = elements.getCredit(metal1, tokenList);
			
			Double unitCredit = elements.getUnitCredit(metal2);
			
			System.out.println(metal1+" "+metal2+" "+ creditMetal1);

		}
		
	}
}
