'''

1. I solved the problems using the concepts learned with coin-change-1 but hit the wall, on the base cases for prefilling the matrix grid.

And also had some confusion to comprehend why 1 is prefilled in the matrix.

After re-watching the video, got some sense.

But these base cases are still tricky, hoping with some practice, the uncertainity will slowly evaporate.

TC: O(m*n)
SC: O(m*n)
'''

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        dp = [ [0 for j in range(amount+1)] for i in range(len(coins)+1)]

        for i in range(len(coins)+1):
            dp[i][0] =1


        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if((j- coins[i-1])>=0):
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
                else:
                    dp[i][j] = dp[i-1][j]

        return dp[len(coins)][amount]
