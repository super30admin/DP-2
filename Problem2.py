# Time Complexity : O(m*n)
# Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = amount+1
        m = len(coins)
        dp1 = [0] * (n)
        dp1[0] =1
       
        for i in range(len(coins)-1, -1,-1):
            dp2 = [0]*(n)
            dp2[0] =1
            
            for j in range(1,n ):
                dp2[j] = dp1[j]
                if j - coins[i]>=0:
                    dp2[j] += dp2[j-coins[i]]
            dp1 = dp2
        return dp1[amount]
