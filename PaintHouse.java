// Time Complexity : O(n) where n is number of houses, since here we have only 3 paint choices, min of 2 elements is O(1)
// Space Complexity : O(1), no additional space is actually being used, as we are building up and modifying on the original costs array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : initially came up with a greedy approch where I was picking the least cost one and storing the choice of the previous house paint,
//then would make the new choice greedily but that did not pass test cases


// Your code here along with comments explaining your approach
//Idea is to just build up in a bottom up manner, what would be the min cost if we made the choice of choosing to paint the i-th house with that paint 

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0){
            return 0;
        }
        
        for(int i=1;i<costs.length;i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
       
        return Math.min((Math.min(costs[costs.length-1][0], costs[costs.length-1][1])), costs[costs.length-1][2]);
    }
}