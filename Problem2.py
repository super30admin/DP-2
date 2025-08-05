#Time Complexity : O(m*n)
#Space Complexity : O(n)
#Any problem you faced while coding this : none

#Your code here along with comments explaining your approach
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        m=len(coins)
        n=amount
        #dp=[[0 for _ in range(0,n+1)]for _ in range(0,m+1)]
        dp=[0 for _ in range(0,n+1)]  # single row 
        #for i in range(0,m+1):
        #    dp[i][0]=1
        dp[0]=1  # number of ways to make amount 0 using 0 coins 
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                if coins[i-1]>j: # the denomination of coin is greater than the amount
                    dp[j]=dp[j]# no choose case, above row 
                else:
                    dp[j]=dp[j]+dp[j-coins[i-1]] # choose case- add both the values 
        
        return dp[n] # return the final value 

