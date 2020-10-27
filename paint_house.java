// Time Complexity : O(n) where n is the number of houses
// Space Complexity :O(1) we are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I have following doubts
                                            //1. Am I right about the time complexity, as there are only 3 colors to choose from I
                                                // am considering it as constant (please correct me)
                                            //2. I am struggling to code in the recuresive solution 


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        
        //return 0, if costs array is null or empty
        if(costs == null || costs.length ==0) return 0;

        int m = costs.length;
        
        //iterate over the costs array
        for(int i = 1; i< costs.length; i++){
                //painting current house red and the previous house as blue or green
                costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
                //painting current house blue and the previous house as red or green
                costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
                //painting current house red and the previous house as blue or green
                costs[i][2] = costs[i][2] +Math.min(costs[i-1][0], costs[i-1][1]);
        }
        
        //the minimum of the last row will give the total minimum costs of painting all the houses
        return Math.min(costs[m-1][0], Math.min(costs[m-1][1], costs[m-1][2]));
    }
}