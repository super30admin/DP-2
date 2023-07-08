// Time Complexity : O(3*n) from solution 2 and 3
// Space Complexity : O(1) if in space method followed.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Solution 1: Painthouse Problem with brute force approach
// Time Complexity : 3*2^n
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null) return -1;
        int n = costs.length;

        int costR = helper(costs, 0, 0, 0);
        int costB = helper(costs, 0, 1, 0);
        int costG = helper(costs, 0, 2, 0);

        return Math.min(costR, Math.min(costB, costG));
        
    }

    private int helper(int[][] costs, int idx, int color, int minCost) {

        //base case

        if(idx == costs.length) return minCost;

        if(color == 0) {
            return Math.min(helper(costs, idx+1, 1, minCost + costs[idx][0]),
                     helper(costs, idx+1, 2, minCost + costs[idx][0]));
        } 
        
        if (color == 1) {
            return Math.min(helper(costs, idx+1, 0, minCost + costs[idx][1]),
                     helper(costs, idx+1, 2, minCost + costs[idx][1]));
        }

        if (color == 2) {
            return Math.min(helper(costs, idx+1, 0, minCost + costs[idx][2]),
                     helper(costs, idx+1, 1, minCost + costs[idx][2]));
        }

        return 99999;
        
    }
}

// Solution 2: Painhouse Problem with DP exhausitive 2d array approach.
// Time Complexity : O(3*n) or else O(m*n) where m is the number of colors
// & n is the number of houses to be painted
//Space Complexity: inplace method so O(1)

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null) return -1;
        int n = costs.length;

        for(int i = n-2; i>=0; i--) {
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);

        }
        
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}

// Solution 3: Painhouse Problem with DP 2d array approach and print of paths taken
// Time Complexity : O(3*n)
//Space Complexity: O(3*n)
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null) return -1;
        int n = costs.length; // rows = no. of houses
        int m = costs[0].length; //columns = colors
        int[][] path = new int[n][m];
        path[n-1][0] = 0;
        path[n-1][1] = 0;
        path[n-1][2] = 0;

        for(int i = n-2; i>=0; i--) {

            if(Math.min(costs[i+1][1], costs[i+1][2]) == costs[i+1][1]) {
                 path[i][0] = 1;
            }else{
                path[i][0] = 2;
            }
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);

            if(Math.min(costs[i+1][0], costs[i+1][2]) == costs[i+1][0]) {
                 path[i][1] = 0;
            }else{
                path[i][1] = 2;
            }

            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);

            if(Math.min(costs[i+1][0], costs[i+1][1]) == costs[i+1][0]) {
                 path[i][2] = 0;
            }else{
                path[i][2] = 1;
            }
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);

        }

        System.out.println(Arrays.deepToString(path));
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}