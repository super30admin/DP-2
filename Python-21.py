
#leet code: house paint
#time complexity: o(N)
#Approach: First row remains the same and while calulating the second row  for red it takes the minimum of previous rows blue and green values + cost for painting red.


def minCost(self, costs):
        # write your code here
        r=len(costs)
        c=len(costs[0])
        dp=[[0]*c for _ in range(r)]
        dp[0][0]=costs[0][0]
        dp[0][1]=costs[0][1]
        dp[0][2]=costs[0][2]
        
        #edge case
        if (costs == [] or len(costs) == 0):
             return 0
        
        n=len(dp)
        for i  in range(1,n):
            dp[i][0]=min(dp[i-1][1],dp[i-1][2])+costs[i][0]
            dp[i][1]=min(dp[i-1][0],dp[i-1][2])+costs[i][1]
            dp[i][2]=min(dp[i-1][0],dp[i-1][1])+costs[i][2]
        return min(dp[n-1][0],min(dp[n-1][1],dp[n-1][2]))
            
