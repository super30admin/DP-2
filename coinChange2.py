#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
#Did it run on leetcode: yes

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins is None or len(coins) == 0:
            return 0
        m = len(coins)
        n = amount
        dp = [[[] for jindex in range(n+1)] for row in range(m+1)]
        for i in range(n+1):
            dp[0][i] = 0
        dp[0][0] = 1
        for index in range(1,m+1):
            for jindex in range(0, n+1):
                if (jindex < coins[index-1]):
                    dp[index][jindex] = dp[index-1][jindex]
                else:
                    dp[index][jindex] = dp[index-1][jindex] + dp[index][jindex-coins[index-1]]
        return dp[m][n]
        