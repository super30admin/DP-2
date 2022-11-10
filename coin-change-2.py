#TC: O(n*amount)
#SC: O(n*amount)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n=len(coins)
        dp = [[0]*(amount+1) for _ in range(n+1)]

        for i in range(n,-1,-1):
            for target in range(amount+1):
                if target==0:
                    dp[i][target]=1
                elif i!=n:
                    dp[i][target] = dp[i+1][target]
                    if target-coins[i]>=0:
                        dp[i][target]+=dp[i][target-coins[i]]

        return dp[0][amount]