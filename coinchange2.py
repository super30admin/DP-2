class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """

        if coins == None:
            return 0
        #         count=0
        #         def helper(coins,amount,index,count):
        #             #base case
        #             if amount==0:
        #                 count+=1
        #                 return count

        #             if amount<0 or index>=len(coins):
        #                 return 0
        #             # choose
        #             case1=helper(coins,amount-coins[index],index,count)
        # #             notchoose
        #             case2=helper(coins,amount,index+1,count)
        #             return case1+case2
        #         return helper(coins,amount,0,0)
        #     time:O(2**n)
        #     space:O(recursice stack)

        dp = [[0 for i in range(amount + 1)] for i in range(len(coins) + 1)]

        for j in range(len(dp)):
            dp[j][0] = 1
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
        return dp[len(dp) - 1][len(dp[0]) - 1]
    # n=amount
    # m=len(coins)
    # time- O(nm)
    # space-O(nm)