// Time Complexity : O(n*m)
// Space Complexity : SC=O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: 2 choices for each coin, choose or not choose, create dp matrix for better understanding of size (no of coins+1)*(amount+1). Initialize [0][0] cell as 1 since 1 way is possible with 0 coins and 0 amt. Then loop through i frm 1 to i<= n and j from 0 to j<=m, if j<coins[i-1] means amt is higher than coin value so no choose case, then dp[i][j]=dp[i-1][j] else choose there have 2 choices no choose and choose, take sum of choose and no choose options. dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]], ans will be store bottom right of matrix i.e. dp[n][m]
//In optimal version, instead of matrix dp[] is used, no change value is at same place and that cell gets updated for next iteration, saves space due to [] array. but same time complexity

public class CoinChange2 {
//    Approach 1 - Dynamic programming - Tabulation TC=O(m*n), SC=O(m*n)
    // public int change(int amount, int[] coins) {
    //     int m = coins.length;
    //     int n = amount;
    //     int[][] dp = new int[m+1][n+1]; //to store cnt of ways of making coin change

    //     //initialize first 0 like with 0 coins and 0 amt, 1 ways possible, like 0 amt is possible with any no of coins so cnt is 1
    //     dp[0][0] = 1;   //in recursssion, when amt reaches 0 then we incremented count

    //     //loop through values of m and n in matrix
    //     for(int i = 1; i <=m; i++) {
    //         for(int j = 0; j <= n; j++) {
    //             if(j < coins[i-1]) {    //amt less than coin denomination so no choose case
    //                 dp[i][j] = dp[i-1][j];
    //             } else {
    //                 dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]];
    //             }
    //         }
    //     }
    //     return dp[m][n];
    // }

    //    Approach 2 - Dynamic programming - Tabulation TC=O(m*n), SC=O(n)
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];

        dp[0] = 1;

        for(int i = 1; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                //if amt is less then no choose case in that case we use same value in current cell
                if(j >= coins[i - 1]) { //if amt is greater or equal to denomination of coin then choose case
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        CoinChange2 solver = new CoinChange2();

        int amount1 = 5;
        int[] coins1 = {1, 2, 5};
        System.out.println("Ways to make " + amount1 + " with coins [1, 2, 5]: " + solver.change(amount1, coins1));
        // Expected: 4

        int amount2 = 3;
        int[] coins2 = {2};
        System.out.println("Ways to make " + amount2 + " with coins [2]: " + solver.change(amount2, coins2));
        // Expected: 0 (no way to form 3 using only coin 2)
    }
}
