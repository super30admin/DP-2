class Solution(object):
    def coinChange(self, coins, amount):
        """
        Time complexity O(m*n), Space: O(m*n) where m is length of coin array and n is amount
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        re = self.helper(coins, amount, 0)
        #coins = [2], amount = 3 you can make any amount give here, 
        # if ive gone out of bounds  
        m = len(coins)
        n = amount
        self.memo = [[0] * (n + 1) for _ in range(m + 1)]
        if re >= 99999:
            return -1
        return re
    
    def helper(self, coins, amount, idx):
        #base case
        if (amount==0):
            return 0
        #the amount becomes negative — this path is invalid
        if amount < 0 or idx == len(coins):
            return 99999

        if self.memo[idx][amount] != 0:
            return  self.memo[idx][amount]
        #logic
        #case 1 - dont choose
        case1 = self.helper(coins, amount, idx+1)
        #case2 - choose
        #add +1 because I just chose that one coin in the current index
        case2 = 1 + self.helper(coins, amount-coins[idx], idx)

        self.memo[idx][amount] = case1 + case2
        return self.memo[idx][amount]