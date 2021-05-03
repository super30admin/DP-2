# TC: O(M x N) where M is the amount and N is the total coin denominations present in input array. 
# SC: O(M x N) for the DP matrix to store all the values calculated for respective amount and that particular coin/coins. 

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins:
            return -1
        
        rows = len(coins) + 1
        cols = amount + 1
        dp = [[0 for i in range(cols)] for i in range(rows)]
        
        for i in range(rows):
            dp[i][0] = 1
            
        for i in range(1,rows):
            for j in range(1,cols):
#                 case where the amount to be calculated is smaller than the denomination
                if j < coins[i-1]:    
                    dp[i][j] = dp[i-1][j]
                else:
#                     to get total no. of ways for a particular combination, add up the ways from upper row of same column and same row before the denomination* steps.
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]]
    
        return dp[-1][-1]
