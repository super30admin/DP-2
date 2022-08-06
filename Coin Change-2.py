
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        if amount == 0:
            return 1
        result = [0]*(amount+1)
        for i in range(len(coins)):
            for j in range(1,amount+1):
                if j < coins[i]:
                    result[j] = result[j]
                elif j == coins[i]:
                    result[j] = result[j]+1
                else:
                    result[j] = result[j] + result[j-coins[i]]
        
        return result[amount]