# Time Complexity: O(N * A) N is the amount and A is the number of coins
# Space Complexity: O(N) 
# Did not pass Leetcode 

class Solution:
    
    def recurse(self, amount, coins):
        print(amount, self.m)
        if amount == 0:
            self.count += 1
            return 1
        if amount < 0:
            return 0
        
        total_ways = 0
        for coin in coins:
            
            curr_amount = amount - coin
            if curr_amount in self.m:
                if self.m[curr_amount] > 0:
                    total_ways += self.m[curr_amount] + 1
                                    
            else:
                total_ways += self.recurse(curr_amount, coins)
        
        self.m[amount] = total_ways
        return total_ways
            
    
    def change(self, amount: int, coins: List[int]) -> int:
        
        self.m = {}
        self.count = 0
        self.recurse(amount, coins)
        
        return self.count