# Leetcode 518. Coin Change 2

# Time Complexity :  O(nT) where n is the size of the array and T is the amount
# Space Complexity : O(T) where T is the amount

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Find the optimal solution for each sub problem and combine them. Create a matrix with coins as the rows
# and amount as colums. Use the previous row values as long as the current coin value is less than the current amount.
# Fill the values in order cells with a sum of previous row and the no. of coins required to fill the balance amount.
# Return the last cell in matrix.

# Your code here along with comments explaining your approach

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        matrix = [[0 for y in range(amount+1)] for x in range(len(coins)+1)]
        for i in range(len(coins)+1):
            matrix[i][0] = 1

        for i in range(1, amount+1):
            matrix[0][i] = 0

        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):

                if(j < coins[i-1]):
                    matrix[i][j] = matrix[i-1][j]
                else:
                    # previous + same row balance amount coins
                    matrix[i][j] = matrix[i][j-coins[i-1]] + matrix[i-1][j]
        # print(matrix)
        return matrix[len(coins)][amount]
