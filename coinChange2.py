# Time Complexity : O(n) where n is the length of the string
# Space Complexity : O(n) where n is the length of the string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# We will use a tabular dp approach to solve this problem.
# 1. We will create a 2D array dp where dp[i][j] represents the number of ways to make the amount j using the first i coins.
# 2. We will initialize the first column of the dp array to 1 because there is only one way to make the amount 0 using any number of coins.
# 3. We will initialize the first row of the dp array to 0 because there is no way to make the amount j using 0 coins.
# 4. We will fill the dp array based on the following conditions:
#     a. If the amount is less than the coin value, we take the value from the previous row.
#     b. If the amount is greater than or equal to the coin value, we take the sum of the value from the previous row and the value at the same row and the column - coin value.

from typing import List
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # Initialize the 2D array with rows as the number of coins and columns as the amount
        row, col = len(coins)+1, amount+1
        # fill the dp array with 0
        dp = [[0 for _ in range(col)] for _ in range(row)]
        # initialize the first column with 1
        for i in range(1, row):
            dp[i][0] = 1
        for i in range(1, row):
            for j in range(1, col):
                # If the amount is less than the coin value, take the value from the previous row
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                # If the amount is greater than or equal to the coin value, take the sum of the value from the previous row and the value at the same row and the column - coin value
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        # return the value at the last row and last column
        return dp[row-1][col-1]

# Approach: Space optimized DP
# Using a 1D array to store the values of the dp array, instead of a 2D array. 
# Space Complexity : O(m) where m is the amount  
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        row, col = len(coins)+1, amount+1
        dp = [0 for _ in range(col)]
        dp[0] = 1

        for i in range(1, row):
            for j in range(1, col):
                if j >= coins[i-1]:
                    dp[j] = dp[j] + dp[j - coins[i-1]]
        return dp[col-1]


# Approach: Recursive approach or exhaustive search
# Time Complexity: O(2^(n+m)) where n is the number of coins and m is the amount
# Space Complexity: O(n+m) where n is the number of coins and m is the amount

# 1. We recursively select the coins and check if the amount can be generated.
# 2. We have two choices at each step:
#     a. Choose the coin: We decrement the amount by the coin value and increment the count.
#     b. Do not choose the coin: We move to the next coin.
# 3. We return the total of the two choices.
# 4. If the amount is less than 0 or we have exhausted all the coins, we return 0, to signify that the amount cannot be generated.
# 5. If the amount is 0, we return 1, to signify that the amount can be generated.

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # coding up the recursive approach
        def helper(i, amount):
            # base case
            if amount == 0:
                return 1
            if i == len(coins) or amount < 0:
                return 0
            #       do not choose.       choose
            return helper(i+1, amount) + helper(i, amount-coins[i])

        return helper(0, amount)