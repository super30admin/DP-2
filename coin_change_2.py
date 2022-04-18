class Solution:
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
         Time Complexity : O(m*n)
         Space Complexity : O(n)
        """
        dp = [[0] * (amount+1) for _ in range(len(coins)+1)]

        for i in range(len(dp)):
            dp[i][0] = 1
        # print(dp)
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        # print(dp)
        return dp[-1][-1]
    
    
    def BruteForcechange(self, amount: int, coins: List[int]) -> int:
        if not coins: return 0 
        return self.BruteForcehelper( coins, amount , 0)
    
    def BruteForcehelper(self, coins , target , idx  ):
        if target == 0 :
            return 1 
        if target < 0 or idx == len(coins):
            return 0 
        # choosen a coin 
        case1 = self.BruteForcehelper( coins , target - coins[idx] , idx )
        # not choosen a coin
        case2 = self.BruteForcehelper( coins , target , idx+1 )
        return case1 + case2
                    
        
