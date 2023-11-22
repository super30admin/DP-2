// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

/**
 * Using DP, use Choose or No choose approach. If an element is chosen, the no. of ways at the point will be count at coins[i]
 * index back in same row. If the element is not chosen, the no. of ways will be same row, 1 column above. Calculate the sum
 * of choose and no choose. Final ans will be in index m*n (last row, last col)
 */
class Solution {

    public int change(int amount, int[] coins) {

        int m = coins.length;
        int n = amount;
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= coins[i - 1])
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
            }
        }
        return dp[n];
    }
}


/*class Solution {

    public int change(int amount, int[] coins) {

        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j]
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }
        }

        return dp[m][n];
    }
}*/



/*
class Solution {
    public int change(int amount, int[] coins) {
        return helper(coins, amount, 0);
    }

    private int helper(int[] coins, int amount, int i) {

        //base
        if(amount == 0) return 1;
        if(i >= coins.length || amount < 0) return 0;

        //logic
        int case0 = helper(coins, amount, i+1);
        int case1 = helper(coins, amount-coins[i], i);

        return case0 + case1;
    }
}*/
