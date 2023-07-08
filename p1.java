// Time Complexity : Time coplexity would be O(m * n) where m is 3. So O(n)
// Space Complexity : Space coplexity is constant O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        // Creating variable to store the minimum costs
        int costr = costs[0][0];
        int costg = costs[0][1];
        int costb = costs[0][2];

        //Iterating over all the houses
        for (int i=1; i<costs.length; i++){
            //Storing minimum costs in a temp variable
            int tempr = costr;
            int tempg = costg;

            //Calculating which path is minimum uptill now
            costr =  costs[i][0] + Math.min(costg, costb);
            costg =  costs[i][1] + Math.min(tempr, costb);
            costb =  costs[i][2] + Math.min(tempr, tempg);
        }
        
        // Getting the path with minimum cost
        return Math.min(costr, Math.min(costg, costb));
    }
}