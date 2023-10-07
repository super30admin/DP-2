# // Time Complexity : O(N*A)
# // Space Complexity : O(N*A)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[-1 for _ in range(amount+1)] for _ in range(len(coins))]

        def helper(n, amount):
            #Amount check first - only then idx check --> Ex: [10] and amount 10
            if amount == 0: return 1
            elif amount < 0 or n <0:    return 0
            elif dp[n][amount] != -1:   return dp[n][amount]
        
            include = helper(n, amount - coins[n])
            exclude = helper(n-1, amount)

            dp[n][amount] = include + exclude
            return dp[n][amount]
        
        return helper(len(coins)-1, amount)