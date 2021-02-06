// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Make use of dp to find number of ways to make a given amount.



class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        
        dp=[[0 for i in range(amount+1)] for j in range(len(coins)+1)]
        
        for i in range(len(dp)):
            dp[i][0]=1
        
        for i in range(1,len(dp[0])):
            
            dp[0][i]=0
        
        
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if(coins[i-1]> j):
                    dp[i][j]= dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return(dp[len(dp)-1][len(dp[0])-1])
        