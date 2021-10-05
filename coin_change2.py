"""
Time complexity: O(n*m)
Space complexity:O(n*m)
Did your code run on leetcode? : yes
issues faced: (1) I was getting confused between index i and j
              (2) I was not getting output for edge cases like getting amount 3 using only 2 coin.
              Later I had to add an if statement to account for that and return -1
"""
class Solution:
    def change(self, coins, amount):
        dp_matrix = [[None for i in range(amount+1)]for j in range(len(coins)+1)]
        # print(dp_matrix)
        for j in range(1,len(dp_matrix[0])):
            dp_matrix[0][j] = 0
            # print("DP first row ",dp_matrix)
        for i in range(0,len(coins)+1):
            dp_matrix[i][0] = 1
            # print("DP 1st column " ,dp_matrix)
        for i in range(1,len(coins)+1):
            for j in range(1,len(dp_matrix[0])):
                if j < coins[i-1]:
                    dp_matrix[i][j] = dp_matrix[i-1][j]

                else:
                    dp_matrix[i][j] =  dp_matrix[i][j-coins[i-1]] + dp_matrix[i-1][j]
        if dp_matrix[-1][-1] == amount + 1:
            return 1
        # print("final DP",dp_matrix)
        return dp_matrix[-1][-1]
# Driver Code
if __name__ == '__main__':
    CC = Solution()
    print(CC.coinChange([1,2,5],11))
