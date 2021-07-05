class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if len(costs) == 0: return 0

        previous_row = costs[-1]
        for n in reversed(range(len(costs) - 1)):
   
            current_row = costs[n]

            # Total cost of painting nth house red
            current_row[0] += min(previous_row[1], previous_row[2])
            # Total cost of painting nth house green
            current_row[1] += min(previous_row[0], previous_row[2])
            # Total cost of painting nth house blue
            current_row[2] += min(previous_row[0], previous_row[1])
            previous_row = current_row

        return min(previous_row)
