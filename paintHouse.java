//Time Complexity : O(m)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution{
    public int minCost(int[][] costs){
        //base case- if the array and its length is empty
        if(costs==null||costs.length==0)
            return 0;
        //initalize the 2D array
        int[][] k=new int[costs.length][3];
        //iterating over the 3 columns
        for(int j=0;j<3;j++){
            k[costs.length-1][j]=costs[costs.length-1][j];
        }
        //iterating over the matrix from 2nd last row in the matrix in bottom-up approach
        for(int i=costs.length-2;i>=0;i--){
            k[i][0]=costs[i][0]+Math.min(k[i+1][1], k[i+1][2]);
            k[i][1]=costs[i][1]+Math.min(k[i+1][0], k[i+1][2]);
            k[i][2]=costs[i][2]+Math.min(k[i+1][1], k[i+1][0]);
        }
        //returning the min value
        return Math.min(k[0][0], Math.min(k[0][1],k[0][2]));
    }
}