#Time Complexity:O(n)
#Space Complexity:O(1)
class Solution(object):
    def house(self,costs):
        for i in range(len(costs)-2,-1,-1):
            costs[i][0]=costs[i][0]+min(costs[i+1][1],costs[i+1][2])
            costs[i][1]=costs[i][1]+min(costs[i+1][0],costs[i+1][2])
            costs[i][2]=costs[i][2]+min(costs[i+1][1],costs[i+1][0])
        return(min(costs[0]))
a=Solution()
print(a.house([[17,2,17],[16,16,5],[14,3,19]]))
