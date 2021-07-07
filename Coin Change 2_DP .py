
# DP SOLUTION

# Time Complexity: O(M*N), M: no.of.rows made, N: no.of. columns made
# Space Complexity: O(M*N) for dp matrix built
# Did problem run on Leetcode: yes

class Solution:
    def coinChange2(self, coins, amount):

        #creating a DP matrix,
        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]

        dp[0][0] = 1
        for i in range(1, len(coins)+1):
            # populating the 1st column of dp matrix with 1
            dp[i][0] = 1
            for j in range(1, amount+1):
                # if the amount to be made is less than the current denomination, use the result from previous row
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                # use the current denomination with no.of.ways to make amount-current denomation,
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        
        return dp[-1][-1]




        




