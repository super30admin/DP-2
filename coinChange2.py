# // Time Complexity : O(2^N) (exponential since we are iterating over all the possiblilites)
# // Space Complexity : stack space for all the calls at max time they will be half of the tree(O(N))
# // Did this code successfully run on Leetcode : No (TLE)
# // Any problem you faced while coding this : Nope

class RecursiveSolution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins:
            return 0
        return self.helper(coins, amount, 0)

    def helper(self, coins, amount, idx):
        if amount == 0:
            return 1
        if amount < 0 or idx >= len(coins):
            return 0

        choose = self.helper(coins, amount - coins[idx], idx)
        noChoose = self.helper(coins, amount, idx + 1)

        return choose + noChoose


# // Time Complexity :O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope
class DPSolution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins:
            return 0
        dp = [[0] * (amount + 1) for i in range(len(coins) + 1)]

        dp[0][0] = 1
        # print(dp)
        for i in range(1, len(coins) + 1):
            for j in range((amount + 1)):
                if coins[i - 1] > j:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
        # print(dp)
        return dp[-1][-1]


