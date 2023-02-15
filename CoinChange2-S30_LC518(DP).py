# Dynamic Programming approach (If repeated subproblems in Recursive approach)
# Time Complexity = Space Complexity = O(amount X len(coins))
# Submitted successfully
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if len(coins)==0 or coins == None:
            return 0

        # adding a dummy row and column of 0 denomination and 0 amount for matrix assistance
        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]

        # amount 0 can be formed with any denomination by not choosing it; i.e. in only 1 way
        for k in range(len(coins)+1):
            dp[k][0] = 1
        #print(dp)

        for m in range(1, len(coins)+1):
            for n in range(1, amount+1):
                # only zero case which is just above
                if n < coins[m-1]:
                    dp[m][n] = dp[m-1][n]

                # adding as we need total number of ways
                else:
                    dp[m][n] = dp[m-1][n] + dp[m][n-coins[m-1]]

        return dp[len(coins)][amount]