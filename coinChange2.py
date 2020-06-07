# All analysis is for the solution on line 45 and beyond.
# Time Complexity : O(m*n), where m is amount and n is length of coins array.
# Space Complexity : O(n), where n is length of coins array.
# Did this code successfully run on Leetcode : Yes!
# Any problem you faced while coding this : No.

# Your code here along with comments explaining your approach
class Solution(object):
    # approach 1 Brute Force/greedy, Time limit exceeded
    def changeGreedy(self, amount, coins):
        if amount == 0: return 1
        if not coins: return 0
        return self.helper(coins, amount, 0)

    def helper(self, coins, amount, index):
        # base case
        if amount == 0: return 1
        if index == len(coins) or amount < 0: return 0
        # logic
        # choose
        caseChoose = self.helper(coins, amount-coins[index], index)
        # not choose
        caseNotChoose = self.helper(coins, amount, index+1)

        return caseChoose + caseNotChoose

    # approach 2, using 2 Dimensional Array
    def change2DArray(self, amount, coins):
        if amount == 0: return 1
        if not coins: return 0

        dpArray = [[0 for _ in range((amount + 1))] for _ in range(len(coins) + 1)]

        for i in dpArray:
            i[0] = 1

        for i in range(1, len(dpArray)):
            for j in range(1, len(dpArray[0])):
                if j < coins[i-1]:
                    dpArray[i][j] = dpArray[i-1][j]
                else:
                    dpArray[i][j] = dpArray[i-1][j] + dpArray[i][j-coins[i-1]]
        return dpArray[-1][-1]

    # approach 3, using one dimensional array.
    # Comments explaining approach
    #
    # we can use an array instead of a two dimensional array because we're always adding
    # on to previous computations therefore there isn't a need to store previous computations.
    # Since a coin cannot be used until the amount is equal to it's denomination the
    # computation for any coin takes place from it's value until the amount, resulting
    # in multiple computations for each coin and since we always add on to previous
    # computations, the last value in the array is the max number of ways for the given amount.
    def change1DArray(self, amount, coins):
        if amount == 0: return 1
        if not coins: return 0

        dpArray = [0] * (amount+1)
        dpArray[0] = 1

        for i in coins:
            for j in range(i, len(dpArray)):
                dpArray[j] += dpArray[j-i]
        return dpArray[-1]

s = Solution()
print(s.change1DArray(5, [1,2,5]))
