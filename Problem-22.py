#leetcode-518 (coin change 2)
#time complexity =O(2^N)
#Approach DP = We need create a matrix of size (coins+1)*(amount+1). till the column is less than coins denomination we take it from previous row else we add the previous row value and the [column-coins denomination].

#when the amount is 0 we take the number of non occurences combination and we give 1.




#Recursive approach

class Solution(object):
    def change(self,amount, coins):
        
        return self.helper(amount,coins,0)
        
        
    def helper(self,amount,coins,i):
            
        #base case
            
        if (amount==0):
            return 1
        if (amount<0 or i>=len(coins)):
            return 0
            
        #choosing the coin
            
        case1=self.helper(amount-coins[i],coins,i)
            
            #not choosing the coin
        case2=self.helper(amount,coins,i+1)
            
        return case1 +case2
    
    
# dynamic programming 

class Solution(object):
    def change(self,amount, coins):
        c=amount+1
        r=len(coins)+1
        dp=[[0 for _ in range(c)] for _ in range(r)]
        m=len(dp)
        n=len(dp[0])
        dp[0][0]=1
        
        
        for i in range(1,m):
            dp[i][0]=1
            for j in range(1,n):
                dp[0][j]=0
                if (j<coins[i-1]): # the length of dp array is less than coins array
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[m-1][n-1]


            