
public class PaintHouse {

	// TC: o(n)
	// SC: o(1)
	// min cost with variables and updating same array
	public int minCost(int[][] costs) {
		// null
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

	// TC: o(n)
	// SC: o(n)
	public int minCostDpSeparateArray(int[][] costs) {
		// null
		if (costs == null || costs.length == 0)
			return 0;

		int n = costs.length;

		int[][] dp = new int[n][3];

		for (int j = 0; j < 3; j++) {
			dp[n - 1][j] = costs[n - 1][j];
		}

		for (int i = n - 2; i >= 0; i--) {
			dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
			dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
			dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
		}

		return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
	}

	// TC: 2^n
	// SC: 2^n
	public int minCostExhaustive(int[][] costs) {
		// null
		if (costs == null || costs.length == 0)
			return 0;

		int caseR = helper(costs, 0, 0, 0);
		int caseB = helper(costs, 0, 1, 0);
		int caseG = helper(costs, 0, 2, 0);

		return Math.min(caseR, Math.min(caseB, caseG));
	}

	private int helper(int[][] costs, int index, int colour, int amount) {
		// base
		if (index == costs.length)
			return amount;

		// red =0, blue =1, green =2
		if (colour == 0) { // red
			return Math.min(helper(costs, index + 1, 1, amount + costs[index][0]),
					helper(costs, index + 1, 2, amount + costs[index][0]));
		} else if (colour == 1) {
			return Math.min(helper(costs, index + 1, 0, amount + costs[index][1]),
					helper(costs, index + 1, 2, amount + costs[index][1]));
		} else if (colour == 2) {
			return Math.min(helper(costs, index + 1, 0, amount + costs[index][2]),
					helper(costs, index + 1, 1, amount + costs[index][2]));
		}

		return 8080;
	}

}
