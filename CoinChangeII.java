// in this problem repeated subproblems exists
// we use 1D array here
// we should be counting only valid notes using tabulation
// Time : O(m x n)  m = coins, n = amount
// Space : O(m x n)
// This solution worked over leetcode!

class Solution {

    public int change(int amount, int[] coins) {
       int m = coins.length;
       int n = amount;

        int[] dp = new int[n+1]; // 1D arr
        dp[0] = 1; // base case without any coin to reach amount zero

        for(int i=1; i<=m; i++) { // coins
            for(int j=0; j<=n; j++) { // amount
                if(j < coins[i-1]) {
                    dp[j] = dp[j]; // choose case
                }else { // choose case + no choose case
                    dp[j] = dp[j] + dp[j-coins[i-1]]; 
                }
            }
        }
        return dp[n];
    }

}
