
package com.merchantguidegalaxy;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

import com.merchantguidegalaxy.launch.AppLauncher;

/**
 * Data structure to hold raw input.
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class RawInputHolder 
{
	private Map<LineTypeEnum, ArrayList<String>> rawInputMap = new EnumMap<>(LineTypeEnum.class);
	
	/**
	 * Associates the specified line to line type.
	 *  
	 * @param lineTypeEnum, Type of line
	 * @param line
	 * @param lineNumber 
	 * @return 
	 */
	public int addRawInput(LineTypeEnum lineTypeEnum, String line, int lineNumber)
	{
		ArrayList<String> arrayList = new ArrayList<>();
		
		if(rawInputMap.containsKey(lineTypeEnum))
		{
			arrayList = rawInputMap.get(lineTypeEnum);
		}
		else
		{
			rawInputMap.put(lineTypeEnum, arrayList);
		}
		
		if(lineTypeEnum.equals(LineTypeEnum.QUESTION_HOW_MANY) || lineTypeEnum.equals(LineTypeEnum.QUESTION_HOW_MUCH) || lineTypeEnum.equals(LineTypeEnum.QUESTION_HOW_MUCH_COMM)
				|| lineTypeEnum.equals(LineTypeEnum.NOMATCH))
		{
			line = lineNumber+AppLauncher.LINE_NUMBER_SEPARATOR+line;
			lineNumber++;
		}
		
		arrayList.add(line);
		
		return lineNumber;
	}
	
	/**
	 * Get Raw input by line type.
	 * 
	 * @param lineTypeEnum Type of line.
	 * @return returns ArrayList of Raw Input of given lineType.
	 */
	public ArrayList<String> getRawInputByLineType(LineTypeEnum lineTypeEnum)
	{
		ArrayList<String> result = new ArrayList<>();
		ArrayList<String> arrayList = rawInputMap.get(lineTypeEnum);
		
		if(arrayList != null)
		{
			result.addAll(arrayList);
		}
		
		return result;
	}
}
