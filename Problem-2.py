"""
## Problem2 (https://leetcode.com/problems/coin-change-2/)
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Example 1:

Input: amount = 5, coins = [1, 2, 5]
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
Note:

You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

"""
def Coin_change(amount, coins):
    dp =[[0]*(amount+1) for i in range(len(coins)+1)]  # create a dp matrix with all 0s

    # move 1 to  first col as if we have only 1 way to make the amount 0 regardless of coin value
    for i in range(len(dp)):
        dp[i][0]=1

    # if coin value is greater than the amount then copy the cell value in dp from above row means i-1
    # else dp[i-1][j] is number of ways if we not choose the current coin
    # dp[i][j-coins[i-1]] is number of ways if we choose the current coin
    for i in range(1,len(dp)):
        for j in range(1,len(dp[0])):
            if coins[i-1] > j:
                dp[i][j]=dp[i-1][j]
            else:
                dp[i][j]=dp[i-1][j] + dp[i][j-coins[i-1]]

    return dp[-1][-1]

print(Coin_change(amount=5, coins = [1, 2, 5]))





