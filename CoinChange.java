// Time Complexity : O(NxM)
// Space Complexity : O(NxM)	where N & M are rows and columns of the matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No

class Solution {
     public int change(int amount, int[] coins) {
         int[][] dp = new int[coins.length + 1][amount + 1]; 	// initialize the matrix with one extra row and column for the null case and not chosen case
         dp[0][0] = 1;
         
         for(int i = 1; i<= amount; i++){		// initialize the 0th row to zeros as we cannot make any combinations with that
             dp[0][i] = 0;
         }
         
         if((coins.length == 0 || coins == null)){	// if the null array is given and amount is specified, locate the given the index and return the value
             return dp[0][amount];
         }
         
         for(int i = 1; i<= coins.length; i++){		// finding all the combinations of the amount for all coins
             for(int j = 0; j <= amount; j++){		// traversing through all possible coins till the amount specified
                 if(j < coins[i-1]){				// copy the elements until the given amount is reached
                     dp[i][j] = dp[i-1][j];
                 }else{								// for columns greater than the amount, add the elements 1 row above in the same column and value from (column - the denominations of the coin)
                     dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                 }
                 //System.out.print(dp[i][j]);
             }
             //System.out.println();
         }
         
        return dp[coins.length][amount];			// return the last element in the matrix.
    }
}