#Time Complexity : O(m*n) ... where n is the number of houses
#Space Complexity : O(m*n) ... where n is the number of houses
#Any problem you faced while coding this : -

# Used the bottom up tabulation method of dynamic programming programming. Referenced a table where the previously solved sub-problem values were used to iteratively build the soltuion.

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins == None:
            return 0

        m = len(coins)
        n = amount

        dp = [[0 for _ in range(n+1)]for _ in range(m+1)]
        dp[0][0] = 1
        
        for i in range(1, m+1):
            for j in range(n+1):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]

        return dp[m][n]