'''
Approach: Create a matrix of size(coins+1 x amount+1). If ith coins row is greater than jth amount col, copy (i-1)th col value, else add [i-1][j]th element and i[j-coins[i-1]] element.
Return the last element of last row.

Time complexity: O(amount * coins)
Space complexity:O(amount * coins)

Passes all testcases in leetcode
'''

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        print(dp)
       
        for i in range(len(dp)):
            print("entered")
            dp[i][0] = 1
            print(dp[0])
    
        for i in range(1,len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
                    
        return dp[-1][-1]
        
        
