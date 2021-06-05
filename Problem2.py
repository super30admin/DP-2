# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#saving count considering one by one coin

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if amount == 0:
            return 1
        a = len(coins) + 1
        b = amount + 1
        arr = [[1 if j==0 else 0 for j in range(b)] for i in range(a)]
        
        
        for i in range(1,a):
            coin = coins[i-1]
            for j in range(1,b):
                if j < coin:
                    arr[i][j] = arr[i-1][j]
                else:
                    arr[i][j] = arr[i-1][j] + arr[i][j-coin]
        return arr[a-1][b-1]