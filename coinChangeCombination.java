// Time Complexity : O(mn), where m is no of coins and n is amount
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0 || amount == 0) return 0;
        int m = coins.length, n = amount;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i<= m; i++){
            for(int j = 0;j<= n; j++){
                //if amount < denomination
                if(j < coins[i-1]){
                    //case0
                    dp[j] = dp[j];
                }else{
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }
        
        return dp[n];
    }
}