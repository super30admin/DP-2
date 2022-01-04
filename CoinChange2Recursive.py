# // Time Complexity : 2^N
# // Space Complexity : 2^N
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins == None:
            return 0
        return self.helper(amount, coins, 0)
    
    def helper(self,amount, coins, index):
        if amount == 0: 
            return 1
        if amount < 0 or index == len(coins):
            return 0
        
        #choose a coin
        case1 = self.helper(amount - coins[index],coins,index)
        #not choose a coin
        case2 = self.helper(amount, coins, index+1)
        
        return case1 + case2