# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O( )
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Always forgets the condition when col < coins[row - 1] in line 17

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        total_coins = len(coins)
        result = [[0 for i in range(amount + 1)] for j in range(total_coins + 1)]
        # initializing the 0th column 
        for i in range(total_coins + 1):
            result[i][0] = 1
        
        for row in range(1, total_coins + 1):
            for col in range(1, amount + 1):
                if  col < coins[row - 1]:
                    result[row][col] = result[row - 1][col]
                else:
                    result[row][col] = result[row - 1][col] + result[row][col - coins[row - 1]]

        return result[total_coins][amount]
            