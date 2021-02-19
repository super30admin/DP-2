#Time Complexity :  O(mn) (where n = amount and m = number of coins)
#Space Complexity : O(mn) (where n = amount and m = number of coins)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        if coins == None:
            return 0
        
        
        dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]
        rows, cols = len(dp), len(dp[0])

        for i in range(rows):
            dp[i][0] = 1
            
        for coin in range(1,rows):
            for amt in range(1,cols):
                if (amt < coins[coin-1]):
                    dp[coin][amt] = dp[coin-1][amt]
                
                else:
                    dp[coin][amt] = dp[coin-1][amt]+dp[coin][amt-coins[coin-1]]
        
        return dp[rows-1][cols-1]

