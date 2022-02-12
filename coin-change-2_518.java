// Time Complexity :O(A*C)  where A = amount and C= number of coins
// Space Complexity : O(A*C)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// dp[i][j] = dp[i][j-coin[i]] + dp[i-1][j]
//dp[i][j] =. number of ways to make amount j using coins 0 to i

class Solution {
    public int change(int amount, int[] coins) {

        //dp[i][j] =. number of ways to make amount j using coins 0 to i
        int[][] dp = new int[coins.length+1][amount+1];
        //base case:
        dp[0][0] = 1; //number of ways to make amount 0 using 0 coins is 1
        for(int i=1; i <=amount; i++) {
            dp[0][i] = 0; // number of ways to make amount 1 till end  using 0 coins is 0
        }

        for (int i=0; i <= coins.length; i++) {
            dp[i][0] = 1; //number of ways to make amout 0 using any coins is 1, ie not choosing any coin
        }

        for (int i=0; i<coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                dp[i+1][j] = (j-coins[i] >=0 ? dp[i+1][j-coins[i]] : 0) + dp[i][j];
            }
        }
        return dp[coins.length][amount];

    }
}
