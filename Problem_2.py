'''
Time Complexity - O(n*m) for both the approaches where n is the number of denominations and m is the amount
Space Complexity - O(n*m) for the tabulation approach and O(m) for the optimized approach

Both the approaches work on Leetcode
'''
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        #This is a tabulation approach
        dp = [[0 for j in range(amount+1)]for i in range(n+1)] #Create the dp array (n+1)*(m+1)
        dp[0][0] = 1 # denomination 0 and target 0
        for j in range(1, amount+1):
            dp[0][j] = 0 #denomination 0 and targets 1 to 11 no way to reach target 
        for i in range(1,len(coins)+1):  #Iteration of a 2D array
            for j in range(amount+1):
                if j < coins[i-1]: #copy the values from the row above until the target value is same as the denomination value
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]] #else min of value in the above row for same column and same row - the denomination value
        return dp[len(coins)][amount] if dp[len(coins)][amount] > 0 else 0 #return the value in the last column of the last row.

        #optimized solution
        prev = [0 for j in range(amount+1)] #initialize a 1D Array
        prev[0] = 1 #denomination 0 and target 0, 1 way
        for i in range(1, len(coins)+1):
            curr = [0 for k in range(amount+1)]
            for j in range(amount+1):
                if j < coins[i-1]:
                    curr[j] = prev[j] #copy the values from the row above until the target value is same as the denomination value
                else:
                    curr[j] = prev[j] + curr[j - coins[i-1]] #else min of value in the above row for same column and same row - the denomination value
            prev = curr #current row becomes the row above for the next iteration.
        return prev[amount] if prev[amount] > 0 else 0