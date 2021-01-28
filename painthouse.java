// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : understood from the class


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        if(costs== null || costs.length==0 || costs[0].length ==0 ) // base case
        {return 0;}
        
        int n= costs.length;

        // instead of hard coding th ebelow case we can also use a for loop
        for(int i=1; i<n;i++){
            // color red
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            
            // color green
             costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            
            // color blue
             costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }
        
       return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2])); 
    
    }
}