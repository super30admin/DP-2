# Time Complexity O(n * k) where n is the length of coins array and k is the amount
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins:
            if not amount:
                return 1
            return 0
        else:
            d = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]
            d[0][0] = 1
            for i in range(1,len(d[0])):
                d[0][i] = 0
            for j in range(1,len(d)):
                d[j][0] = 1

            for i in range(1, len(d)):
                for j in range(1, len(d[0])):
                    if coins[i-1] > j:
                        d[i][j] = d[i-1][j]
                    else:
                        d[i][j] = d[i][j-coins[i-1]] + d[i-1][j]
            return d[len(coins)][amount]
