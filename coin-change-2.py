# Reference Video: https://youtu.be/_fgjrs570YE
# Github link: https://github.com/mission-peace/interview/blob/master/python/dynamic/coin_change_num_ways.py
# Time Complexity: O(m*n)(nested loops) where m is the number of coins and n is the amount
# Space complexity: O(m*n) where m is the number of coins and n is the amount
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        cols = amount + 1
        rows = len(coins)
        dp = [[1 if cols == 0 else 0 for cols in range(cols)]for rows in range(rows)]
        for i in range(0, rows):
            for j in range(1, cols):
                if coins[i] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + (dp[i][j - coins[i]])  
        return dp[rows-1][cols-1]
                    
                    
                    