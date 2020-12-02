/*
# Recursive
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs is None or len(costs) == 0:
            return 0
        
        def helper(costs, rows, color, cost_till_now):
            if rows == len(costs)-1:
                return cost_till_now
            
            case1 = float('inf')
            case2 = float('inf')
            case3 = float('inf')
            
            if color == 0:
                case2 = helper(costs, rows + 1, 1, cost_till_now + costs[rows + 1][1])
                case3 = helper(costs, rows + 1, 2, cost_till_now + costs[rows + 1][2])
            elif color == 1:
                case1 = helper(costs, rows + 1, 0, cost_till_now + costs[rows + 1][0])
                case3 = helper(costs, rows + 1, 2, cost_till_now + costs[rows + 1][2])
            else:
                case1 = helper(costs, rows + 1, 0, cost_till_now + costs[rows + 1][0])
                case2 = helper(costs, rows + 1, 1, cost_till_now + costs[rows + 1][1])
            return min(case1, min(case2, case3))
        
        case1 = helper(costs, 0, 0, costs[0][0])
        case2 = helper(costs, 0, 1, costs[0][1])
        case3 = helper(costs, 0, 2, costs[0][2])
        
        return min(case1, min(case2, case3))

# DP
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs is None or len(costs) == 0:
            return 0
        
        rows = len(costs)
        for i in range(1, rows):
            costs[i][0] = costs[i][0] + min(costs[i-1][1], costs[i-1][2])
            costs[i][1] = costs[i][1] + min(costs[i-1][0], costs[i-1][2])
            costs[i][2] = costs[i][2] + min(costs[i-1][0], costs[i-1][1])
        
        return min(costs[rows-1][0], min(costs[rows-1][1], costs[rows-1][2]))
*/

// Time Complexity : O(rows)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Mutated the cost array by storing the sum there itself. Started from 1st row

class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        
        int rows = costs.length;
        for (int i=1; i<rows; i++){
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(costs[rows-1][0], Math.min(costs[rows-1][1], costs[rows-1][2]));
    }
}