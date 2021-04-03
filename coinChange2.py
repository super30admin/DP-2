"""
You are given coins of different denominations and a total amount of money. 
Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Brute force:
    use recurrsions like in previous coin change problem
    def change(coins, amount):
        if(coins == None):
            return 0
        return helper(coins, amount, 0)
    
    def helper(coins, amount, index):
        #base
        if(amount == 0):
            return 1
        if(amount < 0 or index == len(coins)):
            return 0

        #logic
        case1 = helper(coins, amount-coins[index], index)

        case2 = helper(coins, amount, index+1)
        return case1 + case2

"""
"""
Using dynamic programming
    time complexity = O(mn) -> m = len(coins) +1, n = amount+1
    space complexity  = O(mn)
    create a 2d array with size len(coins)+1 * amount +1

                1 for all j =0
                0 for i=0 and j>0
    d[i][j] =   d[i-1][j] for if coins[i-1]>j
                else
                d[i-1][j] + d[i][j-coins[i-1]] 
"""


def change(coins, amount):
    dp=[]
    dp.append([1] + [0]*amount)
    for i in range(1, len(coins)+1):
        dp.append([1])
        for j in range(1, amount+1):
            if(coins[i-1] > j):
                dp[i].append(dp[i-1][j])
            else:
                dp[i].append(dp[i-1][j] + dp[i][j-coins[i-1]])
    
    return dp[-1][-1]


print(change([1,2,5], 5))
print(change([1,2,5], 11))