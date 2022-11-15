#Time Complexity: O(m*n)
#Space Complexity: O(1)

class Solution:
    def cost(costs: list(list(int)))->int:
        if len(costs)==0:
            return 0
        houses = len(costs)
        for i in range(houses-2,-1,-1):
            for j in range(0,3):
                if j==0:
                    costs[i][j]+=min(costs[i+1][j+1],costs[i+1][j+2])
                elif j==1:
                    costs[i][j]+=min(costs[i+1][j-1],costs[i+1][j+1])
                else:
                    costs[i][j]+=min(costs[i+1][j-1],costs[i+1][j-2])
        return min(costs[0])