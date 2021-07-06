"""
// Time Complexity : o(m*n)
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

class Solution(object):
    """ 
    def helper(self, coins, ind, amount): #FOR BRUTE FORCE
        #base
        
        if amount == 0: #if amount == 0, we return 1 as a valid path has been found
            return 1
        if ind>=len(coins) or amount<0: #invalid path, so return 0
            return 0
        #logic
        
        case0 = self.helper(coins, ind+1,amount) #when we are considering that denomination, we increase the index to next one
        
        case1 = self.helper(coins, ind, amount - coins[ind]) #when we are considerinf that denomination, we decrease the amount by that value
           
        return case1+case0 #we will get the count of all valid paths
        """
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        
        """
        BRUTE FORCE CALL
        return self.helper(coins, 0, amount)
        """
        """
        DP SOLUTION
        """
        row = len(coins)+1 #number of rows in DP matrix
        col = amount+1 #number of columns in DP matrix
        
        dp = [[0 for i in range(col)] for j in range(row)] #DP matrix
        
        for i in range(row): #setting first col = 1
            dp[i][0] = 1
        
        for i in range(1,row):
            for j in range(col):
                if j<coins[i-1]: #if amount is less than denomination, take the previous value
                    dp[i][j] = dp[i-1][j]
                    
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]] #else add count from previous row and the count present at position: current - denomination value
                
                
        
        return dp[len(coins)][amount] #return the last value
        
        
        