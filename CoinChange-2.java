// Recursive solution - O(2^N)

// class Solution {
//     public int change(int amount, int[] coins) {
//         return helper(coins, amount, 0);       
//     }
    
//     private int helper(int[] coins, int amount, int index)
//     {
//         //base case
//         if (amount == 0) 
//             return 1; // valid path
//         if ( amount < 0 || index >= coins.length)
//              return 0; // invalid path 
            
//         // main logic
//         // choose the coin
//         int case1 = helper(coins, amount - coins[index], index);
        
//         // dont choose the coin
//         int case2 = helper(coins, amount, index+1);
//         return case1+case2;
//     }
// }

// Bottom up DP - O(M*N) - O(coins.length + 1 * amount +1 )
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        // fill first column with 1
        for ( int i = 0; i < dp.length; i++ )
        {
            dp[i][0] = 1;
        }
        // fill in the DP matrix
        for (int i = 1; i < dp.length; i++)
        {
            for ( int j = 1; j < dp[0].length; j++)
            {
                if (j < coins[i-1])
                {
                    // copy from previous row
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    // previous row value + value from 'j' steps back
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
    return dp[dp.length-1][dp[0].length-1];
    }
}
