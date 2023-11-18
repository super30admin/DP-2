class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        # lis=[[0 for i in range(0,len(costs[0]))] for j in range(0,len(costs))]
        # lis[len(costs)-1][0]=costs[len(costs)-1][0]
        # lis[len(costs)-1][1]=costs[len(costs)-1][1]
        # lis[len(costs)-1][2]=costs[len(costs)-1][2]

        lis=[0,0,0]
        lis[0]=costs[len(costs)-1][0]
        lis[1]=costs[len(costs)-1][1]
        lis[2]=costs[len(costs)-1][2]

        for i in range(len(costs)-2,-1,-1):
            r,g,b=lis[0],lis[1],lis[2]
            lis[0]=costs[i][0]+min(lis[1],lis[2])
            lis[1]=costs[i][1]+min(r,lis[2])
            lis[2]=costs[i][2]+min(r,g)

        print(lis)

        return min(lis[0],lis[1],lis[2])
        