#Time Complexity : O(m*n)
#Space Complexity : O(amount)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
    
        col = amount + 1
        rows = len(coins) + 1
        dp = (col) * [0]
        dp[0] = 1
        for i in range(0,len(coins)):
            for j in range(coins[i],len(dp)):
                dp[j] = dp[j] + dp[j-coins[i]]
 
                
        return dp[-1]