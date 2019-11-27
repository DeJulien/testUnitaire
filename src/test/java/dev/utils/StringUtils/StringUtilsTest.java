package dev.utils.StringUtils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testLevenshteinDistance() {

		int test=0;
		
		String lhs="cha1";
		String rhs="chats";
		
		if (lhs == null) 
			throw new IllegalArgumentException("La variable ne doit pas être null");
	    if (rhs == null) 
			throw new IllegalArgumentException("La variable ne doit pas être null");
		
		String temps=(String) lhs;
		lhs=temps.trim();
		
		temps=(String) rhs;
		rhs=temps.trim();
		
			 
		int len0 = lhs.length() + 1;
		int len1 = rhs.length() + 1;

		int[] cost = new int[len0];
		int[] newcost = new int[len0];

		 for (int i = 0; i < len0; i++) {
		cost[i] = i;
		}

		 for (int j = 1; j < len1; j++) {
		newcost[0] = j;
		for (int i = 1; i < len0; i++) {
		int match = (lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1;

		int costReplace = cost[i - 1] + match;
		int costInsert = cost[i] + 1;
		int costDelete = newcost[i - 1] + 1;

		newcost[i] = Math.min(Math.min(costInsert, costDelete), costReplace);
		 }

		int[] swap = cost;
		cost = newcost;
		newcost = swap;
		 }
		 
		 test=cost[len0 - 1];
		
		
		assertEquals(2, test);
	}

}
