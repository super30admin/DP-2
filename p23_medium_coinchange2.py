"""
https://leetcode.com/problems/coin-change-2/
You are given an integer array coins representing coins of different
denominations and an integer amount representing a total amount of money.
Return the number of combinations that make up that amount.
If that amount of money cannot be made up by any combination of the coins, return 0.

Tc: mn --row* col
SC mn
Ran on leetcode-yes

"""

###below is recursive brute force solution
class Solution:
    """
    dp solution below
    """

    def change(self, amount, coins):
        ###make the dp matrix
        dpmatrix=[[0 for x in range (amount+1)] for y in range (len(coins)+1 )]
        for i in range(len(dpmatrix)):
            dpmatrix[i][0]=1
        ### the upper row 0's are default in the matrix so we dont realy need to fill them for now so
        ###so we start from the first row
        for i in range(1, len(dpmatrix)):
            for j in range(1, len(dpmatrix[0])):

                ###untill the amount is lesser than the denomation of the coin, take the value
                ##from same column row above
                ###in actual matrix i=1 will be 2 so we will do i-1 so that it directs us to 1 which
                ###is the first value of the coins denomination array
                if j < coins[i-1]:
                    dpmatrix[i][j]=dpmatrix[i-1][j] ##value from up
                else:
                    ###value from up + value from those many steps back as the denomination of coin
                    dpmatrix[i][j]=dpmatrix[i-1][j] + dpmatrix[i][j-coins[i-1]]



        return dpmatrix[len(dpmatrix)-1][len(dpmatrix[0])-1]




    """
    Recursive solution below
    """
    # def change(self, amount, coins):
    #     if coins==None:
    #         return 0
    #     return self.helper(amount, coins, 0)
    #
    # def helper(self, amount, coins, index):
    #
    #     ##base case
    #     if amount==0:
    #         return 1
    #     if amount<0 or index==len(coins):
    #         return 0
    #
    #     ##logic
    #
    #     """chose"""
    #     case1=self.helper(amount-coins[index], coins , index)
    #
    #     """dont chose"""
    #     case2=self.helper(amount, coins,  index+1)
    #
    #     return case1+case2





coins = [1,2,5]
amount = 5
solve=Solution()
print(solve.change(amount, coins))

