
# 1d array space optimized
# time O(n*m), space O(n)
# dp[j] is the number of ways to make amount j with subset of coins up to and including i
class Solution:
    def change(self, amount: int, coins: List[int]):
        dp = [0]*(amount+1)
        dp[0]=1
        for i in range(1, len(coins)+1):
            for j in range(0,(amount+1)):
                if j<coins[i-1]:
                    dp[j] = dp[j]
                else:
                    dp[j] = dp[j] + dp[j - coins[i-1]]
        
        return dp[-1]


# solve with 2d array
# time: O(n*m), space O(n*m)
class Solution:
    def change(self, amount: int, coins: List[int]):
        dp = [[0]*(amount+1) for _ in range(len(coins)+1)]
        dp[0][0]=1
        for i in range(1, len(coins)+1):
            for j in range(0,(amount+1)):
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        
        return dp[-1][-1]

# time: O(n+m), space O(n+m)
# without memoization the time complexity is O(2^(n+m)) - 2 choices at each step so number of nodes nearly doubles at every 
# level of the tree. could take the coin n times for a coin of 1 to get value of amount n. have to decide whether to take or 
# skip each coin m
class Solution:
	def change(self, amount: int, coins: List[int]):
		self.memo = [[-1] * (amount+1) for _ in range(len(coins)+1)]
		return self.helper(coins, amount, 0)

	def helper(self, coins, amount, i):
		# base
		if amount < 0 or i == len(coins):
			return 0

		if amount == 0:
			return 1

		if self.memo[i][amount] != -1:
			return self.memo[i][amount]

		# don't choose
		case1 = self.helper(coins, amount, i+1)
		# choose
		case2 = self.helper(coins, amount-coins[i], i)
		self.memo[i][amount]=case1+case2
		return case1+case2
