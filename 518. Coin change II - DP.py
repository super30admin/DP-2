# Time and Space Complexity = O(len(coins)*amount)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # Create a matrix 'dp' to store the solutions to subproblems
        dp = [ [0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        
        # Initialize the base case: when the target amount is 0, there's one way to make change (using no coins)
        for i in range(len(coins)+1):
            dp[i][0] = 1
        
        # Loop through the matrix and fill it using dynamic programming
        for row in range(1, len(coins)+1):
            for column in range(1, amount+1):
                # If the denomination is greater than the target amount, use the value from the row above
                if coins[row-1] > column:
                    dp[row][column] = dp[row-1][column]
                else:
                    # Use the value from the row above (without using the current coin) 
                    # plus the value from the same row but reduced amount (using the current coin)
                    dp[row][column] = dp[row][column-coins[row-1]] + dp[row-1][column]
        
        # Print the dp matrix (for debugging purposes)
        print(dp)
        
        # Return the solution for the entire problem
        return dp[len(coins)][amount]
