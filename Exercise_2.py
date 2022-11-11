# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if amount == 0:
            return 1
        
        nrows = len(coins) + 1
        ncols = amount + 1
        
        dp = [[0 for _ in range(ncols)] for _ in range(nrows)]
            
        for i in range(nrows):
            dp[i][0] = 1
            
        # OTHER CELLS
        for i in range(1, nrows):
            for j in range(1, ncols):
                
                # CASE 1 - WE MUST LEAVE THE COIN
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                
                # CASE 2 - WE CAN TAKE OR LEAVE THE COIN
                else:
                    take = dp[i][j - coins[i - 1]]
                    leave = dp[i - 1][j]
                    dp[i][j] = take+leave
        
        #print(dp)
        return dp[-1][-1]
            