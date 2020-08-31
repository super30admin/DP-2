// Time Complexity : O(N) - iterate over length of array
// Space Complexity : O(1) - No extra space used
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// find the minimum costs for each color chosen for previous step (besides that color) and add to the current chosen color
// do it for all the possible combinations 
// at the end we will get the costs of all the paths. select the minimum cost path

class Solution {
    public int paintHouse(int[][] costs) {        
        if(costs == null || costs.length ==0)
            return 0;
        
        for(int i =1;i<costs.length;i++) {
        	costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
        	costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
        	costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
        }
        
        return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));
            
    }
}