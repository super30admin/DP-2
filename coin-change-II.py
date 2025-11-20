# Time Complexity : O(n^2)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : yes was able to solve the question
# Any problem you faced while coding this : No

class Solution:

    def change(self, amount, coins):
        n = len(coins)
        m = amount

        dp = [0 for each in range(1 + m)]
        dp[0] = 1

        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if coins[i - 1] <= j:
                    dp[j] = dp[j] + dp[j - coins[i - 1]]
        
        return dp[m]


s = Solution()
amount = 5
coins = [1,2,5]
print(s.change(amount, coins))
amount = 3
coins = [2]
print(s.change(amount, coins))
amount = 10
coins = [10]
print(s.change(amount, coins))