#coin change 2
# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)

        dp[0] = 1 

        for i in range(len(coins)):
            for j in range(coins[i],amount + 1):
                dp[j] += dp[j - coins[i]]

        return dp[amount]


#paint house 
# Time Complexity : O(N^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO
 
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs or len(costs) == 0 or len(costs[0]) == 0:
            return 0
        
        for i in range(len(costs)-2,-1,-1):

            costs[i][0] += min(costs[i+1][1], costs[i+1][2])
            costs[i][1] += min(costs[i+1][2], costs[i+1][0])
            costs[i][2] += min(costs[i+1][1], costs[i+1][0])
        return(min(costs[0]))

