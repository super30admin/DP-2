#TimeComplexity:O(N) --N is no of rows
#SpaceComplexity: Space for DP 2D array 
#Did this code successfully run on Leetcode : Didn't Check 
#Any problem you faced while coding this : No
class housePaint():
    def housePaint1(self,costs):
        if len(costs[0]==0):
            return 0
        for i in range(1,len(costs[0])):
            costs[i][0]=costs[i][0]+min(costs[i-1][1],costs[i-1][2])
            costs[i][1]=costs[i][1]+min(costs[i-1][0],costs[i-1][2])
            costs[i][2]=costs[i][2]+min(costs[i-1][1],costs[i-1][0])
        return min(costs[-1])
            
    
    
    
    
    
    
    
x=housePaint()
print(x.housePaint1([[17,2,17],[16,16,5],[14,3,19]]))
