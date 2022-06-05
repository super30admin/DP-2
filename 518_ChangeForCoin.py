# time complexity: O(mn)
# space complexity: O(mn)
# m = number of coins
# n = total amount
class Solution:
    def change(self, amount, coins) -> int:
        m = len(coins)
        n = amount
        dp = [[0 for i in range(n + 1)] for j in range(m + 1)]
        if coins == None or len(coins) == 0:
            return 0;
        dp[0][0] = 1 
        for i in range(1, len(dp)):
            for j in range(0, len(dp[0])):
                if(j<coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        
        return dp[m][n]

obj = Solution()
print(obj.change(10, [2, 5, 3, 6]))