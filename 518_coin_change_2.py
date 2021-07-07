from typing import List


class Solution:
    """
        // Time Complexity : O(mn)
                'm' is the range of amount
                'n' is the number of coins in the list
        // Space Complexity : O(mn)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this :
                Took time to come up with the logic
        // Your code here along with comments explaining your approach
                In the recursion tree, I was able to see that we are
                repeating the sub problems. At each point we make a decision
                to choose or not choose a coin and add the number of ways we
                can select that coin with and without chosing it.
    """

    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[None for col in range(amount + 1)] for rows in range(len(coins) + 1)]
        # Base cases
        # No coin
        for amount in range(len(dp[0])):
            dp[0][amount] = 0
        # No amount
        for coin in range(len(dp)):
            dp[coin][0] = 1

        for coin_idx, coin in enumerate(coins, 1):
            for amount in range(1, amount + 1):
                if coin > amount:
                    dp[coin_idx][amount] = dp[coin_idx - 1][amount]
                else:
                    # no of ways by choosing the current coin +
                    # no of ways by not choosing the current coin
                    dp[coin_idx][amount] = dp[coin_idx][amount - coin] + dp[coin_idx - 1][amount]
        return dp[-1][-1]

    def change_brute_force(self, amount: int, coins: List[int]) -> int:
        if not coins:
            return 0
        return self.helper(coins, amount, 0)

    def helper(self, coins: List[int], amount: int, index: int):
        # base case
        if index >= len(coins) or amount < 0:
            return 0
        if amount == 0:
            return 1
        # Logic
        # Case 1
        # Choose a coin
        case_1 = self.helper(coins, amount - coins[index], index)

        # Case 2
        # Don't choose a coin
        case_2 = self.helper(coins, amount, index + 1)
        return case_1 + case_2


if __name__ == '__main__':
    h = Solution()
    print(h.change_brute_force(5, [1, 2, 5]))
    print(h.change_brute_force(10, [10]))
    print(h.change_brute_force(3, [2]))
    # print(h.change_brute_force(500, [3, 5, 7, 8, 9, 10, 11]))
    print(h.change(5, [1, 2, 5]))
