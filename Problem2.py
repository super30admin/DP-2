class Problem2(object):
    #     // Time Complexity : O(n*m) n is the number of coins, m is the amount
# // Space Complexity : O(m)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : no
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        # to find the number of combionations have to check all the combiations possible that could 
        # give the amount so to avoid doing overall subproblems, i will be using dp # saving the time complexity
        # dp[][] matrix where i store the nunber of combinations possible to make an amoutn x with coin of ith index
        # matrix where rows will be from 0 to len(coins), col will be 0 to amount
        # but to be more efficient i don't need to save each row that is the number of combinations with a single coing etc to make an amoutn
        # instead i will keep track of the previous row and compare if any combinations are possible with the current cin and update the array


        dp = [0]*(amount+1) # created an array with default value 0 of lenght amount 0-11 

        dp[0] = 1 # it is 1 combination to make amount 0 

        for i in range(1,len(coins)+1):
            for j in range(0,amount+1):
                if j >= coins[i-1]: # if the amount is less than the coin value then there are no combinations possible with this coin
                    # if not then the combinations possible are
                    # the number of combinations with previous coins = dp[j]
                    # + number of combinations possible with this coin that is -> with this coin and the combinations to make the rest amoutn 
                    # so the number is dp[j-coins[i-1]] 
                    dp[j] = dp[j] + dp[j-coins[i-1]]

        
        return dp[amount]

