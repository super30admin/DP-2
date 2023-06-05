 """
        Time complexity : O(n)
        space complexity : O(n)
        
        Did this code successfully run on Leetcode : Yes
        Any problem you faced while coding this : No
        """


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
            #The logic is we find number of ways we can make change for each amount from
            #1 to amount. Because, let's say we know how many ways we can make change
            #for amount = 2,3,4. Then for a coins array of 1,3 we can say that number
           # of ways we can make change for 5 is equal to number of ways we can make
            #change for (5-1=4) + (5-3=2).
    
        dp = [0] * (amount + 1)
        dp[0] = 1
        # Why we are looping through coins first and then through amount for each coin is
        # If we loop through amount first and then coins for each amount, we might get
        # duplicate ways because of unorderness. Example: Using 1, 3. we can make 5
        # by 1 + 1 + 3, 1 + 3 + 1, 3 + 1 + 1. But actually all these 3 possibilites
        # are same. This will be avoided if we loop through coins first. Since, we 
        # will only consider each coin once for each amount
        for coin in coins:
            # Why we are starting loop from coin instead of 0 is, if i < coin, i - coin
            # will ge -ve. In normal words, if current amount is 2 and if coin is 5, we
            # anyway can't make an amount of 2 from coin 5.
            for i in range(coin, amount + 1):
                dp[i] += dp[i - coin]

        return dp[-1]
        
       