// Time Complexity : O(n*m) -> n = no of coins ; m = amount
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
// Your code here along with comments explaining your approach

// I used a bottom-up dynamic programming approach where dp[i][j] represents
// the number of ways to make amount j using the first i coins.
// First, I initialized the first column with 1s because there's always 1 way to make amount 0 (by choosing nothing).
// Then, for each coin, I checked two possibilities for every amount: not taking the coin, or taking it.
// I updated the dp table accordingly, and finally returned dp[n][amount] which gives total number of combinations.


public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return amount == 0 ? 1 : 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        CoinChange2 ob = new CoinChange2();
        int[] coins1 = {1, 2, 5};
        int[] coins2 = {2};
        int[] coins3 = {10};

        System.out.println("No of ways to make up the amount is : " + ob.change(5, coins1));  
        System.out.println("No of ways to make up the amount is : " + ob.change(3, coins2));  
        System.out.println("No of ways to make up the amount is : " + ob.change(10, coins3)); 
    }
}
