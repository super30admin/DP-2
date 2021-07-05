# Method1 - Brute Force
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if (coins == [] or len(coins) == 0) :
            return 0
        return self.helper(amount,coins, 0)
    
    def helper(self, amount, coins, index):
        # base
        if amount == 0:
            return 1
        if (amount < 0 or index == len(coins)):
            return 0
        
        print(index)
        # choose
        case1 = self.helper(amount-coins[index],coins,index)
        # Don't choose
        case2 = self.helper(amount,coins,index+1)
        
        return case1+case2

#Method2 - Dynamic Programming
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if (coins == [] or len(coins) == 0) :
            return 0
        rows = len(coins)+1
        col = amount+1
        print(rows,col)
        dp = [[rows],[col]]
        # fill first column
        for i in range(0,len(coins)):
            dp[i][0] = 1
            
        for i in range(0,len(coins)):
            for j in range(1,amount):
                # amount
                if coins[i-1]>j:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+coins[i-1]
        return dp[len(coins)[amount]]
                
