// Time Complexity : O(m * n)
// Space Complexity : O(m * n) where m is the number of coins and n is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Recursive Approach

/**
 * we can use any coin multiple times in this solution.
 * we have to return the number of possible combinations that can be made to equal the amount
 * We make a decision on each coin whether to choose the coin or not.
 * If we choose the coin, we subtract the coin value from the amount and pass it to next recursive call.
 * If we don't choose the coin, we pass the same amount and pass the next coin to the recursive call
 * 
 * we return 1 when the amount becomes 0;
 * 
 * in the end, we return sum of both the cases.(choose and not_choose)
 */

class Solution {
    public int change(int amount, int[] coins) {
        
        return helper(coins, amount, 0);   
    }
    
    private int helper(int[] coins, int amount, int index) {
        if(amount == 0) {
            return 1;
        }
        
        if(index == coins.length || amount < 0) {
            return 0;
        }
        
        // do not choose case
        int not_choose = helper(coins, amount, index + 1);
        
        // choose case
        int choose = helper(coins, amount - coins[index], index);
        
        return not_choose + choose;
    }
}


// Dynamic programming approach

class Solution {
    public int change(int amount, int[] coins) {
        
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        // fill 1s in 0th column
        for(int i=0;i<dp.length;i++) {
            dp[i][0] = 1;
        }
        
        // fill 0s in the 0th row
        // except the 0th column
        
        for(int j=1;j<dp[0].length;j++) {
            dp[0][j] = 0;
        }
        
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                // j is the amount here
                if (j < coins[i-1]) {
                    // we just have to pick the above element
                    dp[i][j] = dp[i-1][j];
                } else {
                    // coin denomination is less than or equal to the amount
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length -1];
    }
}

