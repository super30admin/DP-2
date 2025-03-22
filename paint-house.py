'''
Use bottom-up DP with constant space, updating costs for each house while ensuring no two adjacent houses have the same color.
Compute the minimum cost for each color choice and return the smallest final cost.

Time Complexity: O(m) (iterate through houses once)
Space Complexity: O(1) (only three variables used)
'''
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        m, n = len(costs), len(costs[0])
        colorR, colorB, colorG = costs[m-1][0], costs[m-1][1], costs[m-1][2]

        for i in range(m-2, -1,-1):
            tempR, tempB = colorR, colorB

            colorR = costs[i][0] + min(colorB, colorG)
            colorB = costs[i][1] + min(tempR, colorG)
            colorG = costs[i][2] + min(tempR, tempB)
        
        return min(colorR, colorB, colorG)
