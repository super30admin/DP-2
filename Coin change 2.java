/*
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins is None:                   # if we put len(coins) == 0 here we will miss out one case where coins is empty and expected is 0
            return 0
        
        def helper(coins, amount, index):
            if amount == 0:
                return 1
            
            if index == len(coins) or amount < 0:
                return 0
            
            case1 = helper(coins, amount-coins[index], index)
            case2 = helper(coins, amount, index+1)
            
            return case1 + case2
        
        return helper(coins, amount, 0)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins is None:
            return 0
        
        dp = [[0]*(amount + 1)]*(len(coins)+1)
        rows, cols = len(dp), len(dp[0])
        for i in range(rows):
            dp[i][0] = 1
        
        for i in range(1, rows):
            for j in range(1, cols):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
                    
        return dp[rows-1][cols-1]
                
*/

// Time Complexity : O(rows * cols)
// Space Complexity : O(rows * cols)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I maintained a dp array and calculated using equation 
// dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null)
            return 0;
        
        int[][] dp = new int[coins.length+1][amount+1];
        int rows = dp.length, cols = dp[0].length;
        for (int i=0; i<rows; i++){
            dp[i][0] = 1;
        }
        for (int i=1; i<rows; i++){
            for (int j=1; j<cols; j++){
                if (j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[rows-1][cols-1];
        
    }
}