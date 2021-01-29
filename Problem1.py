"""
256. Paint House
Time Complexity - O(n)
Space Complexity - O(1)
Verify if costs,costs first row and value are valid
Then iterate to each row and calculate the min costs required for each sequence
"""
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == None or len(costs) == 0 or len(costs[0]) == 0:
            return 0
        for i in range(1,len(costs)):
            
            "Red"
            costs[i][0] = costs[i][0] + min(costs[i-1][1],costs[i-1][2])
            "Blue"
            costs[i][1] = costs[i][1] + min(costs[i-1][0],costs[i-1][2])
            "Green"
            costs[i][2] = costs[i][2] + min(costs[i-1][0],costs[i-1][1])
            
        return min(costs[len(costs)-1][0],costs[len(costs)-1][1],costs[len(costs)-1][2])