
class Solution:

    """
    Recursive exhastive approach
    TC - O(N)
    SC - O(N)
    """
    def helper(self,costs,row,color,minCosts):
        if color == 0:
            return min(self.helper(costs,row+1,1,minCosts + costs[row][color]), self.helper)

    def approach1(self,costs):
        red = self.helper(costs,0,0,0)
        green = self.helper(costs,0,1,0)
        blue = self.helper(costs,0,2,0)
        return min(red,green,blue)

    """
    DP approach
    TC - O(nxm)
    SC - O(1)
    """
    def approach2(self,costs):
        for i in range(len(costs)-2,-1,-1):
            costs[i][0] += min(costs[i+1][1],costs[i+1][2])
            costs[i][1] += min(costs[i+1][0],costs[i+1][2])
            costs[i][2] += min(costs[i+1][1],costs[i+1][0])
        return min(costs[0][0],costs[0][1], costs[0][2])

    def painting(self,costs):
        if not costs or costs is None:
            return -1
        # return self.approach1(costs)
        return self.approach2(costs)

painr = Solution()
print(painr.painting([[17,2,17],[16,16,5],[14,3,19]]))

