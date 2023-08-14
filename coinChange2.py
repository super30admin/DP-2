# Time Complexity : O(M * N) where M = # of rows, N = # of columns
# Space Complexity : O(M * N) where M = # of rows, N = # of columns
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I made the mistake for starting the nested 
# for loops by 1

class Solution:
    def coinChange(self, coins, amount) -> int:

        if len(coins) == 0 or coins is None:
            return 0
        
        # declaring 2d dp matrix with dummy row and column
        dp = [[0 for _ in range(amount + 1)] for _ in range(len(coins) + 1)]

        # if you have to make amount 0 with coin of denomination 1, 
        # you can do it in one combination, which is to not choose the 
        # coin of denomnation 1
        for i in range(len(dp)):
            dp[i][0] = 1

        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):

                # zero case
                # if the amount is less than the denomination of coins available
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:

                    # just add the zero case and 1 case
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
                
        return dp[len(dp) - 1][len(dp[0]) - 1]


amount = 5
coins = [1,2,5]
obj = Solution()
print("\nThe possible combinations are:")
print(obj.coinChange(coins, amount))
print()
