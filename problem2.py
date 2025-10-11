# Time Complexity : O(n*m) 
# Space Complexity : O(n*m)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : not with the programming logic but i am trying to practice with python as well so with in python was not smooth

"""
there we are using tabulation methord to solve the problem where
the matrix is tracking how many possible ways ae there to achive certain amount using the coins at hand,
we start will build a matrix were row are coins and column is amount
we buid it out from top down, one by one

while buiding we keep in mind:
if the coins we have 1,2,5 and amount 5
when we are building it our using 5 coin we can not make 0 1 2 3 4 amount so in that case we will use the way amount of the as that of the
above row
when we calulate number of ways we add way from [above row same amount + [same row - coin value]] 
"""

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        row = len(coins) + 1
        col = amount + 1
        print(row)
        dp = [[0]*col for _ in range(row+1)]
        dp[0][0] = 1
        for i in range(1,row):
            for j in range(col):
                if j == 0:
                    dp[i][j] = 1
                elif j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        re = dp[len(coins)][amount]
        return re
        