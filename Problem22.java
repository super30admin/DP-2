// Time Complexity : O(nT) where n is the no of coins & T is the target
// Space Complexity : O(n) 

// Approach:
//     Create a 2D matrix. Initialize the dp[i][0] with 1 as there are ways to create 0 from any number.
//     Initailize dp[0][j], where j =1 to target, with 0 as there are 0 ways to create any number with 0.
//     Loop through i = 1 to coins.length & j =1 to target, for dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
//     Return the last element of matrix.


class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0; i<=coins.length; i++){
            dp[i][0] = 1;
        }
        
        for(int j=1; j<=amount; j++){
            dp[0][j] = 0;
        }
        
        for(int i=1; i<=coins.length; i++){
            for(int j =1; j<=amount; j++){
                if(j<coins[i-1]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        return dp[coins.length][amount];
    }
}