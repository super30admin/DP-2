# DP-2

## Problem1(https://leetcode.com/problems/paint-house/)
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
	1.	The exhaustive approach gave a time complexity of O(3^n), since for each house we try 3 color options recursively. But this leads to repeated subproblems.
	2.	To avoid recomputation, I switched to bottom-up DP, where we start filling from the second-last house up to the first.
	3.	At each house, we compute the minimum cost of painting it with each color by adding the cost of painting it with that color plus the minimum cost of painting the next house with a different color.
    
class Solution {
    public int minCost(int[][] costs) { // 0-R, 1-B, 2-G
        
        int n = costs.length;

        for(int i = n-2; i>=0; i++){
            for(int j=0; j<3; j++){
                if(j == 0){
                    costs[i][j] += Math.min(costs[i+1][j+1], costs[i+1][j+2]);
                }

                else if(j == 1){
                    costs[i][j] += Math.min(costs[i+1][j-1], costs[i+1][j+1]);
                }

                else{
                    costs[i][j] += Math.min(costs[i+1][j-1], costs[i+1][j-2]);
                }
            }
        }

        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

}

             

## Problem2 (https://leetcode.com/problems/coin-change-2/)
// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. My first approach was to use Exhaustive approach but the TC was O(2^n) which is very high but I was able to see that there were repeating subproblems so I thought of using DP
2. We declare a 2D array where rows represent the value of the coins and the cols represent the amount
3. We will check the coin value with the amount and if the coin value is greater than the amount than we will just put the total number of coins that make up to that amount from the prev row
4. Else we will add the number of coins from the previous row and the total number of coins needed from the current coins value 
5. We will return the maximum number of coins that formed that value or 0(in case all the coins were greater than the amount)


class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        int dp[][] = new int[coins.length+1][amount+1];

        for(int i = 0; i<coins.length+1; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i<coins.length+1; i++){
            for(int j = 1; j<amount+1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[coins.length][amount] == 0 ? 0 : dp[coins.length][amount];
    }
}