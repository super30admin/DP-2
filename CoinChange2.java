// Time Complexity : O(n * m) 
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        int n = amount;
        int m = coins.length;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1; //1 way to reach amount zero with zero coin

        for(int i = 1; i <= m ; i++){ // coins
            for(int j = 0; j <= n; j++){ // amount

                if(j < coins[i-1]){ // till we reach the denomination of coin we can not achieve amount.
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    //sum of not choose and  choose
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }

        return dp[m][n];
    }
}
// Time Complexity : O(n * m) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach : Optimized space to use 1d array instead of 2d array.

class Solution {
    public int change(int amount, int[] coins) {
        int n = amount;
        int m = coins.length;
        int[] dp = new int[n+1];
        dp[0] = 1; //1 way to reach amount zero with zero coin

        for(int i = 1; i <= m ; i++){ // coins
            for(int j = 0; j <= n; j++){ // amount

                if(j < coins[i-1]){ // till we reach the denomination of coin we can not achieve amount.
                    dp[j] = dp[j];
                }
                else{
                    //sum of not choose and  choose
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }

        return dp[n];
    }
}