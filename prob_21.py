# Dynamic Programming
# passed all test cases
# time complexity =O(n)
#space complexity=O(1)
class Solution():
    def mincost(self,costs): #costs is amtrix
        #edge case
        if costs== [] or len(costs) == 0:
            return 0

        #self.costs = costs
        last_red= costs[0][0]

        last_blue = costs[0][1]

        last_green = costs[0][2]

        for i in range(1,len(costs)):
            last_red,last_blue,last_green = min(last_blue,last_green)+costs[i][0],min(last_red,last_green)+costs[i][1],min(last_blue,last_red)+costs[i][2]
        return min(last_blue,last_green,last_red)
v= Solution()
a=[[17,2,17],[16,16,5],[14,3,19]]
print(v.mincost(a))


