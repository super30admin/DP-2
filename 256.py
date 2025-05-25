'''
recursive:
time - 2^n
space = O(1)
dp:
space - O(n)
time - O(n)
'''
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        # red =  self.paintRecursive(costs,0, 0)
        # blue = self.paintRecursive(costs, 0, 1) 
        # green = self.paintRecursive(costs, 0, 2)
        # return min(red,blue,green)
        return self.paintdp(costs)

    def paintdp(self,costs):
        nhouses = len(costs)
        ncolors = len(costs[0])
        dp = [[0]*ncolors for _ in range(nhouses)]
        for j in range(ncolors):
            dp[0][j] = costs[0][j]
        for i in range(1, nhouses):
            for j in range(ncolors):
                if j==0:
                    dp[i][j] = min(costs[i][j]+dp[i-1][1], costs[i][j]+dp[i-1][2])
                elif j==1:
                    dp[i][j] = min(costs[i][j]+dp[i-1][0], costs[i][j]+dp[i-1][2])
                elif j==2:
                    dp[i][j] = min(costs[i][j]+dp[i-1][0], costs[i][j]+dp[i-1][1])

        return min(dp[nhouses-1])

    def paintRecursive(self, costs, house, color):
        if house >=len(costs):
            return 0

        cost = -1
        if color==0:
            cost = costs[house][color] + min(self.paintRecursive(costs, house+1,1),self.paintRecursive(costs, house+1,2))
        if color==1:
            cost = costs[house][color] + min(self.paintRecursive(costs, house+1,0),self.paintRecursive(costs, house+1,2))
        if color==2:
            cost = costs[house][color] + min(self.paintRecursive(costs, house+1,0),self.paintRecursive(costs, house+1,1))
        return cost

