
package com.merchantguidegalaxy;

import java.util.ArrayList;
import java.util.List;

/**
 * This enum represents type of line in input file. 
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public enum LineTypeEnum 
{

	/**
	  * This represents that line is of Assignment type. Ex: glob is V
	  */
	 ASSIGNED("^([A-Za-z]+) is ([I|V|X|L|C|D|M])$"),
	 
	 /**
	  * This represents that line is of Credits type. Ex : glob glob Silver is 34 Credits
	  */
	 CREDITS("^([A-Za-z]+)([A-Za-z\\s]*) is ([0-9]+) ([c|C]redits)$"),
	 
	 /**
	  * This represents that line is question asking how much. Ex : how much is pish tegj glob glob ?
	  */
	 QUESTION_HOW_MUCH("^how much is (([A-Za-z\\s])+)\\?$"),
	 
	 /**
	  * This represents that line is question asking how many. Ex: how many Credits is glob prok Iron ?
	  */
	 QUESTION_HOW_MANY("^how many [c|C]redits is (([A-Za-z\\s])+)\\?$"),
	 
	 /**
	  * This represents that line does not matched any of the line type mentioned above
	  */
	 NOMATCH("no_match"),
	 
	 /**
	  * This represents comm question.
	  */
	 QUESTION_HOW_MUCH_COMM("^how much comm (([A-Za-z\\s])+)\\?$");

		
	 private String pattern;
	 
	 private static List<LineTypeEnum> lineFilter;
	 
	 private LineTypeEnum(String pattern)
	 {
		 this.pattern = pattern;
	 }
	 
	 static
	 {
		 lineFilter = new ArrayList<>();
		 lineFilter.add(ASSIGNED);
		 lineFilter.add(CREDITS);
		 lineFilter.add(QUESTION_HOW_MUCH);
		 lineFilter.add(QUESTION_HOW_MANY);
		 lineFilter.add(QUESTION_HOW_MUCH_COMM);
	 }
	 
	 public String getPattern() 
	 {
		return pattern;
	 }



	/**
	 * This method returns the line type for the a particular line
	 * @param line String
	 * @return lineType LineTypeEnum
	 */
	 public static LineTypeEnum getLineType(String line)
	 {
			line = line.trim();
			LineTypeEnum result = LineTypeEnum.NOMATCH;
			
			boolean matched = false;
				
			for(int i =0;i<lineFilter.size() && !matched ;i++)
			{
				if( line.matches(lineFilter.get(i).getPattern()) )
				{
					matched = true;
					result = lineFilter.get(i);
				}
				
			}
			
			return result;
	 }
}
