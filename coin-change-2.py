# TC: O(M x N)
# SC: O(M x N)
# LC: YES
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        #dynamic programming
        table = [[0 for i in range(amount + 1)] for i in range(len(coins)+1)]
        for i in range(len(coins) + 1):
            table[i][0] = 1
        for row in range(1,len(table)):
            for col in range(1,len(table[0])):
                if col < coins[row - 1]:
                    table[row][col] = table[row - 1][col]
                else:
                    table[row][col] = table[row][col - coins[row - 1]] + table[row-1][col]
        # print(table)
        return table[len(coins)][amount]
            
        # brute force 
        # def helper(index, coins, amount):
        #     # terminating condition
        #     if amount == 0: return 1
        #     if amount < 0 or index == len(coins): return 0
        #     # choose - case 1
        #     case1 = helper(index, coins, amount - coins[index])
        #     # not choose - case 2
        #     case2 = helper(index+1, coins, amount)
        #     return case1 + case2
        # if amount == None or coins == None: return 0
        # return helper(0, coins, amount)