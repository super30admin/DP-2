# Time limit exceeded error in leet code.
# Brute Force Approach( using a recurrsion tree with 2 cases at every point)
# time -(exponencial) 2^n,
def coinChange(coins, amount):
    return helper(coins, amount, 0)

def helper(coins, amount, i):
    # base case, 3 conditions to verify.
    if amount < 0 or i > len(coins) - 1: return -1
    if amount == 0: return 1
    # case1 choose the coin
    case1 = helper(coins, amount - coins[i], i)
    # case2 dont choose the coin
    case2 = helper(coins, amount, i + 1)
    # return statements
    if case1 == -1:
        return case2
    elif case2 == -1:
        return case1
    else:
        return case1+case2

print(coinChange([1,2,5], 5))