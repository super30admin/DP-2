# Dynamic Programming
# passed all test cases
# time complexity =O(m*n)
#space complexity=O(N)
class Solution(object):
    def change(self, amount, coins):
        # if amount == 0 and coins == []:
        #     return 1
        dp = [[None] * (amount + 1) for _ in range(len(coins) + 1)]  # amount+1 is columns and lem(coins)+1 is rows
        # a = [[0] * m] * n
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # print(len(dp))
        m = len(dp)  # rows = len(coins)+1
        n = len(dp[0])  # columns
        for i in range(m):
            dp[i][0] = 1  # for initialising the first column of dp matrix to 0 (0 to len(coins)
            # rows)
            # print('----',dp)
            i += 1
        # print('ppppp---', dp)
        for i in range(1, n):  # 0 to amount rows and starting i range from 1 as the 0th column values are 1 always which is intialised in above step
            # print('nnnn--', dp)
            dp[0][i] = 0  # initialising it to infinity not pssible so set it ---?why is evrything getting replaced
            # some large value
            i += 1
        # print('ppppppppmmmm---', dp)
        for i in range(1, m):  # for each row and start with 1 to m as value
            for j in range(1, n):  # for each column and start with 1 to n as 1st
                if j < coins[i - 1]:
                    # condition when the coins greater than amount
                    # by defaut consider previous coins values
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
                    # case when we add new coin
                j += 1
                # print('jjjjjjjjj---', dp)
            i += 1
        result = dp[m - 1][n - 1]  # index starts with 0
        return result

# l= Solution()
# l.coinChange([1,2,5],11)
