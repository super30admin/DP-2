'''
Approach: Following bottom up approach, takes costs of all last row elements in three variable. Now iterate from i-1 th row to 0th row. For r, b, g variables in each row, check the min cost from next row and add to corresponding variables. In the end return min of r, b, and g

Time complexity: O(N) as column length is constant
Space complexity:O(1)

Passes all testcases in leetcode


'''


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        if n == 0: return 0
        
        rCost = costs[n-1][0]
        bCost = costs[n-1][1]
        gCost = costs[n-1][2]
        
        print(rCost,bCost,gCost)
        
        for i in range(n-2,-1,-1):
            tempR = rCost
            tempB = bCost
            rCost = costs[i][0] + min(bCost,gCost)
            bCost = costs[i][1] + min(tempR,gCost)
            gCost = costs[i][2] + min(tempR,tempB)
            
        return min(rCost,bCost,gCost)
        
