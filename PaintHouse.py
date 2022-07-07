# Time Complexity : O(N) // We will iterate over all dp list hence it will br O(N)
#  Space Complexity : O(N) //Similary the costs array is getting updated till nth element
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach


def minCost(self, costs: List[List[int]]) -> int:
        n=len(costs)
        #If the costs list is empty or single value the return 0 or that value itself
        if n == 0: 
            return 0
        if n == 1: 
            return min(costs[0])

        #Iterate over our dp array here costs judging by taking the minimum value from such as the previous and next house is not of same color
        for i in range(1,n):
            costs[i][0]+=min(costs[i-1][1],costs[i-1][2]) #red
            costs[i][1]+=min(costs[i-1][0],costs[i-1][2]) #green
            costs[i][2]+=min(costs[i-1][1],costs[i-1][0]) #blue
        return min(costs[-1])