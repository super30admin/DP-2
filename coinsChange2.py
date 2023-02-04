class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        #Here we use DP appraoch. for current cell if the denomination of coin is less than amount(j) 
        #then we take value from above cell. Else we take sum of value from above cell and value 
        #from cell coins[i] steps back.
        #Time complexity = O(m*n) where m=no .of coins, n=amount
        #Space complexity = O(n)
        if not coins:
            return 0

        m = len(coins)
        n = amount
        dp = [0]*(amount+1)

        dp[0] = 1

        for i in range(1, m+1):
            for j in range(n+1):
                if j>=coins[i-1]:
                    dp[j] = dp[j]+dp[j-coins[i-1]]
        return dp[n]



#--------------------------------OR--------------------------------------


        #Here we go for recurrsion, exhaustive approach 
        #Time and space complexity - O(2^(m+n)) where m = no. of coins, n = amount
    class Solution:
        def change(self, amount: int, coins: List[int]) -> int:

            if not coins:
                return 0

            return self.helper(coins, amount, 0)

        def helper(self, coins, amt, idx):
            if idx>=len(coins) or amt<0:
                return 0
            if amt==0:
                return 1
            
            case1 = self.helper(coins, amt-coins[idx], idx)
            case0 = self.helper(coins, amt, idx+1)

            return case0+case1


