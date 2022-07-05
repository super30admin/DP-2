"""
Runtime Complexity: O(m*n) - Because we have 'm' rows of coins and 'n' columns of amount.
Space Complexity: O(m*n) - because we created 2D dp array to compute our solution.
Yes, the code worked on leetcode.
The idea behind the algorithm is to create a dp array which computes the total number of combinations. There are two cases, 
0 and 1 case which is called choose not choose. If there is no one case available to us then we just update the amount of combinations from the above cell else we add both case 0 and case 1.
"""


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if len(coins)==0:
            return 0
        m = len(coins)
        n = amount
        dp = ([[0 for i in range (n+1)] for i in range(m+1)])
        print(dp)
        
        for i in range(m+1):
            for j in range(n+1):
                if i == 0:
                    dp[i][j] = 0
                if j == 0:
                    dp[i][j] = 1
        for i in range(1,m+1):
            for j in range(1,n+1):
                if j < coins[i-1] :
                    dp[i][j] = dp[i-1][j]
                    
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[m][n]
    
                
                    