
// Time Complexity : O(mn) m -> len(amount+1) n -> len(coins)
// Space Complexity : O(mn) m -> len(amount+1) n -> len(coins) can be cut down to O(1) by just using variables instead of matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach




class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [None]*(amount+1)
        dp = [dp]*(len(coins)+1)
        # column 1 with zeroes
        for i in range(len(dp)):
            dp[i][0] = 0
        # row 1 with zeroes
        for j in range(len(dp[0])):
            dp[0][j] = 0
        dp[0][0] = 1
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                #  If coin denomination is greater than amount value
                if (coins[i-1]>j):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]
        return dp[len(dp)-1][len(dp[0])-1]
