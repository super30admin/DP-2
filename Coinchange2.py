#Time complexity: O(m*n)   
#Space complexity: O(m*n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        dp = [[0]*(amount+1)]*(len(coins)+1)
        
        # for column 1, all 1's because 1 way to reach 0
        for row in dp:
            row[0] = 1
        
        for i in xrange(1,len(dp)):
            for j in xrange(len(dp[0])):
                #for denom < the item, we copy the value from upper row
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                #add upper item which is one path and item which is items steps before which is the other path
                else:
                    dp[i][j] = dp [i-1][j]+dp[i][j-coins[i-1]]
        # return last element
        return dp[-1][-1]
        
        # Recursive solution
#         def helper(amount,coins,index):
#             #base condition
#             if index == len(coins) or amount <0: return 0
#             if amount == 0: return 1
#             #logic
#             case1 =  helper(amount-coins[index],coins,index)
#             case2 = helper(amount,coins,index+1)
            
#             return case1+case2
#         return helper(amount,coins,0)