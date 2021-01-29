# Time Complexity :O(n^m) where n is number of coins and m is amount
# Space Complexity :O(m)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 518


# You are given coins of different denominations and a total amount of money.
# Write a function to compute the number of combinations that make up that amount.
# You may assume that you have infinite number of each kind of coin

# Example 1:
#
# Input: amount = 5, coins = [1, 2, 5]
# Output: 4
# Explanation: there are four ways to make up the amount:
# 5=5
# 5=2+2+1
# 5=2+1+1+1
# 5=1+1+1+1+1
# Example 2:
#
# Input: amount = 3, coins = [2]
# Output: 0
# Explanation: the amount of 3 cannot be made up just with coins of 2.


def main():
    amount = 5
    coins = [1,2,5]

    print(change(amount,coins))
def change(amount,coins):
    # This problem is similar to coin change problem. Here i have been more intuative
    # and used just 1d array instead of matrix.
    # The size of the array is amount + 1
    a = amount + 1

    # Here there is one way to make the amount 0 so the first element is 0 and there are
    # zero ways to make every other amount with 0 coin.
    dp = [1] + [0] * amount

    # Iterating over all the coins
    for coin in coins:
        # Iterating only from that coin to the amount because if the amount is lower than the coin it doesn't make sense.
        for x in range(coin, a):
            # And the main answer would be the current way + when we use the coin and the difference.

            # So for eg:[1,2] 2 -> and we use coin 2, so amount [1,2] 2 will become the og value i.e. the number of ways we can make amount 2 from coin 1 + number of ways we can make amount 2-2 = 0 with coin [2].
            dp[x] += dp[x - coin]

    # And as usual we return the last value in the array
    return dp[-1]

if __name__ == '__main__':
    main()