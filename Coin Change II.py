# Time Complexity : O(len(coins) * amount)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this : Yes, in Brute force and 2D array method I face error out of bound.


# Your code here along with comments explaining your approach


#brute force - TC  O(2^n)
def change(amount: int, coins) -> int:
        if coins == None or len(coins) == 0:
            return 0
        return helper(coins,amount,0)
    
def helper(coins,amount,idx):
    #base
    if (amount < 0 or idx == len(coins)):
        return 0
    if amount == 0:
        return 1

    #logic
    #choose case
    case1 = helper(coins,amount-coins[idx],idx)
    
    #not choose case
    case0 = helper(coins,amount, idx+1)
    
    return case0 + case1

amount = 5
coins = [1,2,5]
print(change(amount,coins))


#TC & SC  O(m * n) m= coins n = amount
def change1(amount: int, coins) -> int:
    if coins == None or len(coins) == 0:
        return 0
    m = len(coins)
    n = amount
    dp = [[0]*(m+1)]*(n+1)
    dp[0][0] = 1
    for i in range(1,m+1):
        for j in range(0,n+1):
            if j < coins[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
    return dp[m][n]

amount = 5
coins = [1,2,5]
#print(change1(amount,coins))


#1D array TC - O(m*n) & SC- O(1)

def change1D(amount: int, coins) -> int:
    if coins == None or len(coins) == 0:
        return 0
    n = amount
    dp = [0]*(n+1)
    dp[0] = 1
    for i in coins:
        for j in range(i,n+1):
            dp[j] = dp[j] + dp[j - i]
    return dp[-1]
amount = 5
coins = [1,2,5]
print(change1D(amount,coins))