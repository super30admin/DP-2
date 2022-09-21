public class Paint_House {

    public class Solution {
        public int minCost(int[][] costs) {
            int len = costs.length;

            if(costs != null && len == 0) {
                return 0;
            }

            int[][] dp = costs; 
            for(int i = 1; i < len; i++){
                dp[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
                dp[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
                dp[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
            }

            return Math.min(dp[len - 1][0], Math.min(dp[len - 1][1], dp[len - 1][2]));
        }
    }
}