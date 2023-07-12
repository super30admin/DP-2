#time: O(mn), m is amount and n is number of denominations
#space: O(mn)
# issues faced: indexing dp array and coin array
# did the code run successfully : yes
#Approach:
# bottom-up(tabulation) method to find number of ways for each amount

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for _ in range(amount+1)] for i in range(len(coins)+1)]
        coins.sort()
        dp[0][0] = 1
        for i in range(1, len(coins)+1):
            for j in range(amount+1):
                #case0
                temp = dp[i-1][j]
                #case1
                if j >= coins[i-1]:
                    temp += dp[i][j-coins[i-1]]
                dp[i][j] = temp
        return dp[-1][-1]