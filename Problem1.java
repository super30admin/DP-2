// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int minCost(int[][] costs) {
        
        if(costs == null || costs.length ==0) //check for empty elements
            return 0;
        
        int lastR = costs[0][0];  //define the first house and color Red
        int lastB = costs[0][1]; //define the first house and color Blue
        int lastG = costs[0][2];  //define the first house and color green
        int currR,currB,currG;  //current house cursor
        
        for(int i = 1;i<costs.length;i++)
        {
            //for the current house find the minimum from the previous house for all three colors
            currR = costs[i][0]+ Math.min(lastB,lastG); 
            currB = costs[i][1]+ Math.min(lastR,lastG);
            currG = costs[i][2]+ Math.min(lastB,lastR);
            

            //update the previous house to the current house before moving to the next house
            lastR = currR;
            lastB = currB;
            lastG = currG;
        }
        
        //return the minimum value when full iteration is done till the last house
        return Math.min(Math.min(lastR,lastB),lastG);
    }
}