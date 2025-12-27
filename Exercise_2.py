'''
518 Coin Change 2
https://leetcode.com/problems/coin-change-ii/description/

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

Example 1:
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:
Input: amount = 10, coins = [10]
Output: 1

1. Brute Force (Recursion): Starting from the target sum, for each coin coins[i], we can either include it or exclude it. If we include it, we subtract its value from sum and recursively try to make the remaining amount with the same coin denominations. If we exclude it, we move to the next coin in the list.
Wr return 1 only if the remaining amount reaches 0 (meaning perfect sequence of coins to make up thw target sum). Thus, at each step, we have 2 choices - to select a coin or not. At the max, we take N such steps.
Time: O(2^N), Space: O(N)

2. Recursion with memoization (top-down approach):  Keep track of overlapping sub-problem using a hash map. The key of the hash map is the remaining sum to be computed and the value is the no. ways to reach the remaining sum. If we encounter it again, we just use the hash map instead of repeating the computation.
Time: O(N), Space: O(N)

3. Tabulation (bottom-up approach):
Construct a 2-D DP array of size (N+1) x (K+1), where K is the target amount.
dp[i][j] = number of ways required to reach the target amount j using coins[0],...,coins[i-1]
Note: In the dp matrix, row i=0 correspond to a dummy coin of denomination 0. Hence, row i=1, correspond to coins[0]. Thus dp[1][4] correspond to the no. of ways to reach target amount 4 using only coins[0]
Next, row i=2 correspond to coins[1]. dp[2][4] correspond to the no. of ways to reach target amount 4 using only coins[0] and coins[1].
In general, row i corresponds to coins[0],...,coins[i-1]

Initialize: Fill the DP array with 0 and then fill the first column with 1

For the remaining rows and colums, use:
    case_0 = dp[i-1][j]
    case_1 = dp[i][j - coins[i-1]]
    dp[i][j] = case_0 + case_1

Finally, return dp[N][K]

https://www.youtube.com/watch?v=idtGVUZdg28
Time: O(NK), Space: O(NK)
'''
import time

def coin_change2(coins, amount):
    def recurse(coins, amount, index):
        # base (no more coins or negative amount)
        if index > N-1 or amount < 0:
            return 0

        if amount == 0:
            return 1

        # 0-case (don't pick)
        case_0 = recurse(coins, amount, index+1)

        # 1-case (pick)
        case_1 = recurse(coins, amount-coins[index], index)

        return case_0 + case_1

    N = len(coins)
    if N == 0 or amount == 0:
        return 0

    return recurse(coins, amount, 0)

def coin_change2_DP(coins, amount):
    N = len(coins)
    if N == 0 or amount <= 0:
        return 0

    dp = [[0]*(amount + 1) for _ in range(N+1)]
    # fill first col with 1's
    for i in range(N+1):
        dp[i][0] = 1

    for i in range(1,N+1):
        for j in range(1,amount+1):
            if j < coins[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

    return dp[N][amount]


def run_coin_change2():
    tests = [([1,2,5], 5, 4),  ([2], 3, 0), ([10], 10, 1), ([2,5,3,6], 10, 5)]
    for test in tests:
        coins, amount, ans = test[0], test[1], test[2]
        start = time.time()*1000
        num_coins = coin_change2(coins, amount)
        elapsed =  time.time()*1000 - start
        print(f"\ncoins = {coins}")
        print(f"Min number of coins to reach target {amount} = {num_coins}, time = {elapsed:.2f} ms (recursion)")
        print(f"Pass: {ans == num_coins}")

    for test in tests:
        coins, amount, ans = test[0], test[1], test[2]
        start = time.time()*1000
        num_coins = coin_change2_DP(coins, amount)
        elapsed =  time.time()*1000 - start
        print(f"\ncoins = {coins}")
        print(f"Min number of coins to reach target {amount} = {num_coins}, time = {elapsed:.2f} ms (DP)")
        print(f"Pass: {ans == num_coins}")


run_coin_change2()
