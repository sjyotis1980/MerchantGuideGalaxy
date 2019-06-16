
package com.merchantguidegalaxy.launch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.merchantguidegalaxy.Elements;
import com.merchantguidegalaxy.LineTypeEnum;
import com.merchantguidegalaxy.NumeralConverter;
import com.merchantguidegalaxy.QueryProcessor;
import com.merchantguidegalaxy.RawInputHolder;
import com.merchantguidegalaxy.TokenMapper;
import com.merchantguidegalaxy.impl.RomanToArabicConverter;
import com.merchantguidegalaxy.impl.TokenRomanMapper;

/**
 * Main class to launch application.
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class AppLauncher 
{

	public final static String WHITE_SPACE_REGEX = "\\s+";
	
	public final static String LINE_NUMBER_SEPARATOR = "#";
	
	public final static String NO_IDEA = "I have no idea what you are talking about";
	
	private final static RawInputHolder rawInputHolder = new RawInputHolder();
	
	/**
	 * Entry point to run program.
	 * takes parameter -inputFile <INPUT_FILE>
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		String inputFile = null;
		
	    String usage = "java com.merchantguide.AppLauncher"
                + " [-inputFile INPUT_FILE]";
		
		for(int i=0 ; i<args.length ; i++) 
		{
			if ("-inputFile".equals(args[i])) 
			{
				inputFile = args[i+1];
				break;
			} 
		}
		
		if(inputFile == null)
		{
	        System.err.println("Usage: " + usage);
	        System.exit(1);
		}
		
		int lineNumber = 0; 
		
		try(BufferedReader br = new BufferedReader(new FileReader(inputFile))) 
		{
			String sCurrentLine;
			
			while ((sCurrentLine = br.readLine()) != null)
			{
				if( ! sCurrentLine.isEmpty())
				{
					lineNumber = rawInputHolder.addRawInput(LineTypeEnum.getLineType(sCurrentLine), sCurrentLine, lineNumber);
				}
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(1);
		} 
		
		try
		{
			TokenMapper tokenMapper = new TokenRomanMapper();
			tokenMapper.processAssignmentLine(rawInputHolder);
			
			NumeralConverter numeralConverter = new RomanToArabicConverter();
			
			Elements elements = new Elements(tokenMapper, numeralConverter);
			elements.processCreditsLine(rawInputHolder);
			
			String [] outputList = new String[lineNumber];
			
			QueryProcessor queryProcessor = new QueryProcessor();
			
			queryProcessor.processHowMuchQuestion(tokenMapper, rawInputHolder, outputList);
			
			queryProcessor.processHowManyQuestion(elements, rawInputHolder, outputList);
			
			queryProcessor.processHowMuchComm(elements, rawInputHolder, outputList);
			
			queryProcessor.processNoMatchLines(rawInputHolder, outputList);
			
			for (String output : outputList) 
			{
				System.out.println(output);
			}
		}
		catch(Exception ex)
		{
			 ex.printStackTrace();
			 System.exit(1);
		}
		
		System.exit(0);
	}
	

}
