
# 518. Coin Change 2

# code:

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        # Initalizing the dp array
        dp =[[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        
        # Initializing the first column of each row to 1 since []
        for i in range(len(coins)+1):
            dp[i][0] =1
        
        # If we have coin value greater than or equal to amount,
        # we add prev+coin times backward amount
        
        for i in range(1,len(coins)+1):
            for j in range(1, amount+1):
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        
        return dp[-1][-1]
            

# Time Complexity: O(N * M)
# Space Complexity: O(N * M)
# Accepted on Leetcode: Yes.
# Any Difficulty faced. No.