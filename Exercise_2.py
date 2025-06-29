# Time Complexity: O(n*m)
# Space Complexity: O(n)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: The index for picking the coin was failing due to dummy row , had to correct it accordingly

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        if len(coins) == 0:
            return 0

        # add 1 for 0th column as only 1 way to produce 0 amount
        dp = [[1 if j==0 else 0 for j in range(amount+1)] for i in range(len(coins)+1)] 
        
        # we solve using DP method, storing the no of ways forming the amount in the array
        for i in range(1, len(dp)):

            for j in range(1, len(dp[i])):

                # if val of coin is greater than amount, then take the 0th case, i.e dont choose that coin value
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                # else add up the 0th case along with the 1 case, choosing the case on the same row , j cols behind
                else:   
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]

        return dp[len(coins)][amount] 



