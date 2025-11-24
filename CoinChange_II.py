'''
To solve this problem, I chose exhaustive approach by building a DP table
- Initially I stored first row and column with dummy values
- As long as the coin denomination is greater than the amount the case would be invalid
- If its not less, we calculate the number of ways, by taking its repeated sub problems which calculate the number of ways and add them
'''
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
         
        n = len(coins) # rows
        m = amount # columns
        
        # creating a DP table of n+1 rows(coins) and m+1 columns(amount)
        dp = [[0] * (m+1) for _ in range(n+1)]
        dp[0][0] = 1 # making first element as 1/ there is only 1 way to make zero amount, by not choosing any coin

        for i in range(1, n+1):
            for j in range (m+1):
                # till denomination > amount, case would be invalid
                if coins[i-1] > j:
                    # so we copy the result from above row
                    dp[i][j] = dp[i-1][j]
                else:
                    # filling current element with addition of:
                    # above row elemet (sub problem calculating part of no of ways)
                    # and element in the denominations steps back element(sub problem calculating part of no of ways)
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        # returning the last elemet which has no of ways to calculate the amount
        return dp[n][m]

'''
Time Complexity: O(n*m)
Since we are iterating on the DP table of size (n+1) * (m+1), we ignore the constants so O(n*m)
Space Complexity: O(m*n)
Since DP tables stores the results of all the coins count and amount
'''
