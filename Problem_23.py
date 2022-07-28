# Time Complexity : O(mn) where m is the length of coins and n is the amount
# Space Complexity : O(mn) for the DP array. We can optimize this to O(n) by using 1D DP array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # opt = [[None for _ in range(amount+1)] for _ in range(len(coins)+1)]
        # opt[0][0] = 1 # 1 way for 0 coins to represent 0 amount
        # for i in range(1,len(opt[0])):
        #     opt[0][i] = 0 # 0 ways to get any amount>0 from coins of 0 denomination
        # # print(opt)    
        # for i in range(1,len(opt)):
        #     for j in range(len(opt[0])):
        #         # For all cases when j is less than coins[i], copy corresponding value from the previous row
        #         if j < coins[i-1]:
        #             opt[i][j] = opt[i-1][j]
        #         else:
        #             opt[i][j] = opt[i-1][j] + opt[i][j-coins[i-1]]
        # # print(opt)
        # return opt[len(coins)][amount]
    
    ####### Using only 1D DP matrix to save space
        opt = [None for _ in range(amount+1)]
        opt[0] = 1 # 1 way for 0 coins to represent 0 amount
        for i in range(1,len(opt)):
            opt[i] = 0 # 0 ways to get any amount>0 from coins of 0 denomination
        # print(opt)    
        for i in range(len(coins)):
            # We start j only from coins[i-1] because for all values of j before the current denomination, the value in opt can not change
            # We give coins[i-1] because we started DP array with coin denomination 0, so that is an extra denomination which is not given in the question
            for j in range(coins[i-1],len(opt)):
                opt[j] += opt[j-coins[i-1]] # Update opt[j] by adding both the previous opt[j] for when the current coin is not selected and opt[j-coins[i-1]] for when coin is selected. We give coins[i-1] as we start with 0
        # print(opt)
        return opt[len(opt)-1]
    