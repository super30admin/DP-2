# Time Complexity : O(amount * number of coins)
# Space Complexity : O(amount)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        prev = [0]*(amount+1)
        prev[0] = 1
        
        for i in range(len(coins)):
            
            for j in range(1,amount+1):
                prev[j] = prev[j] + (0 if j-coins[i] < 0 else prev[j-coins[i]])
        return prev[amount]