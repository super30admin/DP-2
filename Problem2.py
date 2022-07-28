# Time Complexity : O(m*n) --> m - number of coins and n - amount
# Space Complexity : O(m*n) --> m - number of coins and n - amount
# Leetcode : Solved and submitted

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
      
        # return 0 if the length of the coins List is 0, which is there is no coin
        if len(coins) == 0:
            return 0
        m = len(coins)
        n = amount
        
        # build a matrix that will keep a count of the ways where we can make the amount with the given coins
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        
        # For the base case, we keep it as 1, this is a valid argument
        dp[0][0] = 1
        
        # we then traverse through the matrix to update the index where the amount would be reached with the coins provided
        for i in range(1,m+1):
            for j in range(n+1):
              
                # if we the amount is the less than the denomination of the given coin, then we copy the values from the top, as till then 
                # the number of ways would remain same
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    # if we can have more ways at this point, then we simply add the values present on the top of the current index and also the value
                    # that we get from the matrix on the same row but j - coins[i-1] index apart which is basically the coin denomination
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
                    
        return dp[m][n]
