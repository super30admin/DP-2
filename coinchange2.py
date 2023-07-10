#TC - O(n)
#SC - O(n)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
      
        dp = [[-1 for j in range(amount+1)] for i in range(len(coins))]
        def f(i,am):
            if i == 0:
                if am%coins[i]==0:
                    return 1
                else:
                    return 0
            if dp[i][am]!=-1:
                return dp[i][am]
            nottake = f(i-1,am)
            take = 0
            if coins[i]<=am:
                take = f(i,am-coins[i])
            dp[i][am] = take+nottake
            return dp[i][am]
        return f(len(coins)-1,amount)