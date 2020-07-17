'''
PROBLEM 1

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

- traverse the costs array and update each value as the minimum cost upto that point depending on the previous choice made
- At iteration i, for a specific color the minimum cost would be cost[i][color] + minimim of cost at iteration i-1 of other two colors
- the answer will be minimum of last row in the cost matrix

'''

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        length= len(costs)
        if length==0:
            return 0
        i=0
        for i in range(1,length):
                #case1
                costs[i][0]= min(costs[i-1][1], costs[i-1][2]) + costs[i][0]
                #case2
                costs[i][1]= min(costs[i-1][0], costs[i-1][2]) + costs[i][1]
                #case3
                costs[i][2]= min(costs[i-1][0], costs[i-1][1]) + costs[i][2]
        print(costs)
        return min(costs[i][0], min(costs[i][1], costs[i][2]))

'''
PROBLEM 1

TIME COMPLEXITY: O(Number of coins * amount)
SPACE COMPLEXITY: O(Number of coins * amount)

- traverse the costs array and update each value as the minimum cost upto that point depending on the previous choice made
- At iteration i, for a specific color the minimum cost would be cost[i][color] + minimim of cost at iteration i-1 of other two colors
- the answer will be minimum of last row in the cost matrix

'''

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]
        
        for i in range(len(coins)+1):
            dp[i][0]=1

        
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):

                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                   
                    dp[i][j]= dp[i-1][j] + dp[i][j-coins[i-1]]
          
        return dp[len(coins)][amount]
        