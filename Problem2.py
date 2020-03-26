#
# Time complexity O(nk) 
# Space complexity O(n) 
# Works on leetcode
#
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        memo = [0]*(amount+1)
        memo[0] = 1
        for i in range(len(coins)):
            for j in range(amount+1):
                if j+coins[i] <= amount:
                    memo[j+coins[i]] += memo[j]

        return memo[-1]
