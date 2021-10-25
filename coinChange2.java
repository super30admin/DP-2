// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class coinChange2Solution {
    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = 0;
        }
        
        for (int row = 1; row <= coins.length; row++) {
            for (int column = 1; column <= amount; column++) {
                
                if (column < coins[row-1]) {
                    dp[row][column] = dp[row-1][column];
                }
                else {
                    dp[row][column] = dp[row-1][column] + dp[row][column - coins[row-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[] {1,2,5};
        int amount = 7; 
        int result;
        result = change(amount, coins);
        System.out.println(result);
    }
}