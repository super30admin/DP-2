// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
	public int minCost(int[][] costs) {
		// Recursive approach (Exhaustive)
//        if (costs == null || costs.length == 0) return 0;
//        
//        int caseR = helper(costs, 0, 0, 0);
//        int caseB = helper(costs, 0, 1, 0);
//        int caseG = helper(costs, 0, 2, 0);
//        
//        return Math.min(caseR, Math.min(caseB, caseG));
//    }
//    
//    private int helper(int[][] costs, int index, int color, int amount) {
//        // base case
//        if (index == costs.length) return amount;
//        
//        // logic
//        if (color == 0) { // if the color chosen is red
//            int caseB = helper(costs, index+1, 1, amount + costs[index][0]); // choose blue color
//            int caseG = helper(costs, index+1, 2, amount + costs[index][0]); // choose green color
//            return Math.min(caseB, caseG);
//        } else if (color == 1) { // if the color chosen is blue
//            int caseR = helper(costs, index+1, 0, amount + costs[index][1]); // choose red color
//            int caseG = helper(costs, index+1, 2, amount + costs[index][1]); // choose green color
//            return Math.min(caseR, caseG);
//        } else if (color == 2) { // if the color chosen is green
//            int caseR = helper(costs, index+1, 0, amount + costs[index][2]); // choose red clor
//            int caseB = helper(costs, index+1, 1, amount + costs[index][2]); // choose blue color
//            return Math.min(caseR, caseB);
//        }
//        
//        return -1;

		// Dynamic Programming (Bottom-Up approach)
		// Time complexity : O(n)
		// Space complexity : O(n)
//		if (costs == null || costs.length == 0)
//			return 0;
//
//		int n = costs.length;
//		int[][] dp = new int[n][3]; // 1D array can be optimized to 3 variables as we override the value of each row, instead we can just use 3 variables
//
//		for (int j = 0; j < 3; j++) {
//			dp[n - 1][j] = costs[n - 1][j];
//		}
//
//		for (int i = n - 2; i >= 0; i--) {
//			dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
//			dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
//			dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
//		}
//
//		return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));

		// Optimal solution
		if (costs == null || costs.length == 0)
			return 0;

		int n = costs.length;
		int costR = costs[n - 1][0];
		int costB = costs[n - 1][1];
		int costG = costs[n - 1][2];

		for (int i = n - 2; i >= 0; i--) {
			int tempR = costR;
			int tempB = costB;
			costR = costs[i][0] + Math.min(costB, costG);
			costB = costs[i][1] + Math.min(tempR, costG);
			costG = costs[i][2] + Math.min(tempR, tempB);
		}

		return Math.min(costR, Math.min(costB, costG));
	}
}