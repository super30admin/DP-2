#Executed on leet code

class Solution:

# recursion
    def change(self, amount: int, coins: List[int]) -> int:
        if (len(coins)==0):
            return 0
        def helper(coins,amount, index):
            if amount==0:
                return 1
            if (amount<0 or index==len(coins)):
                return 0
            
            # case 1 if we are not choosing the coin
            case1 = helper(coins,amount, index+1)
              
            # case 2 if we are choosing the coin
            case2 = helper(coins,amount-coins[index], index)
            
            return case1+case2
            
        return helper(coins,amount, 0)

# DP
# TC o(m*n)
# SC: o(m*n)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if len(coins)==0:
            return 0
        m = len(coins)
        n = amount
        i = 0
        dp = [[0] * (n+1) for i in range(m+1)] 
        while i < (m+1) :
            dp[i][0] = 1
            i+=1 
        for i in range(1,m+1):
            for j in range(1,n+1):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[m][n]
        