/* Time Complexity : O(n)
 * 	n - rows in the input - costs */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this :

public class PaintHouse {
	public int minCost(int[][] costs) {
		
		if(costs == null) return 0;
		
		int n = costs.length;		
		int costR = costs[n-1][0];//R
		int costB = costs[n-1][1];//B
		int costG = costs[n-1][2];//G
		
		for(int i = n-2; i >= 0; i++) {
			int tempR = costR;
			int tempB = costB;
			//cost = curr. cost + Min of(costs in below row except the adjacent)
			costR = costs[i][0] + Math.min(costB, costG);
			costB = costs[i][1] + Math.min(tempR, costG);
			costG = costs[i][2] + Math.min(tempB, tempR);
		}
		return Math.min(costR, Math.min(costB, costG));
		
	}
	
}

/*


/* Time Complexity : O(n+3) ~ O(n)
 * 	n - rows in the input - costs
 *  3 - as they have mentioned 3 colors in the problem definition*/
/* Space Complexity : O(n) 

//Matrix --> Array


public class PaintHouse {
	public int minCost(int[][] costs) {
		
		if(costs == null) return 0;
		
		int n = costs.length;
		int[] dp = new int[3];
		dp[0] = costs[n-1][0];//R
		dp[1] = costs[n-1][1];//B
		dp[2] = costs[n-1][2];//G
		
		for(int i = n-2; i >= 0; i++) {
			int tempR = dp[0];
			int tempB = dp[1];
			//cost = curr. cost + Min of(costs in below row except the adjacent)
			dp[0] = costs[i][0] + Math.min(dp[1], dp[2]);
			dp[1] = costs[i][1] + Math.min(tempR, dp[2]);
			dp[2] = costs[i][2] + Math.min(tempB, tempR);
		}
		return Math.min(dp[0], Math.min(dp[1], dp[2]));
		
	}
	
}


*/


/*

/* Time Complexity : O(n+3) ~ O(n)
 * 	n - rows in the input - costs
 *  3 - as they have mentioned 3 colors in the problem definition*/
/* Space Complexity : O(n*3) ~ O(n)

//Matrix

public class PaintHouse {
	public int minCost(int[][] costs) {
		
		if(costs == null) return 0;
		
		int n = costs.length;
		int[][] dp = new int[n][3];
		dp[n-1][0] = costs[n-1][0];//R
		dp[n-1][1] = costs[n-1][1];//B
		dp[n-1][2] = costs[n-1][2];//G
		
		for(int i = n-2; i >= 0; i++) {
			//cost = curr. cost + Min of(costs in below row except the adjacent)
			dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
			dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
			dp[i][2] = costs[i][2] + Math.min(dp[i+1][1], dp[i+1][0]);
		}
		return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
		
	}
	
}


*/


/*

 /* Time Complexity : O(2^(n+3)) ~ O(2^n))
 * 	n - rows in the input - costs
 *  3 - as they have mentioned 3 colors in the problem definition*/
/* Space Complexity : O(m*n)
 
 
//Exhaustive solution


public class PaintHouse {
	
	public int minCost(int[][] costs) {
		
		if(costs == null) return 0;
		
		int costR = helper(costs, 0, 0);
		int costB = helper(costs, 0, 1);
		int costG = helper(costs, 0, 2);
		
		return (Math.min(costR, Math.min(costB, costG)));
	}
	
	private int helper(int[][] costs, int index, int color) {
		//base case
		if(index == costs.length) return 0;
		
		//Red
		if(color == 0) {
			return costs[index][0] + Math.min(helper(costs, index + 1, 1), helper(costs, index + 1, 2));
		}
		//Blue
		if(color == 1) {
			return costs[index][1] + Math.min(helper(costs, index + 1, 0), helper(costs, index + 1, 2));
		}
		//Green
		if(color == 2) {
			return costs[index][2] + Math.min(helper(costs, index + 1, 1), helper(costs, index + 1, 0));
		}
		
		return Integer.MAX_VALUE; //dead code
	}
}


*/