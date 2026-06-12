## Problem2 (https://leetcode.com/problems/coin-change-2/)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # def findNumWays(amount: int, coins: List[int], index: int):
        #     # base case
        #     if amount < 0 or index >= len(coins):
        #         return 0
            
        #     if amount == 0:
        #         return 1
            
        #     # case 0 = don't choose the current coin
        #     case0 = findNumWays(amount, coins, index + 1)
        #     # case 1 = choose the current coin
        #     case1 = findNumWays(amount - coins[index], coins, index)

        #     return case0 + case1

        # return findNumWays(amount, coins, 0)



        """
        Algorithm: Dynamic Programming (Bottom-Up 1D Tabulation)
        We use a 1D array `dp` where the index `i` represents the target amount, 
        and the value at `dp[i]` represents the number of combinations that make up that amount.
        
        Time Complexity: O(C * A)
        Where C is the number of available `coins` and A is the target `amount`.
        The outer loop runs C times, and the inner loop runs A + 1 times.
        
        Space Complexity: O(A)
        Where A is the target `amount`. We only need a 1D array of size A + 1 to store the results.
        """
        
        # Initialize a DP array of size (amount + 1) with 0s.
        # dp[i] will store the total number of ways to make the amount i.
        dp = [0 for _ in range(amount + 1)]
        
        # Base case: There is exactly 1 way to make the amount 0 
        # (by choosing to use no coins at all).
        dp[0] = 1
        
        # Iterate through each coin denomination one by one.
        # Iterating coins in the outer loop ensures we count combinations, 
        # not permutations (e.g., 1+2 and 2+1 are considered the same combination).
        for c in coins:
            # For the current coin 'c', update the number of ways to make every amount 'i'
            for i in range(amount + 1):
                if i < c:
                    # If the current amount 'i' is less than the coin's value,
                    # we can't use this coin. The number of ways stays the same.
                    continue
                else:
                    # If we CAN use the coin, the total ways to make amount 'i' is the sum of:
                    # 1. The ways to make amount 'i' WITHOUT this coin (current dp[i])
                    # 2. The ways to make the remaining amount 'i - c' WITH this coin (dp[i - c])
                    dp[i] += dp[i - c]
                    
        # The last element holds the total number of ways to make the requested target amount.
        return dp[-1]