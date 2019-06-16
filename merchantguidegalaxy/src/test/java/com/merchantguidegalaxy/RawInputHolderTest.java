
package com.merchantguidegalaxy;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Test {@link RawInputHolder} class.
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class RawInputHolderTest 
{

	@Test
	public void testRawInputHolder()
	{
		String assignment = "tegj is L";
		String credit = "glob glob Silver is 34 Credits";
		String howMuch = "how much is pish tegj glob glob ?";
		String howMany = "how many Credits is glob prok Silver ?";
		String noMatch = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
		String commMatch = "how much comm pish of Gold is Silver?";
		
		RawInputHolder inputHolder = new RawInputHolder();
		
		inputHolder.addRawInput(LineTypeEnum.ASSIGNED, assignment, 1);
		inputHolder.addRawInput(LineTypeEnum.CREDITS, credit, 2);
		inputHolder.addRawInput(LineTypeEnum.QUESTION_HOW_MUCH, howMuch, 3);
		inputHolder.addRawInput(LineTypeEnum.QUESTION_HOW_MANY, howMany, 4);
		inputHolder.addRawInput(LineTypeEnum.NOMATCH, noMatch, 5);
		inputHolder.addRawInput(LineTypeEnum.QUESTION_HOW_MUCH_COMM, commMatch, 6);
		
		ArrayList<String> assignedArrayList = inputHolder.getRawInputByLineType(LineTypeEnum.ASSIGNED);
		Assert.assertEquals(1, assignedArrayList.size());
		Assert.assertEquals(assignment,assignedArrayList.get(0));
		
		ArrayList<String> creditsArrayList = inputHolder.getRawInputByLineType(LineTypeEnum.CREDITS);
		Assert.assertEquals(1, creditsArrayList.size());
		Assert.assertEquals(credit,creditsArrayList.get(0));
		
		ArrayList<String> howMuchArrayList = inputHolder.getRawInputByLineType(LineTypeEnum.QUESTION_HOW_MUCH);
		Assert.assertEquals(1, howMuchArrayList.size());
		Assert.assertEquals("3#"+howMuch,howMuchArrayList.get(0));
		
		ArrayList<String> howManyArrayList = inputHolder.getRawInputByLineType(LineTypeEnum.QUESTION_HOW_MANY);
		Assert.assertEquals(1, howManyArrayList.size());
		Assert.assertEquals("4#"+howMany,howManyArrayList.get(0));
		
		ArrayList<String> nomatchArrayList = inputHolder.getRawInputByLineType(LineTypeEnum.NOMATCH);
		Assert.assertEquals(1, nomatchArrayList.size());
		Assert.assertEquals("5#"+noMatch,nomatchArrayList.get(0));
		
		ArrayList<String> commMatchArrayList = inputHolder.getRawInputByLineType(LineTypeEnum.QUESTION_HOW_MUCH_COMM);
		Assert.assertEquals(1, nomatchArrayList.size());
		Assert.assertEquals("6#"+commMatch,commMatchArrayList.get(0));
		
	}
}
