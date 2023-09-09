// Time Complexity : O(n) we loop through all characters of string s
// Space Complexity : O(1) we store upto 52 characters in the hashSet (all lowercase and uppercase letters)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public int change(int amount, int[] coins) {
        if(coins.length == 0 || coins == null) return 0;

        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i < coins.length + 1; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < coins.length+1; i++){
            for(int j = 1; j < amount+1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i -1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
