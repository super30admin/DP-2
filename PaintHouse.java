// Time Complexity : O(n)
// Space Complexity : O(1)
// Method : DP

class Solution {
    public int minCost(int[][] costs) {
        
        int minimum = Integer.MAX_VALUE, n = costs.length;

        for(int i = n - 2; i >= 0; i--)
        {
            for(int j = 0; j < 3; j++)
            {
                if(j == 0) costs[i][j] += Math.min(costs[i + 1][j + 1], costs[i + 1][j + 2]);

                else if(j == 2) costs[i][j] += Math.min(costs[i + 1][j - 1], costs[i + 1][j - 2]);

                else costs[i][j] += Math.min(costs[i + 1][j - 1], costs[i + 1][j + 1]);
            }
        }

        for(int j = 0; j < 3; j++) minimum = Math.min(minimum, costs[0][j]);

        return minimum;
    }
}