# DP-2

## Problem1(https://leetcode.com/problems/paint-house/)
 def minCost(self, A, cost, m, n, target):
        dp, dp2 = {(0, 0): 0}, {}
        for i, a in enumerate(A):
            for cj in (range(1, n + 1) if a == 0 else [a]):
                for ci, b in dp:
                    b2 = b + (ci != cj)
                    if b2 > target: continue
                    dp2[cj, b2] = min(dp2.get((cj,b2), float('inf')), dp[ci, b] + (cost[i][cj - 1] if cj != a else 0))
            dp, dp2 = dp2, {}
        return min([dp[c, b] for c, b in dp if b == target] or [-1])
        
             

## Problem2 (https://leetcode.com/problems/coin-change-2/)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        matrix = [[0] * (1+amount) for _ in range(len(coins)+1)]
        for j in range(len(coins)+1):
            matrix[j][0] = 1
        matrix[0][0] = 1
        r = len(coins)+1
        c = amount+1
        for i in range(1,r):
            for j in range(1,c):
                if j < coins[i-1]:
                    matrix[i][j] = matrix[i-1][j]
                else:
                    matrix[i][j] = matrix[i-1][j]+matrix[i][j-coins[i-1]]
        return matrix[r-1][c-1]
        
<!-- #Time Complexity: O(m*n) m = rows, n = cols
#Space Complexity: O(n)
# Approach - Dynamic programming -> using matrix addition and previously stored values.  -->