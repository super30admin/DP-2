// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach-starting with the middle row checking the minimum fromthe first row

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length ==0 || costs[0].length==0)return 0;
       
           int n=costs.length;
        for(int i=1;i<n ;i++)
        {
            //R
            costs[i][0] +=Math.min(costs[i-1][1],costs[i-1][2]);
            
            //B
            costs[i][1] +=Math.min(costs[i-1][0],costs[i-1][2]);
            
            //G
            costs[i][2] +=Math.min(costs[i-1][0],costs[i-1][1]);
        }
        return Math.min(costs[n-1][0],Math.min(costs[n-1][1],costs[n-1][2]));
        
        
    }
}