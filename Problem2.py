"""
TC: O(N*M) {where N is len of coins and M is the amount value (0-amount)}
SC: O(M) {we optimized the space by only using a 1D array}

Approach:

We initialize a 1D array with all zeros except the 0th idx as 1, cuz we know there are 1 way to make amount 0 ie not choosing any coins.

Then we iterate through all the coins from the list of coins and update the possible combination by adding the prev denomination coin number 
and the same denomination number of ways.
At the end we have the final possible count of ways.

This problem successfull ran on Leetcode.
"""


from typing import List
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n,m = len(coins), amount

        dp = [0]*(m+1)
        dp[0] = 1
        
        for coin in coins:
            for j in range(coin, m+1):
                dp[j] = dp[j]+dp[j-coin]
        
        return dp[-1]