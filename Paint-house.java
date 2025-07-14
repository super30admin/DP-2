/*
 * TC: O(m*3),m:costs lenght, colours are constant of length 3.
 * SC: O(m), m:costs lenght, colours are constant of length 3.
 * 
 * Approach: Initially, i will have 3 starting points as start painting first house with either
 * Red,Blue,GReen and return the min amoung them. Now for each starting point recurse to the next house,
 * at each recursion we have two choice for painting the next house i.e if i-1 is painted Green then RED and BLue 
 * paint can be done on the ith house and so on.Also, i am using memoization to not repeat calculating 
 * the same recursion.
 */

class Solution {
    int[][] memo;
    public int minCost(int[][] costs) {
        int m = costs.length;
        this.memo = new int[m+1][costs[0].length+1];


        int caseR = helper(m, costs,0, 0);
        int caseB = helper(m, costs,0, 1);
        int caseG = helper(m, costs,0, 2);

        return Math.min(caseR, Math.min(caseB,caseG));
    }

    private int helper(int m, int[][] costs, int i, int rgb){
        //base
        if(i == m) return 0; 
        if(memo[i][rgb] != 0) return memo[i][rgb];


        if(rgb == 0){
            memo[i][0] =  costs[i][rgb] + Math.min(helper(m,costs, i+1, 1), helper(m,costs, i+1, 2));
            return memo[i][0];}
        else if(rgb == 1){
             memo[i][1] =   costs[i][rgb] + Math.min(helper(m,costs, i+1, 0), helper(m,costs, i+1, 2));
             return memo[i][1];}
        else {
             memo[i][2] =   costs[i][rgb] + Math.min(helper(m,costs, i+1, 1), helper(m,costs, i+1, 0));
             return memo[i][2];}

    }
}