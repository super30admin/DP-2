"""
TC:O(n x m)
SC: O(m)
"""

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        ways = [0 for i in range(amount+1)]
        
        ways[0] = 1
        
        for coin in coins:
            for i in range(coin, amount+1):
                ways[i] += ways[i -coin]
        
        return ways[-1]
