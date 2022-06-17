# LC518_CoinChange2.py
"""
We have to return the number of possible ways to make up the given target amount from the coins array.

https://leetcode.com/problems/coin-change-2/

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Input: amount = 10, coins = [10]
Output: 1

                [ 1, 2, 5]..total = 11
                  /\                                    ..not take 1 or take 1 in the coins
    [2,5].. t= 11    [1,2,5].. t = 10


we will maintain a global counter and when t reaches 0 - we take that as the valid path

Recursive approach - we need amount, coins, index of coins

DP approach -



  
"""
# # 1-RECURSIVE
# class Solution:
#     def change(self, amount: int, coins : list[int])->int :
#         # null case
#         if len(coins)==0:
#             return 0
#         else:
#             return helper(amount, coins, 0)
    
# def helper( amount : int, coins: list, i : int) ->int:
#     # base case
#     if amount == 0:
#         return 1
#     if amount < -1 or i >len(coins)-1 :
#         return 0

#     # logic

#     # case choose
#     case1 = helper(amount - coins[i], coins, i)

#     # case not choose
#     case2= helper(amount, coins, i+1)

#     return case1+case2


# coins = [1,2,5]
# amount = 5

# object = Solution()
# ans = object.change(amount, coins)
# print(ans)


#2-DP
class Solution:
    def change(self, amount: int, coins : list[int])->int :
        m = len(coins)+1
        n = amount + 1
        if len(coins)==0 :
            return 0
        if amount == 0:
            return 1
        dp = [[0]*n for _ in range (m)]
        # print(dp)
        
        dp[0][0]= 1

        for i in range (1, m):
            for j in range(0, n):
                denomination = coins[i-1]
                if j < denomination :
                    dp[i][j]= dp[i-1][j]
                else :
                    dp[i][j]=dp[i-1][j]+ dp[i][j-denomination]
        return dp[m-1][n-1]


amount = 5
coins = [1,2,5]
object = Solution()
y=object.change(amount, coins)
print(y)








        




