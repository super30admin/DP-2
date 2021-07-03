class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        #Find all possible combinations
        arr=[[0 for _ in range(3)] for _ in range(len(costs))]
        #fill the first row
        arr[0][0]=costs[0][0]
        arr[0][1]=costs[0][1]
        arr[0][2]=costs[0][2]
        for i in range(1,len(costs)):
            arr[i][0]=min(arr[i-1][1],arr[i-1][2])+costs[i][0]
            arr[i][1]=min(arr[i-1][0],arr[i-1][2])+costs[i][1]
            arr[i][2]=min(arr[i-1][0],arr[i-1][1])+costs[i][2]
        return min(arr[len(arr)-1][0],arr[len(arr)-1][1],arr[len(arr)-1][2])
#Time: O(n)
#Space O(nm)
#https://leetcode.com/problems/paint-house/
#Ran successfully
