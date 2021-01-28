// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n=len(coins)+1
        m=amount+1
        dp=[[None]*m for i in range(n)]
        print(dp)
        
        for j in range(m):
            dp[0][j]=0
        for i in range(n):
            dp[i][0]=1
        for i in range(1,n):
            for j in range(m):
                if j<coins[i-1]:        //if current amount is less than the max price coin at current step then we just remove that coin
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]     //the current amount will be all combinations of both coins with and without max price coins
        return dp[n-1][m-1]
        
