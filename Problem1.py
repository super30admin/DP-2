class Solution:
    def MinCost(self,costs):
        if(len(costs)==0 or len(costs[0])==0 or costs==null):
            return 0

        for i in range(1,len(costs)):
            #if second house is red
            costs[i][0]+=min(costs[i-1][1],costs[i-1][2])
            costs[i][1]+=min(costs[i-1][0],costs[i-1][2])
            costs[i][2]+=min(costs[i-1][0], costs[i-1][1])

        return min(costs[len(costs)-1][0],costs[len(costs)-1][1],costs[len(costs)-1][2])

    #TC:O(n)
    #SC:O(1)