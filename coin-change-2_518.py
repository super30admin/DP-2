#TimeComplexity: O(MN) 
#SpaceComplexity: O(N) DP array 
#It successfully runs on leetcode


#Optimized with single array O(N) Space
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp=[0 for i in range(amount+1)]
        dp[0]=1
        for i in range(1,len(coins)+1):
            for j in range(1, amount+1):
                if j>=coins[i-1]:
                    dp[j]= dp[j]+dp[j-coins[i-1]]
        return dp[-1]

#Using DP using 2D-matrix space(MN)    
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp=[[0 for i in range(amount+1)] for j in range(len(coins)+1)]
        dp[0][0]=1

        for i in range(1,len(dp)):
            dp[i][0]=1
            for j in range(1, len(dp[0])):
                if j<coins[i-1]:
                    dp[i][j]= dp[i-1][j]
                else:
                    dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[-1][-1]
    