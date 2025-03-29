# Problem2 (https://leetcode.com/problems/coin-change-2/)

# FIRST THE BRUTE FORCE - RECURSIVE APPROACH
# Time Complexity
# O(2^(n+m)) where:
# n is the number of different coin denominations
# m is the target amount
# This is because for each coin, we make two recursive calls, 
# and the maximum depth of recursion can be n+m in the worst case 
# (if we have coins of very small denominations).

# Space Complexity
# O(n+m) for the recursion stack in the worst case. 
# The maximum depth of recursion determines the space complexity, 
# which depends on both the number of coins and the target amount.

# Approach
# This solution uses a recursive approach with backtracking to solve the coin change problem. 
# Specifically, it counts all possible combinations of coins that sum up to the target amount.
# For each coin, we have two choices:
#    - Don't use the coin and move to the next one
#    - Use the coin and stay at the same position (allowing for multiple uses of the same coin)
# The recursion terminates when either:
#    - We've reached the target amount (found a valid combination)
#    - We've gone over the target amount (invalid combination)
#    - We've considered all coins without reaching the target (invalid combination)

# On Leetcode this code gives Time limit exceeded

def change(self, amount, coins):
    # Initialize counter to track number of valid combinations
    self.count = 0
    # Start recursive helper function with initial position and full amount
    self.helper(coins, 0, amount)
    # Return the final count of combinations
    return self.count
    
def helper(self, coins, i, amount):
    # Base case 1: We've found a valid combination that sums to the target amount
    if amount == 0:
        # Increment our counter since we found a valid combination
        self.count += 1
        # Exit this branch of recursion
        return
    
    # Base case 2: Invalid combination (negative amount or no more coins to consider)
    if amount < 0 or i == len(coins):
        # Exit this branch of recursion without incrementing counter
        return
    
    # Option 1: Skip the current coin and move to the next one
    # (Don't include coins[i] in this combination)
    self.helper(coins, i + 1, amount)
    
    # Option 2: Use the current coin and stay at the same position
    # (Include coins[i] in this combination and possibly use it again)
    self.helper(coins, i, amount - coins[i])

#____________________________________________________________________________________

# THEN THE TABULATION METHOD

# TC: O(m * n) where m is the number of coins and n is the target amount.

# SP: O(m * n) for the 2D dp array.

# Approach:
# This implementation uses a bottom-up dynamic programming approach to solve the coin change problem, 
# specifically counting the number of ways to make a given amount using the available coins.

# On Leetcode could submit the code

def change(self, amount, coins):
        # Get the length of the coins array
        m = len(coins)
        # Store the target amount
        n = amount
        
        # Create a 2D DP array initialized with zeros
        dp = [[0 for i in range(n+1)] for i in range(m+1)]
        
        # Base case: there is 1 way to make amount 0 (by using no coins)
        dp[0][0] = 1
        
        # Fill the dp table
        for i in range(1, m+1):
            for j in range(0, n+1):
                if j < coins[i-1]:
                    # If current coin value is greater than current amount,
                    # just copy the value from the previous row
                    dp[i][j] = dp[i-1][j]
                else:
                    # Current value = ways without using current coin + ways using current coin
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        
        # Return the answer in the bottom-right cell
        return dp[m][n]

#________________________________________________________________________________________________

# THEN 1D ARRAY

# TC: O(m * n) where m is the number of coins and n is the target amount.

# SC: O(n) for the 1D dp array, which is an improvement over the 2D version.

# Approach:
# This code implements a space-optimized version of the coin change problem 
# using a 1D dynamic programming array. 
# It counts the number of ways to make a given amount using the available coins.

# On Leetcode could submit the code

def change(self, amount, coins):
    # Get the length of the coins array
    m = len(coins)
    # Store the target amount
    n = amount
    
    # Create a 1D DP array of size amount+1
    dp = [0] * (n+1)
    
    # Base case: there is 1 way to make amount 0
    dp[0] = 1
    
    # Fill the dp array
    for i in range(m): # For each coin
        for j in range(coins[i], n+1): # Start from coin value to avoid negative indices
            # Add the number of ways to make j-coins[i] using previous coin
            dp[j] += dp[j - coins[i]]
            
    
    # Return the answer at index amount
    return dp[n]
