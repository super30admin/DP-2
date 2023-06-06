class Solution(object):
    def change(self, amount, coins):
        """
        Time complexity: O(m * n)
        Space complexity: O(m * n)
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # no denominations provided return 0
        if len(coins) == 0:
            return 0

        # Get the length of coins array (m) and the amount (n)
        m = len(coins)
        n = amount

        # 2D array, dp[i][j] represents the number of combinations for making amount j using the first i coins
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        # Initialize the base case where amount is 0, there is only 1 combination (not choosing any coin)
        dp[0][0] = 1

        # Iterate over the coins and the amount to calculate the number of combinations
        for i in range(1, m + 1):
            for j in range(n + 1):
                if j < coins[i - 1]:
                    # If the current amount j is less than the current coin value, exclude the coin and take the value from the previous row
                    dp[i][j] = dp[i - 1][j]
                else:
                    # Otherwise, add the combinations from the previous row (excluding the current coin) and the current amount minus the coin value
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        # Return the number of combinations for making the amount using all the coins
        return dp[m][n]
