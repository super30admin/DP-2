
# RECURSIVE SOLUTION

# Time Complexity: O( Amount^n )
# Space Complexity: No additional space except the space for Recursive stack
# Did problem run on Leetcode: yes, with TLE

class Solution:
    def coinChange2(self, amount, coins):
        return self.helper(amount, coins, 0)

    def helper(self, amount, coins, index):

        # BASE CASE
        if amount == 0:
            return 1
        if amount < 0 or index > len(coins)-1:
            return 0

        #LOGIC
        # Not-Choose the coin,
        case1 = self.helper(amount, coins, index+1)
        # Choose the coin,
        case2 = self.helper(amount-coins[index], coins, index)

        return case1 + case2

obj = Solution()
print(obj.coinChange2(amount=5, coins=[1, 2, 5]))