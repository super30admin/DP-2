from typing import List
# Time Complexity : O(3*n), Where n is the count of all houses
# Space Complexity : O(3*n), Where n is the count of all houses
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

class Solution:
    def actualsol(self,index,currnt,costs,memo)->int:
        if(index==len(costs)):
            return 0
        if(memo[index][currnt]!=None):
            return memo[index][currnt]
        #pick the next based on currnt
        if(currnt==0):
            #we have to choice between blue,green in the next step
            choice1=costs[index][0]+self.actualsol(index+1,1,costs,memo)
            choice2=costs[index][0]+self.actualsol(index+1,2,costs,memo)
        if(currnt==1):
            #we have to choice between red,green in the next step
            choice1=costs[index][1]+self.actualsol(index+1,0,costs,memo)
            choice2=costs[index][1]+self.actualsol(index+1,2,costs,memo)
        if(currnt==2):
            choice1=costs[index][2]+self.actualsol(index+1,0,costs,memo)
            choice2=costs[index][2]+self.actualsol(index+1,1,costs,memo)
        memo[index][currnt]=min(choice1,choice2)
        return min(choice1,choice2)
    def minCost(self, costs: List[List[int]]) -> int:
        
        memo=[[None for i in range(3)] for j in range(len(costs))]
        #print(memo)
        choice1= self.actualsol(0,0,costs,memo)   
        choice2= self.actualsol(0,1,costs,memo)
        choice3= self.actualsol(0,2,costs,memo)
        #print(memo)
        return min(choice1,choice2,choice3)