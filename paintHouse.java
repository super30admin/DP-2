// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Yes , to come up with a solution where we dont want to hard code values for j


// Your code here along with comments explaining your approach
// In this approach we are starting from the position 1 of the array of arrays and for each element in that sub array , we compare the 
// the previous sub arrays elements which are not as the same index as the one we are checking and update that position where the sum in 
// minimum when adding with previous sub array's elements. We do this until we reach the last sub array and get the minmum of all the elements
// from that.
class Solution {
    public int minCost(int[][] costs) {
        
        if(costs == null || costs.length == 0 || costs[0].length == 0)
        {
            return 0;
        }
        int n = costs.length;
        int m = costs[0].length;
        
        for(int i = 1;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
            //choosing red
            costs[i][j] = costs[i][j] + Math.min(costs[i-1][(j+1)%m],costs[i-1][(j+2)%m]);
          
            }
        }
        
        return Math.min(costs[n-1][0],Math.min(costs[n-1][1],costs[n-1][2]));
    
    }
}