
# // Time Complexity : O(nm) where n is len(coins)+1 and m is amount+1
# // Space Complexity :O(nm)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :yes , learnt it from sir

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if (coins==[] and amount>0):
            return 0
        coins=sorted(coins)
        dp=[[0 for j in range(amount+1)] for i in range(len(coins)+1)]
        dp[0][0]=1

        for i in range(1,len(coins)+1):
            for j in range(amount+1):
                if(coins[i-1]>j):
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
                    

        return dp[len(coins)][amount]