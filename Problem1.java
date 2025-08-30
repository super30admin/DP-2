// Time Complexity : O(n) - due to memoization of n * 3 subproblems.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Idea is to first paint first house using all three colors
Recursively iterate over all the houses choose he cheapest costs from other colors
Store the already computed resultes in memo table
*/

class Main {
    int[][] memo;
    public int minCost(int[][] costs) {
        int n = costs.length; //total number of houses
        this.memo = new int[n][3];
        int colorR = helper(costs, 0, 0);
        int colorB = helper(costs, 0, 1);
        int colorG = helper(costs, 0, 2);
        return Math.min(colorR, Math.min(colorB, colorG));
    }
    //i -> house index
    private int helper(int[][] costs, int i, int color) {
        //base
        if(i==costs.length) return 0;
        if(memo[i][color] != 0) return memo[i][color];
        //logic
        int res = 0;
        if(color == 0) { //color is Red
            int case1 = helper(costs, i+1, 1);
            int case2 = helper(costs, i+1, 2);
            res= costs[i][0] + Math.min(case1, case2);
        } else if(color == 1) {// color is Blue
            int case1 = helper(costs, i+1, 0);
            int case2 = helper(costs, i+1, 2);
            res =  costs[i][1] + Math.min(case1, case2);
        } else {//color is Green
            int case1 = helper(costs, i+1, 0);
            int case2 = helper(costs, i+1, 1);
            res = costs[i][2] + Math.min(case1, case2);
        }
        memo[i][color] = res;
        return res;
    }
    public static void main(String[] args) {
         int[][] costs = new int[][] {
            {14, 2, 11},
            {11, 14, 5},
            {14, 3, 10}
        };
       Main solution = new Main();
        int res = solution.minCost(costs);
        System.out.println("Minimum cost to paint houses = " + res);
    }
}
