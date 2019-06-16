
package com.merchantguidegalaxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class to test {@link MerchantUtility}.
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class MerchantUtilityTest 
{

	@Test
	public void formatOutputTest()
	{
		List<String> tokenList = new ArrayList<>();
		tokenList.add("pish");
		tokenList.add("pish");
		tokenList.add("prok");
		
		String formatOutput = MerchantUtility.formatOutput(tokenList);
		String expectedFormatOutput = "pish pish prok";
		
		Assert.assertEquals(expectedFormatOutput, formatOutput);
	}
	
	@Test
	public void splitQueryTest()
	{
		String howMuch = "how much is pish tegj glob glob ?";
		String howMany = "how many Credits is glob prok Silver ?";
		
		List<String> splitQueryHowMuch = MerchantUtility.splitQuery(howMuch);
		List<String> splitQueryHowMany = MerchantUtility.splitQuery(howMany);
		
		List<String> expectedSplitQueryHowMuch = new ArrayList<String>(Arrays.asList(new String[] {"pish","tegj","glob","glob"}));
		List<String> expectedSplitQueryHowMany = new ArrayList<String>(Arrays.asList(new String[] {"glob","prok","Silver"}));
		
		Assert.assertEquals(expectedSplitQueryHowMuch, splitQueryHowMuch);
		Assert.assertEquals(expectedSplitQueryHowMany, splitQueryHowMany);
	}
	
}
