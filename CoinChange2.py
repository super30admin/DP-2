# #Recursive:Exponential
# #TC: O(2^n)
# #SC: O(1)
# In this approach, we consider two cases at each step:
# 	1.	Exclude the current coin – We move to the next index without using the current coin.
# 	2.	Include the current coin – We stay at the same index (since we can reuse the coin) and subtract its value from the remaining amount.
# By adding the results of both cases, we get the total number of possible ways to form the target amount using the available coins.
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         return self.comb(amount, 0, coins)

#     def comb(self, amount, index, coins):
#         # Base Case: If amount is negative, no valid combination
#         if amount < 0:
#             return 0
#         # Base Case: If exact amount is formed, count this as 1 way
#         if amount == 0:
#             return 1
#         # Base Case: No coins left to use
#         if index >= len(coins):
#             return 0
#         # Recursive Case:
#         # Option 1: Skip the current coin (move to next index)
#         # Option 2: Include the current coin (stay on the same index)
#         count = self.comb(amount, index + 1, coins) + self.comb(amount - coins[index], index, coins)
#         return count


# #Approach-2: DP
# #TC & SC: O(n × amount)
# #top-down dynamic programming with memoization (optimized recursion), which significantly improves performance over the plain recursive approach. Storing the already calculated values somewhere and reusing them.
# class Solution:
#     def change(self, amount, coins):
#         # Edge cases
#         if amount == 0:
#             return 1
#         if not coins:
#             return 0
#         # Initialize memoization table with -1 (means "not computed yet")
#         counts = [[-1 for _ in range(amount + 1)] for _ in range(len(coins))]
#         # Start recursion from index 0 and full amount
#         return self.comb(amount, 0, coins, counts)
#
#     def comb(self, amount, index, coins, counts):
#         # If amount becomes negative, this is not a valid combination
#         if amount < 0:
#             return 0
#         # If exact amount is formed, count this as one valid combination
#         if amount == 0:
#             return 1
#         # If this subproblem was already computed, return cached result
#         if counts[index][amount] != -1:
#             return counts[index][amount]
#         res = 0
#         # Try each coin starting from current index to avoid duplicate permutations
#         for i in range(index, len(coins)):
#             # Recurse with reduced amount and same coin index (can use unlimited times)
#             res += self.comb(amount - coins[i], i, coins, counts)
#         # Store result in memo table
#         counts[index][amount] = res
#         return res


#Approach-3: Bottom-up DP
#Time complexity: O(n × amount)
#Space complexity: O(amount)
# We start knowing there’s exactly one way to make zero — by not picking any coins. Then, for each coin, we see how many new ways it helps create to reach different amounts. By the end, we count all the possible combinations to make the total amount using the coins.
class Solution:
    def change(self, amount, coins):
        # dp[i] will store the number of combinations to make amount i
        dp = [0] * (amount + 1)       
        # Base case: There is 1 way to make amount 0 — by choosing no coins
        dp[0] = 1
        # Loop through each coin
        for coin in coins:
            # Update dp table for all amounts >= current coin
            for i in range(coin, amount + 1):
                # Add combinations by including current coin
                dp[i] += dp[i - coin]
        # Final answer: total ways to make 'amount'
        return dp[amount]