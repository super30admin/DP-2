#Time Complexity is O(n)
#Space Complexity is O(1)
#Premium account is required for this code execution, but this ran successfully when compiled
#Faced no problemss while coding this problem

#to calculate the minimum cost to paint all houses
class Solution:
    def minCost(self, costs):
        #if the cost array is empty, then return 0
        if(costs==None or len(costs)==0):
            return 0
        self.n=len(costs)
        #creating a 2D array of size nx3
        self.dp=[[0 for i in range(0,self.n)] for i in range(0,3)]
        #storing the initial values of Red, Blue and Green in 3 different variables
        self.costR=costs[self.n-1][0]
        self.costB=costs[self.n-1][1]
        self.costG=costs[self.n-1][2]
        for i in range(self.n-2,-1,-1):
            #Based on the color index, we will be finding the minimum value of the remaining two colors 
            self.tempR=self.costR
            self.costR=costs[i][0]+min(self.costB,self.costG)
            self.tempB=self.costB
            self.costB=costs[i][1]+min(self.tempR,self.costG)
            self.costG=costs[i][2]+min(self.tempR,self.tempB)
        #At last we will be returning the minimum value among the costR, costB and costG
        return min(self.costR,min(self.costB,self.costG))