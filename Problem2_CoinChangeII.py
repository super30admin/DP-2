#Time Complexity:O(n*m)
#Space Complexity:O(n*m)
#LeetCode: Yes


class Solution:
    def change(self, amount, coins):
        if len(coins) == 0:
            return 0

        dp = []
        for i in range(len(coins)+1):
            dp.append([])
            for j in range(amount+1):
                dp[-1].append(0)
        
        for i in range(len(dp)):
            dp[i][0] = 1
        

        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        
        return dp[-1][-1]

obj = Solution()
nums = [1,2,5]
print(obj.change(5,nums))
