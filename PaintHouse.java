// Time Complexity : Exponential
// Space Complexity : O(n) In the worst case the maximum depth of recursion is n.
// Did this code successfully run on Leetcode : Time limit exceeded
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * Exahuastive search(recurssion) using DO NOT CHOOSE CHOOSE method.
 * Not choose or choose: if color is RED, we increase index and add costs for green 
 * and similarly for blue and Pick min of two. We do this for all colors.
 * Base case: If index is equal to length return costs.
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length < 1) {
            return 0;
        }
        int caseR = recurse(costs, 0, 0, 0);
        int caseB = recurse(costs, 0, 1, 0);
        int caseG = recurse(costs, 0, 2, 0);
        return Math.min(caseR, Math.min(caseB, caseG));
    }

    private int recurse(int[][] costs, int index, int color, int cost) {
        //Base case
        if(index == costs.length) {
            return cost;
        }
        //Logic: EXHAUSTIVE APPROACH
        if(color == 0){
            int case1 = recurse(costs, index + 1, 1, cost + costs[index][0]);
            int case2 = recurse(costs, index + 1, 2, cost + costs[index][0]);
            return Math.min(case1, case2);
        } else if (color == 1){
            int case1 = recurse(costs, index + 1, 0, cost + costs[index][1]);
            int case2 = recurse(costs, index + 1, 2, cost + costs[index][1]);
            return Math.min(case1, case2);
        } else {
            int case1 = recurse(costs, index + 1, 0, cost + costs[index][2]);
            int case2 = recurse(costs, index + 1, 1, cost + costs[index][2]);
            return Math.min(case1, case2);
        }
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * We use BOTTOM UP aproach and mutate same grid, we start fron second last row(n-2) and fill values with
 * current cost of that cell + min between blue or green(if current color is red) and  calculate same for all colors.
 * In the end return minimum of 1st row. 
 */

class PaintHouseDp {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length < 1) {
            return 0;
        }
        int n = costs.length;
        for(int i = n - 2; i >= 0; i--){
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}
