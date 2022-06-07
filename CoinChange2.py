class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        
        '''// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach'''
        
        #Edge case
        if len(coins)==0:
            return 0
        
        n=len(coins)
        m=amount
        
        dp=[[0]*(m+1)]*(n+1)
        #Dummy row
        dp[0][0]=1
        
        for i in range(1,len(dp)):
            for j in range(len(dp[0])):
                #If the denomination of the coin is greater than the target
                if coins[i-1] > j:
                    dp[i][j]=dp[i-1][j]
                #else add the previous 0 case with the current 
                else:
                    dp[i][j]= dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[n][m]
            
        
        
        
