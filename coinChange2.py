# Time Complexity : Brute Force: O(S^n) S:target, DP: O(n*S)
# Space Complexity : Brute Force: O(S^n) S:target, DP: O(n*S)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

class Solution(object):
    def __helper(self, coins, remainingAmount, index, counter):
        if index >= len(coins) or remainingAmount < 0:
            return counter
        if remainingAmount == 0:
            return counter + 1
        
        # choose 
        counter = self.__helper(coins, remainingAmount - coins[index], index, counter)
        # not choose
        counter = self.__helper(coins, remainingAmount, index + 1, counter)
        return counter
        
    def change(self, amount, coins):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if amount == 0:
            return 1
        counter = self.__helper(coins, amount, 0, 0)
        return counter
        

class Solution2(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        rows = len(coins) + 1
        cols = amount + 1
        dp = [[None for i in range(cols)] for j in range(rows)]
        for i in range(rows):
            dp[i][0] = 1
        for i in range(1, cols):
            dp[0][i] = 0
        for i in range(1,rows):
            for j in range(1,cols):
                if j >= coins[i-1]:
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]
        
        return dp[len(coins)][amount]


obj = Solution()
obj2 = Solution2()

amount = 5
coins = [1,2,5]
print(obj.change(amount, coins))
print(obj2.change(amount, coins))