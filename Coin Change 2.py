class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0]*(amount+1)
        dp[0] = 1

        for i in range(len(coins)-1,-1,-1):
            nextDp = [0]*(amount+1)
            nextDp[0] = 1
            
            for a in range(amount+1):
                nextDp[a] = dp[a]

                if a - coins[i] >= 0:
                    nextDp[a] += nextDp[a-coins[i]]
            dp = nextDp
        
        return dp[amount]

# Time complexity -> O(M * N)
# Space complexity -> O(N)
        
