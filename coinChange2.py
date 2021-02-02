#TimeComplexity:O(MN) 
#SpaceComplexity: Space for DP 2D array 
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if amount==0:
            return 1
        if len(coins)==0:
            return 0        
        i=len(coins)+1 #rows
        j=amount+1     #columns
        dp=[[0]*j for _ in range(i)]
        for m in range(j):
            dp[0][m]=0
        for n in range(i):
            dp[n][0]=1
        for m in range(1,i): #rows
            for n in range(1,j): #cols
                if coins[m-1]>n:
                    dp[m][n]=dp[m-1][n]
                else:
                    dp[m][n]=dp[m-1][n]+dp[m][n-coins[m-1]]
        return dp[-1][-1]
