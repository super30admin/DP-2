class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        '''
        Time Complexity: O(n)
        Space Complexity: O(1)
        '''
        
        # assert that the cost is not empty
        if len(costs) == 0: return 0
        
        previous_row = costs[-1]
        for n in reversed(range(len(costs) - 1)):
            current_row = costs[n]
            
            # these are the three colors that we can paint the houses
            current_row[0] += min(previous_row[1], previous_row[2])
            current_row[1] += min(previous_row[0], previous_row[2])
            current_row[2] += min(previous_row[0], previous_row[1])
            
            previous_row = current_row

        return min(previous_row)