#TC O(n2)
#SC O(n)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp=[0]*(amount+1)
        dp[0]=1
        
        for c in coins:
            for i in range(0,amount+1):
                if i>=c:
                    dp[i]+=dp[i-c]
        return dp[-1]            