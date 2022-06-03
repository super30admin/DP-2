# Time Complexity: O(n*k)
# Space Complexity: O(n*k)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins==None or len(coins)==0: return 0
        dp=[[0 for i in range(amount+1)] for j in range(len(coins)+1)]
        dp[0][0]=1
        for i in range(1,len(coins)+1):
            for j in range(amount+1):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[len(coins)][amount]