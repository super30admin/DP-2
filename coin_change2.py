class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[-1 for _ in range(amount+1)] for _ in range(len(coins))]
        return self.change_rec(dp,amount,coins,0)
        
    def change_rec(self,dp,amount,coins,index):
        if amount==0:
            return 1
        if len(coins)==0 or index>=len(coins):
            return 0
        

        if dp[index][amount]!=-1:
            return dp[index][amount]

        sum1 = 0
        if coins[index]<=amount:
            sum1 =self.change_rec(dp,amount-coins[index],coins,index)

        sum2 = self.change_rec(dp,amount,coins,index+1)

        dp[index][amount] = sum1+sum2
        return dp[index][amount]
            
            
        # tc and sc is o(amount*len(coins))
