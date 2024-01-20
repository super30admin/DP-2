Time: O(mn) Space: O(mn)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        dp = [[0 for _ in range(amount + 1)] for _ in range(n + 1)]

        # There is one way to make the amount 0, which is not using any coins
        for i in range(n + 1):
            dp[i][0] = 1

        for i in range(1, n + 1):
            for j in range(1, amount + 1):
                # If the coin value is less than or equal to the amount
                if coins[i - 1] <= j:
                    # Number of combinations with and without the current coin
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j]
                else:
                    # If the coin value is greater than the amount, it cannot be included
                    dp[i][j] = dp[i - 1][j]

        return dp[n][amount]

// Time Complexity : O(n)
// Space Complexity : O(n)

# space optimization note: remember mutation/ you can use three vars

class Solution:
    MAX_INT = 2**31 - 1 
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        n = len(costs)
        dp = [[0 for _ in range(3)] for _ in range(n)]
        for j in range(3):
            dp[n-1][j] = costs[n-1][j]
        for i in range(n-2,-1,-1):
            print(i)
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
        return min(dp[0][0], dp[0][1], dp[0][2])

// we can optimize both problems then space comp will be O(n) and O(1) acc.
