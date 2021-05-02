class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        if not coins:
            return -1
        
        return self.helper(amount, coins, 0)
    
    def helper(self, amount:int, coins:List[int], index:int):
        
        if amount == 0:
            return 1
        
        if amount<0 or index==len(coins):
            return 0
        
#         choose
        caseChoose = self.helper(amount-coins[index],coins, index)
#         dont choose
        caseDontChoose = self.helper(amount, coins, index+1)
        
        return caseChoose+caseDontChoose

    
#  recusrive approach choosen, looking at all possible solutions. time complexity is exponential.
        
