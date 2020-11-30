// Time Complexity : O(mn) (where m is size of coin array and n is the amount)
// Space Complexity : O(mn) (where m is size of coin array and n is the amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins==null)
            return 0;
        int dp[][] = new int[coins.length+1][amount+1];
        int m = dp.length, n = dp[0].length;
        for(int i=0; i <m; i++) {
            dp[i][0] = 1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m-1][n-1];
    } 
}