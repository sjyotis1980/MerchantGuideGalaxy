/*
 * The information contained in this document is subject to change without notice.
 * 
 * Developer MAKES NO WARRANTY OF ANY KIND WITH REGARD TO
 * THIS MATERIAL, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. Except to
 * correct same after receipt of reasonable notice, GoldenSource Corporation 
 * shall not be liable for errors contained herein or for incidental and/or 
 * consequential damages in connection with the furnishing, performance, 
 * or use of this material.
 * 
 * This document contains proprietary and confidential information that is protected by copyright.
 * 
 * The names of other organizations and products referenced herein are the trademarks or service
 * marks (as applicable) of their respective owners. Unless otherwise stated herein, no association
 * with any other organization or product referenced herein is intended or should be inferred.
 * 
 * 
 */

package com.merchantguidegalaxy;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Class to test {@link LineTypeEnum}.
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class LineTypeEnumTest 
{

	@Test
	public void testGetLineType()
	{
		String commMatch = "how much comm pish of Gold is Silver?";
		LineTypeEnum lineType = LineTypeEnum.getLineType(commMatch);
		
		Assert.assertEquals(LineTypeEnum.QUESTION_HOW_MUCH_COMM, lineType);
	}
}
