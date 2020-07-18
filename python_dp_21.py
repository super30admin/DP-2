#time complexity: o(n)
#space complexity : o(n)
class Solution():
    def mincost(self,costs): #costs is amtrix
        # edge case
        self.costs=costs
        if self.costs == [] or len(self.costs) == 0:
            return 0
        dp = self.costs
        #dp[0][0]= self.costs[0][0]
        #dp[0][1]= self.costs[0][1]
        #dp[0][2] = self.costs[0][2]
        #print(dp)
        for i in range(1,len(dp)):
            #print(dp[i][0],dp[i][1],dp[i][2])
            dp[i][0] = min(dp[i-1][1],dp[i-1][2])+self.costs[i][0]
            dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + self.costs[i][1]
            dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + self.costs[i][2]
            #print(dp[i][0], dp[i][1], dp[i][2])
            #print(dp)

        return min(dp[len(dp)-1][0],dp[len(dp)-1][1],dp[len(dp)-1][2])
v= Solution()
a=[[17,2,17],[16,16,5],[14,3,19]]
print(v.mincost(a))






