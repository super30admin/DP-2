#Time Complexity : O(M*N), M being amount and N begin the different types of coins.
#Space Complexity : O(M*N), M being amount and N begin the different types of coins.
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : I had to debug a lot to make sure the 
# corner cases to fill my dp array were all handled. 

#Your code here along with comments explaining your approach in three sentences only
'''Used dynamic programming with a 2D dp array, rows for the different types of coins, 
and the columns for the amount. At each case, for each coin index and amount, there is a 
split between choosing the coin and not choosing. The amount is then the addition of 
choosing and not choosing. 
'''
class Solution:
    def handler(self, coins, amount, index, combinations, dp):
        # base cases when combination is found, amount=0, and out of bound cases. 
        if amount==0:
            if dp[index][amount]==None:
                dp[index][amount]=combinations+1
            return dp[index][amount]
        elif amount<0:
            return combinations
        elif index>=len(coins)+1:
            return combinations
        else:
            #fill the dp array with the additions of the next cases, pick from dp array. 
            if dp[index][amount]==None:
                case_not_choose = self.handler(coins, amount, index+1, combinations, dp)
                case_choose = self.handler(coins, amount-coins[index-1], index, combinations, dp)
                dp[index][amount] = case_not_choose + case_choose
            return dp[index][amount]

    def change(self, amount: int, coins: List[int]) -> int:
        #initialize the dp array. 
        dp = [[None for i in range(amount+1)] for j in range(len(coins)+2)]
        dp[0][0]=1
        for i in range(1,amount+1):
            dp[0][i]=0
            dp[len(coins)+1][i]=0
        for i in range(1,len(coins)+2):
            dp[i][0]=1

        # final choice and result. 
        result_not_choose = self.handler(coins, amount, 2, 0, dp)
        result_choose = self.handler(coins, amount-coins[0], 1, 0, dp)

        return result_not_choose + result_choose