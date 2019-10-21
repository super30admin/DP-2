// 518. Coin Change 2, using Recursion, brute force
// Time Complexity: O(m^n) m is the amount, n is the number of coins
// Space Complexity: O(n)

class Solution {
    public int change(int amount, int[] coins) {
        return helper(amount, coins, 0);
    }

    public int helper(int amount, int[] coins, int i){
        if(amount == 0) return 1;

        if(amount < 0 || i > coins.length - 1) return 0;

        //Choose coin
        int case1 = helper(amount-coins[i], coins, i);

        //Dont choose coin
        int case2 = helper(amount, coins, i+1);

        return case1+case2;
    }
}

// 518. Coin Change 2, DP
// Time Complexity: O(m*n)
// Space Complexity: O(m*n)

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];

        int m = dp.length;
        int n = dp[0].length;

        dp[0][0] = 1;

        for(int i=1; i<m; i++){
            dp[i][0] = 1;
            for(int j=1; j<n; j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }
        }
        return dp[m-1][n-1];
    }
}