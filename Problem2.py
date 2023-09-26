'''
1. Number of coins are rows and amount is columns. Initialize the dp array with 0s.
2. If the amount is less than the coin value, copy the value from the above row as it cannot be used. 
3. If the amount is greater than the coin value, then it is = the number of ways to get the amount without the current coin + number of ways to compute the remaining amount with all coins including current.
4. Return the last element of the dp array which is the number of ways to compute the amount with all the coins.
TC: O(m*n) SC: O(m*n) where m is the number of coins and n is the amount
'''

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        if coins == None or len(coins) == 0:
            return 0
        
        # Rows of dp array are number of coins + 1 so storing num of coins
        m = len(coins)
        # Columns in dp array
        n = amount

        # Initialize the dp array with zeros matrix of size m+1 x n+1
        dp =[[0] * (n+1) ] * (m+1)

        dp[0][0] = 1
        # Make the first row as amount+1 (works like inf) 
        for j in range(1,n+1):
            dp[0][j] = 0
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]]
                
        return dp[m][n]

        