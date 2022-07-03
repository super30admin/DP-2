#time complexity: O(mn), m:len of coins array, n: amount
#space complexity: O(mn)
#Approach: Dynamic programming.
# build a matrix with rows as indices of array, columns from 0 to amount
# if the coin is greater than column value, copy the before rows same col value.
# else add the before rows same col value with same row's remaining amount col value.
# return the last row last col value


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m= len(coins)
        n= amount
        dp = [[0 for i in range(n+1)]for j in range(m+1)]
        dp[0][0]=1
        for i in range(1,m+1):
            for j in range(0,n+1):
                if coins[i-1]>j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]+(dp[i][j-coins[i-1]])
        return dp[m][n]
        