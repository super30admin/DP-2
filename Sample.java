## apint
class Solution:
  def minCost(self, costs: List[List[int]]) -> int:
    n = len(costs)
    if(n==0) : return 0
    for i in range(1,n):
        costs[i][0] += min(costs[i-1][1],costs[i-1][2])
        costs[i][1] += min(costs[i-1][0],costs[i-1][2])            
        costs[i][2] += min(costs[i-1][1],costs[i-1][0])            
    return min(costs[-1])
			
## coin change
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount+1)
        # There is 1 way to make 0 amount
        dp[0] = 1
        
        for coin in coins:
            # For each coin, update the dp table starting from the coin value
            for i in range(coin, amount+1):
                dp[i] += dp[i-coin]
                
        return dp[amount]
