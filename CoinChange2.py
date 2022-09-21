class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        if len(coins) == 0:
            return 0
        
        # Setting the rows and cols
        rows = len(coins)
        cols = amount
        
        # Setting the matrix and initializing it to 0
        dp = [[0 for _ in range(cols + 1)] for _ in range(rows + 1)]
        
        # As our first column is of 0 we need to make it 1 in the dp matrix because if we choose a 0 case of not choosing a coin then it is a combination(1)
        
        for i in range(1, rows + 1):
            dp[i][0] = 1
            
        # We will keep the first row 0 expect the 0th index which is 1. Because after 0 there are actual values and with 0 as a coin NO COMBINATION CAN BE FORMED
        
        # Itertating through the entire dp matrix
        
        for i in range(1, rows + 1):
            for j in range(1, cols + 1):
                
                # If the current amount is less than the current coin value then we directly copy the value that is above the current dp value
                # Can be understood properly from the matrix formed in book
                if j < coins[i - 1]:
                    dp[i][j] = dp[i-1][j]
                # If that is not the case then we want the total combinations and the total combinations will be the addition of the value above the current cell and the value on the left side of the current coins amount
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]]
        
        # result will be on the last cell because that will consider all the coins and the total amount
        return dp[rows][cols]
    
    # Time Complexity: O(m*n) where m and n are rows and cols respectively
    # Space Complexity: O(m*n) because a mtrix of the same size used
    # This is an approach using 2D dynamic programming