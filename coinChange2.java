/* Time complexity: O(n*T); where n is the number of coins available and T is the target sum
Space Complexity: O(n*T)

1. Using Dynamic programming to find the number of ways with which you can obtain a total of target sum by adding up the coins of different denominations given.
2. Since same suproblems are called again, this problem has Overlapping Subprolems property. So the Coin Change problem has both properties of a dynamic programming problem.
3. The last element in the table gives the desired result.

*/

class Solution{
    public int coinChange2(int[] coins, int target){
        int[][] dp = new int[coins.length+1][target+1];

        for(int i=0; i<=coins.length; i++){
            dp[i][0] = 1;
        }

        for(int j=0; j<=target; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<=coins.length; i++){
            for(int j=1; j<=target+1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }

                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }

        int val = dp[coins.length][target];
        if(val == 0){
            return 0;
        }
        else{
            return val;
        }
    }
}