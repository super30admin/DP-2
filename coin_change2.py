"""
Approach1:
Recursive solution, using exhaustive approach. For each call, we decide if we select the coin[indx] or not,
if we do, add 1 to count and subtract value from the amount. If we select the coin, index stays the same, and
else index+1

TC: Exponential
SC: Stack space
Gives Time Limit Exceeded on Leetcode as expected.
"""
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        return self.helper(coins, amount, 0)
    
    def helper(self, coins: List[int], amount: int, index:int) -> int:
        
        # base case
        if amount == 0: # meaning there is at least 1 way we can make the given amount from given coins
            return 1
        if index >= len(coins) or amount < 0:
            return 0
        
        # logic
        # choose
        case1 = self.helper(coins, amount - coins[index], index) 
        # No choose
        case2 = self.helper(coins, amount, index + 1)
        # return total number of ways you can form given amount
        return case1 + case2



"""Approach2:
Build a table - tabulization - bottom up DP

Rows would be range(0, coins) and columns (0,target)

0th row all 0s except at [0][0] it is 1
0th column is all 1s meaning to make 0 amount with denomination, there is 1 way and that is to NOT choose the coin
and then youare left with 0

Loop i and j over rows and columns from index 1 and build the table
For each dp[i][j] value would be dp[i-1][j] + dp[i][j - coins[i-1]]




e.g. table for [1,2,5], target=11
      0      1      2      3      4      5      6      7      8      9     10     11
0     1      0      0      0      0      0      0      0      0      0      0      0
5     1      0      0      0      0      1      0      0      0      0      1      0
1     1      1      1      1      1      2      2      2      2      2      3      3
2     1      1      2      2      3      4      5      6      7      8      10     11

TC: O(n^2) time for 2 loops that are nested 
where really it is O(N*amount) N is number of coins in coins array and amount is our target amount
SC: O(m*n) space
"""

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m, n = len(coins)+1, amount+1
        # initialize first row for column 0 through 11 (total 12) taking example from comment above
        dp = [[0]*n]
        # build rest of the matrix with 0s
        for i in range(1,m):
            dp.append([0]*n)
        # first index in all rows in the first col should be 1 as there are 1 ways to make 0 with any coin, that is not to choose that coin
        for i in range(m):
            dp[i][0] = 1
        
        for i in range(1,m):
            for j in range(1,n):
                # In the matrix we have 0, prefix for coins array, hence its len is 1 more than actual input coins 
                # array we have. Hence we have to take coins[i-1], else we will go index out of bound trying to access last element in coins array
                if j < coins[i-1]:  # j is less than denomination of the coin
                    # we use coins[i-1] because in our DP array we assume coins are [0,1,2,5] but in reality its only [1,2,5]
                    dp[i][j] = dp[i-1][j]           # to accommodate that, when we are on 1st index in dp table row, we should be looking at 0th index in coins array
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        
        print(dp)
        return dp[m-1][n-1] if dp[m-1][n-1] !=99999 else -1


