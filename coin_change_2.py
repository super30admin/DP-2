# Time Complexity :
# O(MN) - M is the number of coins and N is amount

# Space Complexity :
# O(MN)

# Did this code successfully run on Leetcode :
#Yes

#We go through each coin and each amount value (from 0 upto given amount value) and count the number of ways the amount can be reached by all the coins currently considered. 
#Initially, until the current coin value reaches the amount value, it is only the number of ways the rest of coins before that can make up the amount and after that, it is the number of ways from previous coins + number of ways the current coin value can reach current amount - current coin value
#At the end, we have how many ways the final amount can be computed by using all the coins

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        m = amount
        dp_matrix = [[0] * (m + 1) for i in range(n+1)] 

        for i in range(1,m):
            dp_matrix[0][i] = 0

        dp_matrix[0][0] = 1

        for i in range(1,n+1):
            for j in range(0,m+1):
                if j < coins[i-1]:
                    dp_matrix[i][j] = dp_matrix[i-1][j]
                else :
                    dp_matrix[i][j] = dp_matrix[i-1][j] +  dp_matrix[i][j-coins[i-1]]

        return dp_matrix[-1][amount]
