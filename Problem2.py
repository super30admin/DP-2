# Coin Change 2

#   Time Complexity : 2^ (m+n)
#   Space Complexity : O(1)
#   Did this code successfully run on Leetcode : No, time limit exceeded
#   Any problem you faced while coding this : No


#  Your code here along with comments explaining your approach

# Approach 1: Recursion - Time Limit Exceeded

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        return self.helper(amount, coins, 0)
    
    def helper(self, amount: int, coins: List[int], index: int) -> int:
    
    # base case
    
        if index > len(coins)-1 or amount < 0: 
            return 0
        if amount == 0: 
            return 1
        # logic case
        # choose the coin
        case1 = self.helper(amount-coins[index], coins, index)
         # dont choose the coin
        case2 = self.helper(amount, coins, index + 1)
        return case1 + case2

#   Time Complexity : O(m*n)
#   Space Complexity : O(m*n)
#   Did this code successfully run on Leetcode : No, time limit exceeded
#   Any problem you faced while coding this : No
# Approach 2: Dynamic Programming 

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        # check parameters for edge cases
        if len(coins) == 0 or coins == None:
            return -1
        
        # create a dp array with sizes m and n
        # taking a dummy row
        m = len(coins) + 1
        # taking an extra column for amount = 0
        n = amount + 1
        dp = [[0 for y in range(n)] for x in range(m)]
        
        # filling 1st column - 1s ; 1 way to pick amount 0 for all the coins
        
        for i in range(0,m):
            dp[i][0] = 1
        
        # filling 1st row - 0 way for picking up no coin for all the amounts ; invalid case
        
        for j in range(1,n):
            dp[0][j] = 0
            
        # filling rest of the values
        
        for i in range(1,m):
            for j in range(1,n):
                
                # if the denomination is greater than the amount 
                # take only the zero case
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                    
                # take zero and one case
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        
        return dp[m-1][n-1]
