/*
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <algorithm>

int minCost(std::vector<std::vector<int>> &cost)
{
	int n = cost.size();
    if (n == 0) return 0;

	// Single array to store the minimum cost of painting up to the last house
	std::vector<int> dp(3);

	// Initialize with the costs of the first house
	for (int j = 0; j < 3; ++j) {
		dp[j] = cost[0][j];
	}

	// Iteratively update the array
	for (int i = 1; i < n; i++) {
		int prev_green = dp[0], prev_red = dp[1], prev_blue = dp[2];
		dp[0] = cost[i][0] + std::min(prev_red, prev_blue);
		dp[1] = cost[i][1] + std::min(prev_green, prev_blue);
		dp[2] = cost[i][2] + std::min(prev_green, prev_red);
	}

	return *min_element(dp.begin(), dp.end());
}