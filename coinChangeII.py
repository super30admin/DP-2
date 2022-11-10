'''
Time Compelxity -->
O(n*m) where n is number of coins and m is the number of amount

Space Complexity -->
O(n*m) for the 2d array

Approach -->
create a 2d array with size coins and amount
at particular position check if the ampount is grater than equal to coins[i-1] index if so dp[i][j] will be addition of dp[i][j-coins[i-1]]+ dp[i-1][j] 
'''

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        #exhaustive approach
        #return self.CountChange(coins, amount, 0)
        dp=[[0 for i in range((amount+1))] for x in range(len(coins)+1)]
        #print(dp)
        for i in range(len(coins)+1):
            dp[i][0] = 1
        
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j>=coins[i-1]:
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]]
                else:
                    dp[i][j] = dp[i-1][j]
        return(dp[-1][-1])
        
        
        
    
    # def CountChange(self, coins, amount, index):
    #     if index==len(coins) or amount<0:
    #         return 0
    #     if amount ==0:
    #         return 1
    #     return self.CountChange(coins, amount, index+1) + self.CountChange(coins, amount-coins[index], index)
        
        
        