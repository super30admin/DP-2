#time complexity: o(n*m) n is num of coins and m is amount
#space complexity: o(n*m)
#passed all cases on LeetCode: yes
#difficulty faced:none
# comments:in the code
#https://leetcode.com/problems/coin-change-2/

class Solution:
    def change(self, amount: int, coins: 'List[int]') -> int:
        
        rows, cols = len(coins)+1, amount+1
        dp = [[0 for j in range(cols)]for i in range(rows)]
        
        
        
        #0 case or index is added so that formula doesn't change
        #in this we make a matrix of how many ways can we make an amount using coins in the rows
        #for the 1st col we save 1 bec we can make an amount of 0 only 1 way that is by not choosing any coins
        #we choose a 2d matrix bec there are 2 deciding factors - coins and num of ways. 
        
        for i in range(1,rows):
            dp[i][0] = 1
            
        
        for i in range(1,rows):
            for j in range(1,cols):
                
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
                    
                    
        return dp[len(coins)][amount]