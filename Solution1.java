// Time Complexity :O(mn) m=number of houses ,n=number of colors
// Space Complexity :O(1) did not use any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution1 {
    
    public int minCost(int[][] costs) {
        //if the array is empty
        if(costs==null||costs[0].length==0)
            return -1;
       int n=costs.length;
        //if more than one house to paint
        if(n>1){
            //picking up the min from the available choices from the last house
            // and then moving up
        for(int i=n-2;i>=0;i--){
            costs[i][0]=costs[i][0]+Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1]=costs[i][1]+Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2]=costs[i][2]+Math.min(costs[i+1][0],costs[i+1][1]);
        }
        }
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}
