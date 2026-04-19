    /**
    Time Complexity : O(M * N)
    Explanation:
    M = number of coins
    N = amount
    For each coin, we iterate through all amounts from 0 to amount.

    Space Complexity : O(N)
    Explanation:
    We use a 1D DP array of size amount + 1.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially made a mistake with the loop variable because 'm' was not defined.
    Also needed to understand why the outer loop should iterate over coins
    to avoid counting duplicate combinations.
    Fixed it by using:
        - outer loop for each coin
        - inner loop for all amounts
    */

        class Solution {



            public int change(int amount, int[] coins) {
        
                int n = amount + 1;
                int m = coins.length + 1;
        
                int[] dp = new int[n];
                dp[0] = 1;
        
                for (int i = 1; i < m; i++) {
                    for (int j = 0; j < n; j++) {
        
                        if (j >= coins[i - 1]) {
                            dp[j] = dp[j] + dp[j - coins[i - 1]];
                        }
                    }
                }
        
                return dp[n - 1];
            }
        }