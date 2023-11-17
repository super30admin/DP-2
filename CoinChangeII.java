// Time Complexity: O(m * n)
// Space Complexity: O(m) 

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int m = amount;

        int dp[] = new int[m+1];
        dp[0] = 1;

        for(int i=0; i<n; i++){
            for(int j=1; j<=m; j++){
                if(j >= coins[i])
                    dp[j] += dp[j - coins[i]];
            }
        }
        return dp[m];
    }
}