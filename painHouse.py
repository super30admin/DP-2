"""
For each house (from the 2nd), calculate the min cost to paint it R,B,G and not the same color as previous house
Update cost by adding the min of the other 2 color from previous house.
After all houses, the answer is the min cost from 3 options for the last house.
"""
"""
Time: O(n) — One pass through all houses
Space: O(1) — In-place
"""
class paintHouse:
    def minCost(self,costs: list[list[int]]) -> int:
        if not costs:
            return 0

        n = len(costs)
        
        for i in range(1, n):
            costs[i][0] += min(costs[i-1][1], costs[i-1][2]) 
            costs[i][1] += min(costs[i-1][0], costs[i-1][2]) 
            costs[i][2] += min(costs[i-1][0], costs[i-1][1]) 

        return min(costs[-1])

if __name__=="__main__":
    obj = paintHouse()
    costs = [[17,2,17],[16,16,5],[14,3,19]]
    print(obj.minCost(costs))