# Leetcode problem link : https://leetcode.com/problems/coin-change-2/
# Time Complexity : O(n * m) where n is number of coins and m is amount
#  Space Complexity : O(n * m) where n is number of coins and m is amount
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Basic approach : O(2^n) => form a tree for each coin/index to choose or not choose the coin and index and explore all the options. It will be exponential as we are going through each subtree recursively with two options: choose the coin or not to choose the coin till we reach the amount so height of tree will be the amount

        Optimized approach: O( n * m) => Use a dp matrix such that dp[i][j] will show the minimum number of coins required to make amount j using coins 0 to i-1 from coins array.
        1. Declare a matrix of size input coins+1 * amount+1  (+1 required as we are storing for 0 )
        2. For 0th column value will be 0 for all the rows as the amount is zero so irrespective of the number of coins there are zero ways to make amount 0
        3. For 0th row for each column i.e. coins are 0 and irrespective of the amount to make it always infinite or max value
        4. Till the index when amount is less than the coin denomination, we have no other way but to use the number of ways when we didnt have this coin but previous coin denominations i.e dp[i-1][j]
        5. When the amount is greater than or equal to the coin denomination (and we decide to use the coin) then the remaining amount left is j (current amount) - coin used which is coins[i-1] using the same coins i.e. in the same row i.
        Now as we need to use the minimum number of coins, we take the minimum of the current number of coins and previous coins to make the current amount i.e. dp[i-1][j] and current
        6. We return the last value computed if its less than infinity else -1
        
'''
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        l = len(coins)
        dp = [[None for _ in range(amount+1)] for _ in range(l + 1)]
        
        for i in range(l+1):
            dp[i][0] = 1
        
        for j in range(1,amount+1):
            dp[0][j] = 0
        
        
        for i in range(1,l+1):
            for j in range(1,amount+1):
                
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        
        return dp[-1][-1]