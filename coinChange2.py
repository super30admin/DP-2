# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : y
# Any problem you faced while coding this : n


# Your code here along with comments explaining your approach

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins:
            return 0
        
        m = amount+1
        n = len(coins) + 1
        
        dp = [[0 for x in range(m)] for y in range(n)]
        
        # Fill first columns
        for i in range(n):
            dp[i][0] = 1
        
            
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                
                # denomination < amount
                if (coins[i-1] > j):
                    dp[i][j] = dp[i-1][j] # copy whatever is above in the matrix
                
                else:
                    dp[i][j] =  dp[i-1][j] + dp[i][j - coins[i-1]]
                    
        print(dp)
        return dp[len(coins)][amount]
    # return dp[-1][-1]


# unlike coin change, instead of taking the min of [i-1][j] and [i][j - coins[i-1]], we are summing them up