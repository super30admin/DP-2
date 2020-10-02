# Time Complexity: O(N)
# Space Complexity: O(1)
# Leetcode all test cases passed: Yes
# Any difficulties: No

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if not costs:
            return 0
        
        numberHouse = len(costs)
        
        lastR = costs[0][0]
        lastB = costs[0][1]
        lastG = costs[0][2]
        
        for i in range(1,numberHouse):
            currR = costs[i][0] + min(lastB, lastG)
            currB = costs[i][1] + min(lastR, lastG)
            currG = costs[i][2] + min(lastR, lastB)
            
            lastR = currR
            lastB = currB
            lastG = currG
        return min(lastR, lastB, lastG)
                
