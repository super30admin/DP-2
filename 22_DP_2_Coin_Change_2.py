#Time Complexity : O(N*S) where N is the number of denomination and S is the amount
#Space Complexity : O(S) for using one extra array of amount size
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :

#Your code here along with comments explaining your approach

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        dp=[0]*(amount+1)
        dp[0]=1
        
        for coin in coins: 
            for x in range(coin, amount+1): 
                dp[x]+=dp[x-coin]
        
        return dp[amount]