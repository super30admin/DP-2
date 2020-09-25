"""
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

 

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10] 
Output: 1
"""
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
	"""
	Create a DP array rows with coins and columns as amount.
	Loop through the fill the number of ways we can generate a particular amount. 
	"""
        #Runtime Complexity: O(N)
		#Space Complexity: O(M*N)
        # 
        if amount == 0 and not coins:
            return 1
        if not coins:
            return 0
        dp = [[0 for _ in range(amount+1)]  for x in range(len(coins))]
        for i in range(len(coins)):
            dp[i][0] = 1
            for j in range(1,amount+1):
                if coins[i] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]]
        return(dp[-1][-1])