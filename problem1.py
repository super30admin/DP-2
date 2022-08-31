'''
256. Paint House

TIME COMPLEXITY: O(N) len of houses
SPACE COMPLEXITY: O(1)
LEETCODE: Yes
DIFFICULTY: Nope, I solved this after the class.
'''

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        for i in range(1,n):
            costs[i][0] = min(costs[i-1][1]+costs[i][0], costs[i-1][2]+costs[i][0])
            costs[i][1] = min(costs[i-1][0]+costs[i][1], costs[i-1][2]+costs[i][1])
            costs[i][2] = min(costs[i-1][0]+costs[i][2], costs[i-1][1]+costs[i][2])
        
        return min(costs[n-1][0], costs[n-1][1], costs[n-1][2])        
             
        
