#Time Complexity : O(MN)
# Space Complexity: O(MN) 
# Did it run on Leetcode: Yes

#------------------------------------MEMOIZATION-----------------
class Solution(object):

    def helper(self,coins,idx,amount):

        if amount == 0:
            return 1

        if idx >= len(coins) or amount < 0:
            return 0

        if self.memo[idx][amount] != -1:
            return self.memo[idx][amount]
        
        #Not choose
        not_choose = self.helper(coins, idx+1 ,amount)  
        #choose
        choose =  self.helper(coins,idx,amount - coins[idx])

        self.memo[idx][amount] = choose + not_choose

        return choose + not_choose

    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        n = len(coins)
        self.memo = [[-1] * (amount + 1) for _ in range(n + 1)]
        return self.helper(coins,0,amount)


#--------------------------------------------TABULATION Technique---------------------------------

class Solution(object):

    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        n = len(coins)
        m = amount
        self.dp = [[0] * (m + 1) for _ in range(n+1)]
        self.dp[0][0] = 1
        for i in range(1,n+1):
            for j in range(0,m+1):
                if j < coins[i - 1]:
                    self.dp[i][j] = self.dp[i - 1][j]
                else:
                    self.dp[i][j] = self.dp[i - 1][j] + self.dp[i][j - coins[i-1]]
        
        return self.dp[n][m]


        