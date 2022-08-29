#tc: O(amount*coins)
#sc: O(amount*coins)

class Solution:
    def change(self, amount, coins) -> int:
        dp = [[0]*(amount+1) for i in range(len(coins)+1)]
        dp[0][0] = 1
        for i in range(1,len(dp)):
            for j in range(len(dp[0])):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        return dp[len(dp)-1][len(dp[0])-1]

obj = Solution()
print(obj.change(5,[1,2,5]))