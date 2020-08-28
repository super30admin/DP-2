# // Time Complexity :  O(n*m)
# // Space Complexity : O(n*m)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No, mainly because it was similar to coin change-1

# // Your code here along with comments explaining your approach

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        # initialize the matrix 
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        
        # set one as there is one way to make the amount... that is-> an empty array 
        for i in range(len(coins)+1):
            dp[i][0] = 1
            
        # set 0, by hit and trial setting this to infinity would result in an edge case of inf+1
        for j in range(1, amount+1):
            dp[0][j] = 0
            
        # if amount is greater than the coin denomination, copy the value from (i-1) index
        # else, add the values if the coin denomination was chosen(1)+ the already calculated value(number of ways used to calculate: amount-chosen denomination) 
        
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j< coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
                    
        return dp[len(coins)][amount]
        
        
        
        