# Time Complexity : O(M * N) //It runs for the inner and outer loop for amount and length of coins array respectively
#  Space Complexity : O(M * N) //The space taken is also with respect to the nested loops
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        #Declare a dp with all possible combination for all possible values
        dp = [(0) for _ in range(amount + 1)]
        dp[0] = 1
        
        #iterate over the coins list and the amount required then add it to our dp the difference between the coin and current amount
        for i in coins:
            for j in range(amount + 1):
                if i <= j:
                    dp[j] += dp[j-i]
        return dp[amount]