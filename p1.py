#TC = o(n)
#Sc = O(n)
# successfully submitted on leetcode: Yes





class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        #null case
        if len(costs) == 0:
            return 0
        
        rows = len(costs) #3
        cols = 3 
        #create an new array 
        arr = [[0 for i in range(cols)] for j in range(rows)]

        #fill bottom row with original value in costs
        for j in range(0, len(arr[0])):
            arr[rows-1][j] = costs[rows-1][j]
        
        #fill the rest of the boxes in the array
        #starting from second to bottom, and going up 
        for i in range(rows-2,-1,-1):
            #choose cols[0] color
            arr[i][0] = costs[i][0] + min(arr[i+1][1],arr[i+1][2])
            #choose cols[1] color
            arr[i][1] = costs[i][1] + min(arr[i+1][0],arr[i+1][2])
            #choose cols[2] color
            arr[i][2] = costs[i][2] + min(arr[i+1][1],arr[i+1][0])

        #answer if the top row minimal value
        ans = min(arr[0][0], arr[0][1], arr[0][2])
        return ans