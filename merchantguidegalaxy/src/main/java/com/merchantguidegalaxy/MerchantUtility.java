
package com.merchantguidegalaxy;

import java.util.ArrayList;
import java.util.List;

import com.merchantguidegalaxy.launch.AppLauncher;

/**
 * Utility used from processing query
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class MerchantUtility 
{
	/**
	 * Return space separated value of list.
	 * 
	 * @param list
	 * @return space separated value of list
	 */
	public static String formatOutput(List<String> list)
	{
		StringBuilder builder = new StringBuilder(); 
		for (String element : list) 
		{
			builder.append(element);
			builder.append(" ");
		}
		return builder.toString().trim();
	}
	
	/**
	 * This method will extract tokens from question.
	 * 
	 *  @param howMuchInput
	 */
	public static List<String> splitQuery(String howMuchInput)
	{
		//Break the how much question line based on "is" keyword
		// the second part will contain the identifiers whose values are to determined
		
		String formatted = howMuchInput.split("\\sis\\s")[1].trim();
		
		//Remove the question mark from the string
		formatted = formatted.replace("?","").trim();
		
		//Now since the string will contain only identifiers,break them into words by splitting through space
		
		List<String> split = new ArrayList<String>();
		
		for(String s : formatted.split(AppLauncher.WHITE_SPACE_REGEX))
		{
			split.add(s);
		}
		
		return split;
	}
}
