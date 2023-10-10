class Solution(object):
    ###################################
    # exhaustive recursive approach
    # TC: 2^(m+n) (exponential) where m = # of coins & n = amount
    ###################################

    # def change(self, amount, coins):
    #     """
    #     :type amount: int
    #     :type coins: List[int]
    #     :rtype: int
    #     """
    #     if coins is None:
    #         return 0 # return 0 if given coins list is null
    #     return self.helper(coins, amount, 0)

    # def helper(self, coins, amount, i):
    #     ## base case

    #     # 1 valid way if amount boils down to 0
    #     if amount  == 0:
    #         return 1
    #     # 0 valid ways if amount turns negative or coins array becaomes empty, in our case idx goes out of range
    #     if amount < 0 or i == len(coins):
    #         return 0

    #     ## recursion logic

    #     # not choose
    #     case1 = self.helper(coins,amount,i+1) # remove the element at idx i, or in short increment idx by 1
    #     # choose
    #     case2 = self.helper(coins,amount-coins[i],i) # if you choose the element at idx i, deduct curr amount by element

    #     return case1 + case2 # total number of ways = result of choose + result of not choose

    ###
    ###################################
    # DP
    # TC: O(mxn) where m = # of coins & n = amount
    # SC: O(mxn) since we make a 2D matrix
    ###################################
    def change(self, amount, coins):
        m = len(coins)
        n = amount

        # create 2D matrix of m+1*n+1  - SC : O(mxn)
        dp = []
        for _ in range(m+1):  # TC O(m)
            dp.append([0] * (n+1))

        dp[0][0] = 1  # there is 1 way of picking 0 to make amt = 0 i.e. by not picking 0

        # for all other rows, fill 1 for amt = 0
        for i in range(1, len(coins)+1):
            dp[i][0] = 1

        # iterate from (1,1) idx now until m,n : TC: O(mxn)
        for i in range(1, m + 1):  # TC: O(m)
            for j in range(1, n+1):  # TC: O(n)

                # for any (i,j) until the curr amount is less than the denomination, just copy from previous row (same coln)
                if j < i:
                    dp[i][j] = dp[i-1][j]
                # for all other amts, calculate 0th probability by copying previous row value + 1th probability by subtracting current idx - denomination
                else:
                    # coins[i-1] as in dp we have added extra row so in actual coins[] we need to check one idx behind
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

                    # last element of the matrix is the total # of ways
                    return dp[m][n]


obj = Solution()
print(obj.change(11, [1, 2, 5]))
