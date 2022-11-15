#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
#Successfully ran on leetcode

class Solution:
    def change(self, amount: int, coins: list(int)) -> int:
        dp=[]
        for i in range(len(coins)+1):
            dp.append([])
        for i in range(len(coins)+1):
            dp[i].append(1)
        for i in range(1,amount+1):
            dp[0].append(0)
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j<coins[i-1]:
                    dp[i].append(dp[i-1][j])
                else:
                    dp[i].append(dp[i-1][j]+dp[i][j-coins[i-1]])
        return dp[len(coins)][amount]
