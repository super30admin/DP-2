# Time Complexity : For last method - O(m*n), where m is the length of the coins array, where n is the target amount
# Space Complexity : For last method - O(n), where n is the target amount
# Did this code successfully run on Leetcode : Yes

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
    # Method 1 - Recursion - TLE

    #     if len(coins)==0: return 0

    #     return self.helper(amount,coins,0)
    

    # def helper(self,amount,coins,i):
    #     #base
    #     if amount==0: return 1
    #     if amount<0 or i==len(coins): return 0


    #     #logic
    #     case0=self.helper(amount,coins,i+1)
    #     case1=self.helper(amount-coins[i],coins,i)
    #     return case0+case1


    #Method 2 - DP with 2D space

        # if len(coins)==0:
        #     return 0

        # dp=[[0 for _ in range(0,amount+1)] for _ in range(0,len(coins)+1)]
        # for i in range(len(coins)+1):
        #     dp[i][0]=1
        # for i in range(1,len(coins)+1):
        #     for j in range(1,amount+1):
        #         if j<coins[i-1]:        #amount is less than denomination case
        #             dp[i][j]=dp[i-1][j]
        #         else:
        #             dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]] #0-case + 1-case
        # return dp[-1][-1]

    #Method 2 - DP with 1D space

        if len(coins)==0:
            return 0

        dp=[0 for _ in range(0,amount+1)]
        dp[0]=1
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j<coins[i-1]:        #amount is less than denomination case
                    dp[j]=dp[j]
                else:
                    dp[j]=dp[j]+dp[j-coins[i-1]]
        return dp[-1]


    