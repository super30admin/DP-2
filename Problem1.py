#Time complexity: O(m*n) where m and n are the number of coins and the amount respectively
#Space complexity: O(m*n)

#Accepted on Leetcode

#Approach
#Divide the problem into subproblems 
#Each subproblem's solution is = picking the current coin and adding to amount + not picking the current coin and moving onto the next one
#Create a 2D array to store solutions of previously solved subproblems, add dummy rows to mimic base cases
#Iterate through array bottom's up and find solution to each subproblem by taking sum of previous subproblems
#Solution to the entire problem will be the last row of the last column

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        dp = [[0 for i in range(amount + 1)] for j in range(n+1)]

        #setting first col to zero as there is only one combination to pick 0 (pick 'nothing')
        for i in range(n + 1):
            dp[i][0] = 1

        for i in range(1, n+1):
            for j in range(1, amount + 1):
                dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]] if j >= coins[i-1] else dp[i-1][j]
        
        return dp[n][amount]

# TC, amount = 3, coins [1,2], 
# Matrix = [[1,0,0,0], [1,0,0,0], [1,0,0,0], [1,0,0,0]]
# i 1 to 2 (included), j 1 to 3 (included)
# i = 1, j = 1, dp[1][1] = dp[0][1] + dp[1][0] = 1
# i = 1, j = 2, dp[1][2] = dp[0][2] + dp[1][1] = 1
# i = 1, j = 3, dp[1][3] = dp[0][3] + dp[1][2] = 1

#TC, amount = 0, coins = [1]
# Matrix = [[0], [0]]
