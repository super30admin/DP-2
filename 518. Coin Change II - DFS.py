# Time complexity = 2^(len(coins))
# Space complexity = O(amount+len(coins))
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        return self.helper(coins,0,amount)

    def helper(self, coins , idx, amount):
        # Base
        if amount == 0:
            return 1
        if amount< 0 or idx==len(coins):
            return 0
 
        # Logic
        # Choose
        case1 =self.helper(coins,idx,amount-coins[idx])
        # Not choose
        case2 = self.helper(coins,idx+1,amount)
        return case1+case2