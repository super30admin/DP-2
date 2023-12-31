class Solution:
    def helper(self, coins, amount, i, memo):
        #base
        if (amount, i) in memo:
            return memo[(amount, i)]
        
        if amount == 0:
            return 1
        if amount < 0 or i >= len(coins):
            return 0
        
        case1 = self.helper(coins, amount - coins[i], i, memo)
        case2 = self.helper(coins, amount, i + 1, memo)
        
        memo[(amount, i)] = case1 + case2
        
        return memo[(amount, i)]
    
    def change(self, amount: int, coins: List[int]) -> int:
        
        memo = {}
        if coins is None:
            return 0
        
        return self.helper(coins, amount, 0, memo)
