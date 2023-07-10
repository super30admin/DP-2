#Time Complexity: O(n^2)
#Space Complexity : O(n^2)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[0 for i in range (0,amount+1)] for _ in range(len(coins)+1)]
        for j in range(1,amount+1):
            #Considered as infinity as it cannot be greater than amount
            dp[0][j] = amount+1 

        dp[1][0]=0
        for i in range(1,len(coins)+1):
            for j in range(1, amount+1):
                # if coins[i-1]=2 is greater than j=1 then copy from prev row
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                # min of prev row and 1 plus coin index previous to j
                    dp[i][j]= min(dp[i-1][j], (1+dp[i][j-coins[i-1]]))

        if dp[-1][-1] >= amount+1:
            return -1
        else:
            return dp[-1][-1]        