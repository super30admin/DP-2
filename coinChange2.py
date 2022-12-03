# // Time Complexity : O(mn) --> m--> amount, n-->coins
# // Space Complexity : O(mn) and O(m) respectively
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# // Your code here along with comments explaining your approach

class solution:
    def coinChange2(self, amount, coins):

        ##  we basically have to find out the number of ways to reach the amount. 
        ## According to our tree we can either chose a coin or not chose a coin to reach the amount.
        ## our answer for the current cell would be sum of creatuing the amount with the 2 choices and the coins. OUr consideration factors are coins ans the amount.
        ## initially we initialize our row and column with 0 and respectively. if the  amount < coin, get value from previous coin else, previous value+ the number of ways if we chose the coin.
        dp = [[0]*(amount+1) for _ in range(len(coins)+1)]

        for i in range(len(amount)+1):
            dp[i][0] =1
        
        for row in range(1,len(coins)+1):
            for col in range(1,amount+1):

                if col < coins[row-1]:
                    dp[row][col] = dp[row-1][col]
                
                else:
                    dp[row][col] = dp[row-1][col] + dp[row][col - coins[row-1]]
        
        return dp[-1][-1]

    
    def coinChang2_singleArray(self, coins, amount):

        dp = [0]*(amount+1)
        dp[0] = 1

        for coin in coins:
            for col in range(coin, amount+1):
                dp[col] = dp[col] + dp[col-coin]
        return dp[-1]  


