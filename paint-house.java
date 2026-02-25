// Solution - 1

// TimeComplexity: O(n)
// SpaceComplexity: O(1)
// Explanation: I solve it from the last house to the first. The array dp[0], dp[1], dp[2] represents the minimum cost to paint from the next house onward
//  if the current house is painted Red, Blue, or Green. For each house, I add its painting cost plus the minimum of the other two colors from the next house (since adjacent houses cannot have the same color).
//  Finally, I return the minimum of the three values.

class Solution {
    public int minCost(int[][] costs) {
        if(costs.length ==1) {
            return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        }
        Integer[] dp = new Integer[3];
        dp[0] = costs[costs.length-1][0];
        dp[1] = costs[costs.length-1][1];
        dp[2] = costs[costs.length-1][2];
        for(int i =costs.length-2; i>-1; i--) {
            int prev0 = dp[0];
            int prev1 = dp[1];
            int prev2 = dp[2];

            dp[0] = costs[i][0] + Math.min(prev1, prev2);
            dp[1] = costs[i][1] + Math.min(prev0, prev2);
            dp[2] = costs[i][2] + Math.min(prev0, prev1);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}


// Solution - 2

// TimeComplexity: O(n)
// SpaceComplexity: O(n)
// Explanation: Here I use a dp[i][color] table where it stores the minimum cost to paint from house i to the end if house i is painted with color.
//  I fill the table from bottom to top using the same transition rule (choose the minimum of the other two colors from the next house). 
// The answer is the minimum among the three colors for house 0.

class Solution {
    public int minCost(int[][] costs) {
        if(costs.length ==1) {
            return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        }
        Integer[][] dp = new Integer[costs.length][3];
        dp[costs.length-1][0] = costs[costs.length-1][0];
        dp[costs.length-1][1] = costs[costs.length-1][1];
        dp[costs.length-1][2] = costs[costs.length-1][2];
        for(int i =costs.length-2; i>-1; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}

// Solution - 3

// TimeComplexity: O(n)
// SpaceComplexity: O(n)
// Explanation: I use recursion and at each house decide the next house’s color (cannot be the same). 
// The function returns the minimum cost starting from index idx with a given color. I store results in dp[idx][color] to avoid recomputation. 
// This ensures each state is solved once.

class Solution {
    public int minCost(int[][] costs) {
        Integer[][] dp = new Integer[costs.length][3];
        // Red case
        int case1= helper(costs, 0, 0, dp);
        // blue case
        int case2= helper(costs, 1, 0, dp);
        // green case
        int case3= helper(costs, 2, 0, dp);
        return Math.min(case1, Math.min(case2, case3));
    }

    private int helper(int[][] costs, int color, int idx, Integer[][] dp) {
        // base
        if(idx==costs.length) return 0;
        if(dp[idx][color]!=null) return dp[idx][color];

        // logic
        int case1;
        int case2;
        if(color==0) {
            case1 = costs[idx][color] + helper(costs, 1, idx+1, dp);
            case2 = costs[idx][color] + helper(costs, 2, idx+1, dp);

        } else if(color==1) {
            case1 = costs[idx][color] + helper(costs, 0, idx+1, dp);
            case2 = costs[idx][color] + helper(costs, 2, idx+1, dp);
        } else {
            case1 = costs[idx][color] + helper(costs, 0, idx+1, dp);
            case2 = costs[idx][color] + helper(costs, 1, idx+1, dp);
        }
        int min = Math.min(case1, case2);
        dp[idx][color] = min;
        return min;
    }
}



// Solution - 4

// TimeComplexity: O(2ⁿ)
// SpaceComplexity: O(n)
// Explanation: Here I recursively try both possible colors for the next house at every step without storing results. 
// This causes repeated calculations of the same states, leading to exponential time complexity.


class Solution {
    public int minCost(int[][] costs) {
        // Red case
        int case1= helper(costs, 0, 0);
        // blue case
        int case2= helper(costs, 1, 0);
        // green case
        int case3= helper(costs, 2, 0);
        return Math.min(case1, Math.min(case2, case3));
    }

    private int helper(int[][] costs, int color, int idx) {
        // base
        if(idx==costs.length) return 0;

        // logic
        int case1;
        int case2;
        if(color==0) {
            case1 = costs[idx][color] + helper(costs, 1, idx+1);
            case2 = costs[idx][color] + helper(costs, 2, idx+1);

        } else if(color==1) {
            case1 = costs[idx][color] + helper(costs, 0, idx+1);
            case2 = costs[idx][color] + helper(costs, 2, idx+1);
        } else {
            case1 = costs[idx][color] + helper(costs, 0, idx+1);
            case2 = costs[idx][color] + helper(costs, 1, idx+1);
        }
        return Math.min(case1, case2);
    }
}
