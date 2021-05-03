class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        if not coins:
            return 0
        
        dp = [[0 for j in range(amount+1)] for i in range(len(coins)+1)]
        
        for i in range (0, len(dp)):
            dp[i][0] = 1
        
        print(dp)
        
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                
                if coins[i-1]>j:
                    print("in")
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        
        return dp[len(dp)-1][len(dp[0])-1]
    
#  Approach is to make dp for the recursive solution. catch here is to initialize all elements with of the matrix as 0 first.
#  that happens by itself in JAVA, but not in Python
#  Similar like coin change 1, time complexity is O(nk) -> n is no of coins and k is amount.
                                  
