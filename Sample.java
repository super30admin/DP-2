// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        int n = amount;
        int m = coins.length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i<=m; i++){
            dp[i][0] = 1;
        }for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        } return dp[m][n];
        
    }
}

// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int costR = costs[n-1][0];
        int costB = costs[n-1][1];
        int costG = costs[n-1][2];
        for(int i = n-2; i>= 0; i--){
            int tempR = costR;
            costR = costs[i][0] + Math.min(costB, costG);
            int tempB = costB;
            costB = costs[i][1] + Math.min(tempR, costG);
            costG = costs[i][2] + Math.min(tempR, tempB);
            }
            return Math.min(costR, Math.min(costB, costG));
    }
}