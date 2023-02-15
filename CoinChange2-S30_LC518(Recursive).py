# Recursive/Exhaustive approach
# Exponential Time Complexity (TLE)
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if len(coins)==0 or coins == None:
            return 0

        # coins and amount are the 2 decision making parameters and starting with index 0
        return self.helper(coins, amount, 0)

    def helper(self, coins, amount, index):
        # base case
        if amount<0 or index==len(coins):
            return 0

        if amount==0:
            return 1    #adding 1 combination to the total no. of combinations we need

        # logic
        # zero case or do not choose case
        # if we do not choose, we go to the next denomination
        case0 = self.helper(coins, amount, index+1)

        # one case or choose case
        case1 = self.helper(coins, amount-coins[index], index)

        return case0+case1