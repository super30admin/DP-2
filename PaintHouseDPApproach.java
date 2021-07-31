
// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Approach
1) mutate the same array and start from the second last row thus we can start calculating from the last row.
2) Once the calculalation has been completed we can go from bottom to top saving all the values and come up with the maximum value on the first row 

*/


class Solution {
    public int minCost(int[][] costs) {
     
        if(costs==null || costs.length==0)
            return 0;
        
        for(int i=costs.length-2;i>=0;i--)
        {
            costs[i][0]+=Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1]+=Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2]+=Math.min(costs[i+1][0],costs[i+1][1]);
        }
        
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
      
        
    }
    
}