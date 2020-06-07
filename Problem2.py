# Time Complexity : O(m x n), where m = range of amount and n = no of coins
# Space Complexity : O(m x n), where m = range of amount and n = no of coins
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def change(self,amount, coins):
        if amount == 0:
            return 1 
        if not coins or len(coins) == 0:
            return 0 
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        for i in range(len(dp)):
            dp[i][0] = 1 
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[-1][-1]
    
    # def change(self,amount, coins):
    #     if amount == 0 :
    #         return 1 
    #     if not coins or len(coins) == 0:
    #         return 0 
    #     return self.helper(amount,coins,0,0)
        
    
    # def helper(self,amount,coins,index,ways):
    #     # base 
    #     if amount == 0:
    #         return 1
    #     if amount < 0 or index == len(coins):
    #         return 0 
    #     # logic 
    #     # choosen 
    #     case1 = self.helper(amount - coins[index],coins,index,ways)
        
    #     #not choosen
    #     case2 = self.helper(amount,coins,index+1,ways)
    #     return case1 + case2 

if __name__ == "__main__":
    s = Solution()
    coins = [1, 2, 5]
    amount = 5
    res = s.change(amount,coins)
    print("ways",res)