#Coin change
#Time Complexity: O(n^2)
#Space Complexity: O(n^2)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0] * (amount+1) for _ in range(len(coins)+1)]
        dp[0][0] = 1
        for i in range(1, len(coins)+1):
            for j in range(0, amount+1):
                if coins[i-1] > j:
                #If coin is less than j then copy the values from previous row
                    dp[i][j]=dp[i-1][j]
                else:
                #answer at prev row + answer at i-1 index before that
                    dp[i][j]= dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[-1][-1]