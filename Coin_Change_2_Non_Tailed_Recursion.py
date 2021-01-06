# Created by Aashish Adhikari at 1:26 PM 1/6/2021

'''
Time Complexity:
O(2 ^ (amount/ least denomination)) ~ O (2 ^ amount)

Space Complexity:
O(1)


'''

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if amount == 0:
            return 1

        if len(coins) == 0:
            return 0

        return self.helper(amount, coins, 0, 0)

    def helper(self, amount, coins, index, running_total):

        # base cases of recursion
        if index > len(coins)-1 or running_total > amount:
            return 0
        if running_total == amount:
            return 1

        case1 = self.helper(amount, coins, index + 1, running_total)
        case2 = self.helper(amount, coins, index, running_total+coins[index])

        return case1 + case2
