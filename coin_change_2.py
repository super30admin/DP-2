'''
Time complexity: O(mxn) where m = number of coins and n = amount
Space complexity: O(n) as the operation is happening on a single array
'''
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        result = [0]*(amount+1)
        result[0] = 1 # For how many zeros needed to make 0, i.e., 1

        for i in range(len(coins)):
            for j in range(1,amount+1):
                if j>= coins[i]:
                    result[j] = result[j] + result[j-coins[i]]

        return result[-1] 