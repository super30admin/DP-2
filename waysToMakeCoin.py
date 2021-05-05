"""
Intuition:  Check greedy. Greedy will fail.

We will have to browse all possible comvbinations. (Be exhaustive)

After drawing the recursive tree,we will notice the subproblems.

#####################################################################
For Recursive: 2 decisions are made at every row.
Time Complexity : O(2^N)  N = number of coins
Space Complexity : O(2^N) 
#####################################################################
For DP Approach: Both top to bottom & bottom to top
Time Complexity : O(target * numberOfCoins)
Space Complexity : O(target * numberOfCoins)
#########
"""

#Recursive
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        return self.helper(coins, 0, amount)
    def helper(self, coins, index, amount ):
        if amount == 0:
            return 1
        if index >= len(coins) or amount < 0:
            return 0
        else:
            #0 Case
            case1 = self.helper(coins, index + 1, amount )

            #1 case 
            case2 = self.helper(coins, index, amount - coins[index])
            return case1+case2
            

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for _ in range(amount+ 1)] for _ in range(len(coins)+1)]
        dp[0][0] = 1 #we can make 0 with 0 coins.
        for i in range(len(dp)):
            dp[i][0] = 1
        for i in range(1,  len(dp)):
            for j in range(1, len(dp[0])):
                
                denomination = coins[i-1]
                target = j 
                
                #Cannot make the target value
                if denomination > target:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][(target - denomination)]
                    
        print(dp)
        return dp[-1][-1]