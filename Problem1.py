"""
// Time Complexity : o(m*3)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

class Solution(object):
    """
    def helper(self, costs, r, c, min_cost): #FOR BRUTE FORCE
        
        case0 = 99999 #inf
        case1 = 99999
        case2 = 99999
        
        #base
        if r >= len(costs):
            return min_cost

        #logic
        if c == 0:
            case0 = min(self.helper(costs, r+1, 1, min_cost + costs[r][c]), # if 0 is the current index, increment the row and possible column values will be 1 and 2
                        self.helper(costs,r+1,2, min_cost + costs[r][c])) # for next column = 2
            
        if c == 1:
            case1 = min(self.helper(costs, r+1, 0, min_cost + costs[r][c]), #next column = 0
                        self.helper(costs,r+1,2, min_cost + costs[r][c])) #next column = 2
            
        if c == 2:
            case2 = min(self.helper(costs, r+1, 0, min_cost + costs[r][c]), #next column = 0
                        self.helper(costs,r+1, 1, min_cost + costs[r][c])) #next column = 1
            
        return (min(case0,case1,case2)) #minimum of the 3 cases is returned
        """   
       
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
            
        """
        BRUTE FORCE CALL      
        c0 = self.helper(costs, 0,0,0)
        c1 = self.helper(costs, 0,1,0)
        c2 = self.helper(costs, 0,2,0)
        
        return min(c0,c1,c2)
        """
        """
        DP
        """

        if not costs:
            return 0
        for i in range(1,len(costs)): #starting from the second row
            #for j in range(len(costs[0])):
                #if j==0:
            costs[i][0] = min(costs[i][0] + costs[i-1][1], costs[i][0] + costs[i-1][2]) #when current index is 0 we find min cost by adding the 2 possible values from above and choosing the minimum
            costs[i][1] = min(costs[i][1] + costs[i-1][0], costs[i][1] + costs[i-1][2])
            costs[i][2] = min(costs[i][2] + costs[i-1][0], costs[i][2] + costs[i-1][1])
        r = len(costs)-1
        
        return min(costs[r][0],costs[r][1],costs[r][2]) #minimum value in the last row is the result
        
